package eu.janschupke.buddy.content.stage.level.cave;

import eu.janschupke.buddy.content.stage.level.cave.quest.CaveQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;

/**
 * Screen for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveScreen extends TopDownScreen {
    public CaveScreen(final App app) {
        super(app);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new CaveEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getCaveMusic();
        questManager = new CaveQuestManager(app);
        levelState = new CaveLevelState();
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new CaveWorld(this);
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
