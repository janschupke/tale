package io.schupke.tale.base.world;

import com.badlogic.gdx.physics.box2d.World;

import io.schupke.tale.base.screen.PlatformScreen;
import io.schupke.tale.base.utility.WorldObjectFactory;
import io.schupke.tale.content.config.Config;

/**
 * Base class for platform-style world implementations.
 * Provides gravity physics for 2D platformer gameplay.
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
