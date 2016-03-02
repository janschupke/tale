package eu.janschupke.tale.content.stage.level.cave;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.cave.quest.CaveQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.screen.TopDownScreen;
import eu.janschupke.tale.framework.config.enumeration.InputProcessors;

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
        levelState = new CaveLevelState();
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
