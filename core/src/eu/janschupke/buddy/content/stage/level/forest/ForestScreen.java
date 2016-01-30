package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Forest (Tutorial) screen.
 */
public class ForestScreen extends TopDownScreen {
    public ForestScreen(final App app) {
        super(app);

        Gdx.app.debug("ForestScreen#<init>", "Constructing");

        screenHud = Config.Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(Config.Input.FOREST);
        backgroundMusic = app.getResourceHandler().getForestMusic();
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
    }

    @Override
    public void show() {
        super.show();

        world = new ForestWorld();
        initView(world.getWidth(), world.getHeight());
    }

    @Override
    public void render(float delta) {
        update(delta);
        super.render(delta);
    }
}
