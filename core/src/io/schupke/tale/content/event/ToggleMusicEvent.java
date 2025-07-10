package io.schupke.tale.content.event;

import com.badlogic.gdx.Gdx;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.GeneralEvent;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.ui.menu.AudioMenu;

/**
 * Event for toggling music playback.
 * Controls background music on/off state.
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
