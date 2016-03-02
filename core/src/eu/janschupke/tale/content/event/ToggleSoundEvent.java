package eu.janschupke.tale.content.event;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.ui.menu.AudioMenu;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.GeneralEvent;

/**
 * Message event for music toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleSoundEvent extends GeneralEvent {
    public ToggleSoundEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.sound"));
    }

    @Override
    protected void updateMessages() {
        addEventMessage();
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
    }

    @Override
    protected void updateInteractions() {

    }
}
