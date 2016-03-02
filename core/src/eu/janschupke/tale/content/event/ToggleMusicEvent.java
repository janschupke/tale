package eu.janschupke.tale.content.event;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.ui.menu.AudioMenu;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.GeneralEvent;

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
