package eu.janschupke.buddy.content.stage.level.house;

import eu.janschupke.buddy.content.stage.level.house.quest.HouseQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;
import eu.janschupke.buddy.framework.config.enumeration.Screens;

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
