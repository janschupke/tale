package eu.janschupke.tale.content.stage.outro;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.UiScreen;
import eu.janschupke.tale.content.config.enumeration.Screens;

/**
 * Screen displayed at the end of the game.
 * Shows credits and game completion information.
 */
public class OutroScreen extends UiScreen {
    public OutroScreen(final App app) {
        super(app, Screens.OUTRO);
        backgroundMusic = app.getResourceManager().getMusicHandler().getOutroMusic();
    }

    @Override
    public void show() {
        super.show();
        app.getEventHandler().triggerMusic(false, false);
        app.getEventHandler().triggerMusic(true, false);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        renderStage();
    }
}
