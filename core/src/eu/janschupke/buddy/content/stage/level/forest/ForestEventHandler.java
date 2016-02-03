package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.IntroEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.ItemHintEvent;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.util.LevelEventHandler;

/**
 * Event handler for the forest level.
 */
public class ForestEventHandler extends LevelEventHandler {
    private IntroEvent introEvent;
    private ItemHintEvent itemHintEvent;

    public ForestEventHandler(final App app) {
        super(app);

        introEvent = new IntroEvent(app);
        itemHintEvent = new ItemHintEvent(app);
    }

    public IntroEvent getIntroEvent() {
        return introEvent;
    }

    public ItemHintEvent getItemHintEvent() {
        return itemHintEvent;
    }
}
