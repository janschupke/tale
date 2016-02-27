package eu.janschupke.buddy.content.stage.level.dungeon;

import eu.janschupke.buddy.content.stage.level.dungeon.quest.DungeonQuestManager;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.TopDownScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Screen for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonScreen extends TopDownScreen {
    public DungeonScreen(final App app) {
        super(app);

        screenHud = Config.Huds.STANDARD;
        levelInputProcessor = app.getInputProcessor(Config.Input.TOPDOWN);
        levelEventHandler = new DungeonEventHandler(app);
        backgroundMusic = app.getResourceManager().getMusicHandler().getDungeonMusic();
        questManager = new DungeonQuestManager(app);
        levelState = new DungeonLevelState();
        app.swapHuds(app.getHud(Config.Huds.STANDARD));
        world = new DungeonWorld(this);
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
