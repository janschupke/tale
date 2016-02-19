package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.physics.box2d.World;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Base class for all top-down type worlds.
 * @author jan.schupke@gmail.com
 */
public abstract class TopDownWorld extends BaseWorld {
    public TopDownWorld(String tiledMap, float tileSize, TopDownScreen screen) {
        super(tiledMap, tileSize, screen);

        boxWorld = new World(Config.TOPDOWN_GRAVITY, false);
        WorldObjectFactory.parseMapObjects(boxWorld, map.getLayers().get(Config.MAP_LAYER_OBJECT).getObjects(), tileSize);
        boxWorld.setContactListener(new BodyContactListener());

        init();
    }
}
