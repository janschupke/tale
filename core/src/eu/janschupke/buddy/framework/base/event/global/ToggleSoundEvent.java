package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.content.ui.menu.AudioMenu;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Message event for music toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleSoundEvent extends BaseEvent {
    public ToggleSoundEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.sound"));
    }

    /**
     * Toggles sound playback and updates configuration.
     */
    @Override
    public void trigger() {
        // Toggle the configuration value.
        app.getSettingsManager().getConfig().setEnableSound(!app.getSettingsManager().getConfig().isEnableSound());
        ((AudioMenu) app.getHud(Config.Huds.AUDIOMENU)).getEnableSoundCheckbox()
                .setChecked(app.getSettingsManager().getConfig().isEnableSound());
        app.getSettingsManager().persist();
        addEventMessage();
    }
}
