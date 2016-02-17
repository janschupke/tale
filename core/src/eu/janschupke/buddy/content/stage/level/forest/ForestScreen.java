package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.quest.ForestQuestManager;
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
        levelInputProcessor = app.getInputProcessor(Config.Input.TOPDOWN);
        levelEventHandler = new ForestEventHandler(app);
        backgroundMusic = app.getResourceHandler().getForestMusic();
        questManager = new ForestQuestManager(app);
        levelState = new ForestLevelState(app);
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
        world = new ForestWorld(this);
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
