package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Hotkeys;

/**
 * Input processor for application-wide input processing.
 *
 * @author jan.schupke@gmail.com
 */
public class GlobalInputProcessor extends BaseInputProcessor {
    public GlobalInputProcessor(final App app) {
        super(app);
    }

    @Override
    public boolean keyDown(int keycode) {
        super.keyDown(keycode);

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

        if (keycode == Hotkeys.DEBUG_UI) {
            Gdx.app.debug("GlobalInputProcessor#keyDown", "Toggling UI debug rendering");
            app.getEventHandler().toggleUiDebugRendering();
        }

        if (keycode == Hotkeys.DEBUG_RENDER) {
            Gdx.app.debug("GlobalInputProcessor#keyDown", "Toggling world debug rendering");
            app.getEventHandler().toggleWorldDebugRendering();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        super.keyUp(keycode);

        if (keycode == Input.Keys.CONTROL_LEFT || keycode == Input.Keys.CONTROL_RIGHT) {
            app.getSettingsManager().getConfig().setCtrlDown(false);
        }

        return false;
    }
}
