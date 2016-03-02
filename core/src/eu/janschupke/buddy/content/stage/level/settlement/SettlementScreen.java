package eu.janschupke.buddy.content.stage.level.settlement;

import eu.janschupke.buddy.content.config.enumeration.Huds;
import eu.janschupke.buddy.content.config.enumeration.Screens;
import eu.janschupke.buddy.content.stage.level.settlement.quest.SettlementQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;

/**
 * Screen for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementScreen extends TopDownScreen {
    public SettlementScreen(final App app) {
        super(app, Screens.SETTLEMENT);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new SettlementEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getSettlementMusic();
        questManager = new SettlementQuestManager(app);
        levelState = new SettlementLevelState();
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new SettlementWorld(this);
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
