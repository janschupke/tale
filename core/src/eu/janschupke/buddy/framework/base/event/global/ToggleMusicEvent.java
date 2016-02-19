package eu.janschupke.buddy.framework.base.event.global;

import eu.janschupke.buddy.content.ui.menu.AudioMenu;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.BaseEvent;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Message event for music toggle.
 * @author jan.schupke@gmail.com
 */
public class ToggleMusicEvent extends BaseEvent {
    public ToggleMusicEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.music"));
    }

    /**
     * Toggles music playback and updates configuration.
     */
    @Override
    public void trigger() {
        // Toggle the configuration value.
        app.getSettingsManager().getConfig().setEnableMusic(!app.getSettingsManager().getConfig().isEnableMusic());
        ((AudioMenu)app.getHud(Config.Huds.AUDIOMENU)).getEnableMusicCheckbox()
                .setChecked(app.getSettingsManager().getConfig().isEnableMusic());
        app.getSettingsManager().persist();
        addEventMessage();
    }
}
