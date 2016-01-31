package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Outskirts (Level 1) screen.
 */
public class OutskirtsScreen extends TopDownScreen {
    public OutskirtsScreen(final App app) {
        super(app);

        screenHud = Config.Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(Config.Input.OUTSKIRTS);
        levelEventHandler = new OutskirtsEventHandler(this);
        backgroundMusic = app.getResourceHandler().getOutskirtsMusic();
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
        world = new OutskirtsWorld(this);
        initView(world.getWidth(), world.getHeight());
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
