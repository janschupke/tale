package io.schupke.tale.content.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.GeneralEvent;
import io.schupke.tale.content.config.enumeration.Huds;
import io.schupke.tale.content.ui.menu.AudioMenu;

/**
 * Message event for music toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleSoundEvent extends GeneralEvent {
    public ToggleSoundEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.sound"));
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
        app.getSettingsManager().getConfig().setEnableSound(!app.getSettingsManager().getConfig().isEnableSound());
        ((AudioMenu) app.getHud(Huds.AUDIOMENU)).getEnableSoundCheckbox()
                .setChecked(app.getSettingsManager().getConfig().isEnableSound());
        app.getSettingsManager().persist();

        if (!app.getSettingsManager().getConfig().isEnableSound()) {
            app.getResourceManager().getMusicHandler().stopHarpsichord();
        }
    }

    @Override
    protected void updateInteractions() {

    }
}
