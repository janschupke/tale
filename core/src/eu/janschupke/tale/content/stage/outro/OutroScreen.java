package eu.janschupke.tale.content.stage.outro;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.UiScreen;
import eu.janschupke.tale.content.config.enumeration.Screens;

/**
 * Last screen before the game jumps back into menu at the end of the game.
 *
 * @author jan.schupke@gmail.com
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
