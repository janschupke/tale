package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.IntroEvent;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.util.LevelEventHandler;

/**
 * Event handler for the forest level.
 */
public class ForestEventHandler extends LevelEventHandler {
    private IntroEvent introEvent;

    public ForestEventHandler(BaseScreen screen) {
        super(screen);

        introEvent = new IntroEvent(screen.getApp());
    }

    public IntroEvent getIntroEvent() {
        return introEvent;
    }
}
