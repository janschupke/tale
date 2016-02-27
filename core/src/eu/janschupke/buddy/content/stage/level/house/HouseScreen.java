package eu.janschupke.buddy.content.stage.level.house;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Screen for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseScreen extends TopDownScreen {
    public HouseScreen(final App app) {
        super(app);

        screenHud = Config.Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(Config.Input.TOPDOWN);
        levelEventHandler = new HouseEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getHouseMusic();
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
        world = new HouseWorld(this);
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
