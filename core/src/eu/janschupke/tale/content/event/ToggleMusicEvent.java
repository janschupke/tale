package eu.janschupke.tale.content.event;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.GeneralEvent;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.ui.menu.AudioMenu;

/**
 * Message event for music toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleMusicEvent extends GeneralEvent {
    public ToggleMusicEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.music"));
        repeatable = true;
    }

    @Override
    protected void updateMessages() {
        addEventMessage();
        app.getGameState().getGlobalLevelState().setNewEvent(true);
    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        Gdx.app.debug("ToggleMusicEvent#updateGameState", String.format("Current: %s", app.getSettingsManager().getConfig().isEnableMusic()));
        app.getSettingsManager().getConfig().setEnableMusic(!app.getSettingsManager().getConfig().isEnableMusic());
        ((AudioMenu) app.getHud(Huds.AUDIOMENU)).getEnableMusicCheckbox()
                .setChecked(app.getSettingsManager().getConfig().isEnableMusic());
        app.getSettingsManager().persist();
        Gdx.app.debug("ToggleMusicEvent#updateGameState", String.format("New: %s", app.getSettingsManager().getConfig().isEnableMusic()));
    }

    @Override
    protected void updateInteractions() {

    }
}
