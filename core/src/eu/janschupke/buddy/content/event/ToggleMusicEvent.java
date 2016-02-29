package eu.janschupke.buddy.content.event;

import eu.janschupke.buddy.content.ui.menu.AudioMenu;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.GeneralEvent;
import eu.janschupke.buddy.framework.config.enumeration.Huds;

/**
 * Message event for music toggle.
 *
 * @author jan.schupke@gmail.com
 */
public class ToggleMusicEvent extends GeneralEvent {
    public ToggleMusicEvent(final App app) {
        super(app, app.getLang().get("event.global.toggle.music"));
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
        app.getSettingsManager().getConfig().setEnableMusic(!app.getSettingsManager().getConfig().isEnableMusic());
        ((AudioMenu) app.getHud(Huds.AUDIOMENU)).getEnableMusicCheckbox()
                .setChecked(app.getSettingsManager().getConfig().isEnableMusic());
        app.getSettingsManager().persist();
    }

    @Override
    protected void updateInteractions() {

    }
}