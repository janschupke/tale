package io.schupke.tale.content.stage.level.cave;

import io.schupke.tale.base.App;
import io.schupke.tale.base.config.enumeration.InputProcessors;
import io.schupke.tale.base.screen.TopDownScreen;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.stage.level.cave.event.CaveEventHandler;
import io.schupke.tale.content.stage.level.cave.quest.CaveQuestManager;

/**
 * Screen for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveScreen extends TopDownScreen {
    public CaveScreen(final App app) {
        super(app, Screens.CAVE);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new CaveEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getCaveMusic();
        questManager = new CaveQuestManager(app);
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new CaveWorld(this);
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
