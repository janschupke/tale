package eu.janschupke.tale.content.stage.level.dungeon;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.config.enumeration.InputProcessors;
import eu.janschupke.tale.base.screen.TopDownScreen;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.quest.DungeonQuestManager;

/**
 * Screen for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonScreen extends TopDownScreen {
    public DungeonScreen(final App app) {
        super(app, Screens.DUNGEON);

        screenHud = Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(InputProcessors.TOPDOWN);
        levelEventHandler = new DungeonEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getDungeonMusic();
        questManager = new DungeonQuestManager(app);
        app.swapHuds(app.getHud(Huds.STANDARD));
        world = new DungeonWorld(this);
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
