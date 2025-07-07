package eu.janschupke.tale.base.world;

import com.badlogic.gdx.physics.box2d.World;
import eu.janschupke.tale.base.screen.PlatformScreen;
import eu.janschupke.tale.base.utility.WorldObjectFactory;
import eu.janschupke.tale.content.config.Config;

/**
 * Base class for all platform type worlds.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class PlatformWorld extends BaseWorld {
    public PlatformWorld(String tiledMap, float tileSize, PlatformScreen screen) {
        super(tiledMap, tileSize, screen);

        boxWorld = new World(Config.PLATFORM_GRAVITY, false);
        if (!Config.DEBUG_MODE) {
            WorldObjectFactory.parseMapObjects(boxWorld, map.getLayers()
                    .get(Config.MAP_LAYER_OBJECT).getObjects(), tileSize);
        }
        boxWorld.setContactListener(new BodyContactListener());

        init();
    }
}
