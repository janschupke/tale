package eu.janschupke.tale.base.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.Hotkeys;
import eu.janschupke.tale.logging.utility.GameLogParser;

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
            try {
                app.getGameState().getCurrentLevel().getWorld().getPlayerUnit().stopDown();
            } catch (Exception e) {
                // Might not be in game at the moment.
            }
        }

        if (keycode == Hotkeys.DEBUG_LOG_DUMP) {
            // Manual dump is only available in debug mode.
            // Dump gets called automatically upon the game completion.
            if (Config.DEBUG_MODE) {
                GameLogParser.parseToXml(app.getGameLog());
            }
        }

        if (keycode == Hotkeys.DEBUG_MODEL_DUMP) {
            if (Config.DEBUG_MODE) {
                GameLogParser.exportEventModel();
            }
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
