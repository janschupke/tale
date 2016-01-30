package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Obstacle;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.ParticleEffectContainer;

import java.util.*;

/**
 * Base class for levels' world representations.
 */
public abstract class BaseWorld {
    protected World boxWorld;
    protected Box2DDebugRenderer debugRenderer;
    protected TiledMap map;
    protected OrthogonalTiledMapRenderer renderer;
    private Vector2 spawnPoint;
    private float width;
    private float height;

    private Unit playerUnit;
    private List<Unit> units;
    private List<Item> items;
    private List<Obstacle> obstacles;

    private Map<String, ParticleEffectContainer> particleEffects;
    private Array<ParticleEffectPool.PooledEffect> pooledEffects;

    public BaseWorld(String tiledMap, float tileSize) {
        map = new TmxMapLoader().load(tiledMap);
        renderer = new OrthogonalTiledMapRenderer(map, 1 / tileSize);

        MapProperties prop = map.getProperties();
        width = prop.get("width", Integer.class);
        height = prop.get("height", Integer.class);

        handleAnimatedTiles();

        spawnPoint = new Vector2(0, 0);
        units = new ArrayList<>();
        items = new ArrayList<>();
        obstacles = new ArrayList<>();
        particleEffects = new HashMap<>();
        pooledEffects = new Array();
        debugRenderer = new Box2DDebugRenderer();
    }

    protected void init() {
        initPlayer();
        initCreatures();
        initItems();
        initObstacles();
        initEffects();
    }

    protected abstract void initPlayer();
    protected abstract void initCreatures();
    protected abstract void initItems();
    protected abstract void initObstacles();
    protected abstract void initEffects();

    /**
     * Effect initializer.
     * @param effectName Name of the effect.
     * @param filename Name of the effect file.
     * @param particleFolder Folder location of the particle.
     * @param scale Scale of the final effect.
     */
    public void initEffect(String effectName, String filename, String particleFolder, float scale) {
        ParticleEffectContainer effectContainer = new ParticleEffectContainer();
        effectContainer.setParticleEffect(new ParticleEffect());
        effectContainer.getParticleEffect().load(Gdx.files.internal(filename), Gdx.files.internal(particleFolder));
        effectContainer.getParticleEffect().scaleEffect(scale);

        effectContainer.setParticleEffectPool(new ParticleEffectPool(effectContainer.getParticleEffect(), 1, 2));

        particleEffects.put(effectName, effectContainer);
    }

    /**
     * Fires an effect specified by it's name on a certain position on the screen.
     * @param x Horizontal position within the game world, in world units.
     * @param y Vertical position within the game world, in world units.
     * @param name Name with which the effect was initialized.
     */
    public void fireEffect(float x, float y, String name) {
        if (particleEffects.get(name) == null) {
            Gdx.app.error("Error", "Effect not found");
            return;
        }

        ParticleEffectPool.PooledEffect fx = particleEffects.get(name).getParticleEffectPool().obtain();
        fx.setPosition(x, y);
        pooledEffects.add(fx);
    }

    /**
     * Configures all animated tiles so that they animate.
     */
    private void handleAnimatedTiles() {
        // name : amount of animationFrames
        Map<String, Integer> animations = new HashMap<>();
        Iterator<TiledMapTile> tiles;

        // Get animation names.
        tiles = map.getTileSets().getTileSet(Config.MAP_TILESET_MAIN).iterator();
        while (tiles.hasNext()) {
            TiledMapTile tile = tiles.next();
            if (tile.getProperties().containsKey(Config.MAP_PROPERTY_ANIMATION)) {
                String name = tile.getProperties().get(Config.MAP_PROPERTY_ANIMATION, String.class);
                int frames;
                if (animations.get(name) == null) {
                    frames = 0;
                } else {
                    frames = animations.get(name) + 1;
                }
                animations.put(name, frames);
            }
        }

        // Swap tiles for each animation name.
        for(Map.Entry<String, Integer> entry : animations.entrySet()) {
            String name = entry.getKey();
            int frames = entry.getValue();

            // Default speed.
            float speed = Config.MAP_DEFAULT_SPEED;

            tiles = map.getTileSets().getTileSet(Config.MAP_TILESET_MAIN).iterator();
            Array<StaticTiledMapTile> tileAnimationFrames = new Array<>(frames);

            // Add tiles with this animation name.
            while (tiles.hasNext()) {
                TiledMapTile tile = tiles.next();
                if (tile.getProperties().containsKey(Config.MAP_PROPERTY_ANIMATION)
                        && tile.getProperties().get(Config.MAP_PROPERTY_ANIMATION, String.class).equals(name)) {
                    tileAnimationFrames.add((StaticTiledMapTile) tile);

                    if (tile.getProperties().containsKey(Config.MAP_PROPERTY_SPEED)) {
                        try {
                            speed = Integer.parseInt(tile.getProperties().get(Config.MAP_PROPERTY_SPEED, String.class));
                        } catch (NumberFormatException e) {
                            Gdx.app.error("Log", "Bas cast: String to int.");
                        }
                    }
                }
            }

            AnimatedTiledMapTile animatedTile = new AnimatedTiledMapTile(1f / speed, tileAnimationFrames);
            TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(Config.MAP_LAYER_TERRAIN);

            // Spawn found tiles with animations.
            for (int x  = 0; x < layer.getWidth(); x++) {
                for (int y = 0; y < layer.getHeight(); y++) {
                    TiledMapTileLayer.Cell cell = layer.getCell(x, y);

                    if (cell == null) {
                        continue;
                    }

                    if (cell.getTile().getProperties().containsKey(Config.MAP_PROPERTY_ANIMATION)
                            && cell.getTile().getProperties().get(Config.MAP_PROPERTY_ANIMATION, String.class).equals(name)) {
                        cell.setTile(animatedTile);
                    }
                }
            }
        }
    }

    public void dispose() {
        units.forEach(Unit::dispose);
        items.forEach(Item::dispose);

        map.dispose();
        playerUnit.dispose();
        renderer.dispose();
        boxWorld.dispose();
        debugRenderer.dispose();
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    /**
     * Sets a point to which the camera should be focused upon start.
     * @param x Horizontal position within the game world, in world units.
     * @param y Vertical position within the game world, in world units.
     */
    public void setSpawnPoint(float x, float y) {
        spawnPoint.x = x;
        spawnPoint.y = y;
    }

    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }

    public Array<ParticleEffectPool.PooledEffect> getPooledEffects() {
        return pooledEffects;
    }

    public Unit getPlayerUnit() {
        return playerUnit;
    }

    public void setPlayerUnit(Unit playerUnit) {
        this.playerUnit = playerUnit;
    }

    /**
     * Sets the player unit onto the spawnPoint position.
     */
    public void positionPlayerUnit() {
        playerUnit.setPosition(spawnPoint.x, spawnPoint.y);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public World getBoxWorld() {
        return boxWorld;
    }

    public Box2DDebugRenderer getDebugRenderer() {
        return debugRenderer;
    }
}
