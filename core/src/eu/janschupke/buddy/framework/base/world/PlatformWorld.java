package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.physics.box2d.World;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Base class for all platform type worlds.
 */
public abstract class PlatformWorld extends BaseWorld {
    public PlatformWorld(String tiledMap, float tileSize) {
        super(tiledMap, tileSize);

        boxWorld = new World(Config.PLATFORM_GRAVITY, false);
        WorldObjectFactory.parseMapObjects(boxWorld, map.getLayers().get(Config.MAP_LAYER_OBJECT).getObjects(), tileSize);

        init();
    }
}
