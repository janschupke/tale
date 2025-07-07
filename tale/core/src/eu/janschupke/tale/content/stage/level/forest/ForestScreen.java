package eu.janschupke.tale.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.config.enumeration.InputProcessors;
import eu.janschupke.tale.base.screen.TopDownScreen;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.forest.event.ForestEventHandler;
import eu.janschupke.tale.content.stage.level.forest.quest.ForestQuestManager;

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
