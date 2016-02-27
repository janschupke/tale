package eu.janschupke.buddy.content.stage.level.settlement;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Screen for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementScreen extends TopDownScreen {
    public SettlementScreen(final App app) {
        super(app);

        screenHud = Config.Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(Config.Input.TOPDOWN);
        levelEventHandler = new SettlementEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getSettlementMusic();
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
        world = new SettlementWorld(this);
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
