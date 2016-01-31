package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.util.LevelEventHandler;

/**
 * Event handler for the forest level.
 */
public class ForestEventHandler extends LevelEventHandler {
    private boolean introTriggered;
    private boolean caveLoreTriggered;

    public ForestEventHandler(BaseScreen screen) {
        super(screen);
    }

    public void triggerIntro() {
        if (introTriggered) return;
        Gdx.app.debug("ForestEventHandler#triggerIntro", "Triggering intro event.");
        introTriggered = true;
        // TODO: only once, dialog, add to lore log.
    }

    public void triggerCaveLore() {
        if (caveLoreTriggered) return;
        Gdx.app.debug("ForestEventHandler#triggerCaveLore", "Triggering cave lore event.");
        caveLoreTriggered = true;
    }
}
