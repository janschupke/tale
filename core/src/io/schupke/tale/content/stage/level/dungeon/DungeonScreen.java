package io.schupke.tale.content.stage.level.dungeon;

import io.schupke.tale.base.App;
import io.schupke.tale.base.config.enumeration.InputProcessors;
import io.schupke.tale.base.screen.TopDownScreen;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import io.schupke.tale.content.stage.level.dungeon.quest.DungeonQuestManager;

/**
 * Screen for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonScreen extends TopDownScreen {
    public DungeonScreen(final App app) {
        super(app, Screens.DUNGEON);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new DungeonEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getDungeonMusic();
        questManager = new DungeonQuestManager(app);
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new DungeonWorld(this);
        initView(world.getWidth(), world.getHeight());
        inputMultiplexer.addProcessor(levelInputProcessor);
        view.setCameraPosition(world.getPlayerUnit());
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        update(delta);
        super.render(delta);
    }
}
