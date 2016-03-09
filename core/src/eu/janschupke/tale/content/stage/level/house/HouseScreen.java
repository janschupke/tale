package eu.janschupke.tale.content.stage.level.house;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.house.event.HouseEventHandler;
import eu.janschupke.tale.content.stage.level.house.quest.HouseQuestManager;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.config.enumeration.InputProcessors;
import eu.janschupke.tale.framework.screen.TopDownScreen;

/**
 * Screen for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseScreen extends TopDownScreen {
    public HouseScreen(final App app) {
        super(app, Screens.HOUSE);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new HouseEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getHouseMusic();
        questManager = new HouseQuestManager(app);
        levelState = new HouseLevelState();
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new HouseWorld(this);
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
