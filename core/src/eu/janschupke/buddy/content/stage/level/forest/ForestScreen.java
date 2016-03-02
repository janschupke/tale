package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.config.enumeration.Huds;
import eu.janschupke.buddy.content.config.enumeration.Screens;
import eu.janschupke.buddy.content.stage.level.forest.quest.ForestQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;

/**
 * Forest (Tutorial) screen.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestScreen extends TopDownScreen {
    public ForestScreen(final App app) {
        super(app, Screens.FOREST);

        Gdx.app.debug("ForestScreen#<init>", "Constructing");

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new ForestEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getForestMusic();
        questManager = new ForestQuestManager(app);
        levelState = new ForestLevelState();
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new ForestWorld(this);
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
