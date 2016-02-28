package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;

/**
 * Outskirts (Level 1) screen.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsScreen extends TopDownScreen {
    public OutskirtsScreen(final App app) {
        super(app);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new OutskirtsEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getOutskirtsMusic();
        questManager = new OutskirtsQuestManager(app);
        levelState = new OutskirtsLevelState();
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new OutskirtsWorld(this);
        initView(world.getWidth(), world.getHeight());
        inputMultiplexer.addProcessor(levelInputProcessor);
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
