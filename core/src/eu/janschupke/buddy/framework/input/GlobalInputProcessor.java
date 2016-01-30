package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Hotkeys;

/**
 * Input processor for application-wide input processing.
 */
public class GlobalInputProcessor extends BaseInputProcessor {
    public GlobalInputProcessor(final App app) {
        super(app);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.CONTROL_LEFT || keycode == Input.Keys.CONTROL_RIGHT) {
            app.getSettingsManager().getConfig().setCtrlDown(true);
        }

        if (keycode == Hotkeys.MUSIC && app.getSettingsManager().getConfig().isCtrlDown()) {
            Gdx.app.debug("GlobalInputProcessor#keyDown", "Toggling music");
            app.getEventHandler().toggleMusic();
        }

        if (keycode == Hotkeys.SOUND && app.getSettingsManager().getConfig().isCtrlDown()) {
            Gdx.app.debug("GlobalInputProcessor#keyDown", "Toggling sound");
            app.getEventHandler().toggleSound();
        }

        if (keycode == Hotkeys.DEBUG) {
            Gdx.app.debug("GlobalInputProcessor#keyDown", "Toggling debug");
            app.getEventHandler().toggleDebugRendering();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.CONTROL_LEFT || keycode == Input.Keys.CONTROL_RIGHT) {
            app.getSettingsManager().getConfig().setCtrlDown(false);
        }

        return false;
    }
}
