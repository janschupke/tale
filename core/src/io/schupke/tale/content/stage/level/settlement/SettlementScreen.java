package io.schupke.tale.content.stage.level.settlement;

import io.schupke.tale.base.App;
import io.schupke.tale.base.config.enumeration.InputProcessors;
import io.schupke.tale.base.screen.TopDownScreen;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.stage.level.settlement.event.SettlementEventHandler;
import io.schupke.tale.content.stage.level.settlement.quest.SettlementQuestManager;

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
