package eu.janschupke.tale.content.stage.level.outskirts;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.config.enumeration.InputProcessors;
import eu.janschupke.tale.framework.screen.TopDownScreen;

/**
 * Outskirts (Level 1) screen.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsScreen extends TopDownScreen {
    public OutskirtsScreen(final App app) {
        super(app, Screens.OUTSKIRTS);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new OutskirtsEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getOutskirtsMusic();
        questManager = new OutskirtsQuestManager(app);
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new OutskirtsWorld(this);
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
