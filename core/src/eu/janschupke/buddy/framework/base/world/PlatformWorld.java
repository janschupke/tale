package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.physics.box2d.World;
import eu.janschupke.buddy.content.config.Config;
import eu.janschupke.buddy.framework.base.screen.PlatformScreen;
import eu.janschupke.buddy.framework.util.WorldObjectFactory;

/**
 * Base class for all platform type worlds.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class PlatformWorld extends BaseWorld {
    public PlatformWorld(String tiledMap, float tileSize, PlatformScreen screen) {
        super(tiledMap, tileSize, screen);

        boxWorld = new World(Config.PLATFORM_GRAVITY, false);
        WorldObjectFactory.parseMapObjects(boxWorld, map.getLayers().get(Config.MAP_LAYER_OBJECT).getObjects(), tileSize);
        boxWorld.setContactListener(new BodyContactListener());

        init();
    }
}
