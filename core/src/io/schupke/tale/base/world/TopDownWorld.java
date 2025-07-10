package io.schupke.tale.base.world;

import com.badlogic.gdx.physics.box2d.World;

import io.schupke.tale.base.screen.TopDownScreen;
import io.schupke.tale.base.utility.WorldObjectFactory;
import io.schupke.tale.content.config.Config;

/**
 * Base class for top-down world implementations.
 * Provides no gravity physics for 2D top-down gameplay.
 */
public abstract class TopDownWorld extends BaseWorld {
    public TopDownWorld(String tiledMap, float tileSize, TopDownScreen screen) {
        super(tiledMap, tileSize, screen);

        boxWorld = new World(Config.TOPDOWN_GRAVITY, false);
        if (!Config.DEBUG_MODE) {
            WorldObjectFactory.parseMapObjects(boxWorld, map.getLayers()
                    .get(Config.MAP_LAYER_OBJECT).getObjects(), tileSize);
        }
        boxWorld.setContactListener(new BodyContactListener());

        init();
    }
}
