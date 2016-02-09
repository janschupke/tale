package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

/**
 * Event handler for the forest level.
 */
public class ForestEventHandler extends LevelEventHandler {
    private IntroEvent introEvent;
    private ItemHintEvent itemHintEvent;
    private CoinPickupEvent coinPickupEvent;
    private InitialWallEvent initialWallEvent;
    private UkkoTalkEvent ukkoTalkEvent;

    public ForestEventHandler(final App app) {
        super(app);

        introEvent = new IntroEvent(app);
        itemHintEvent = new ItemHintEvent(app);
        coinPickupEvent = new CoinPickupEvent(app);
        initialWallEvent = new InitialWallEvent(app);
        ukkoTalkEvent = new UkkoTalkEvent(app);
    }

    public IntroEvent getIntroEvent() {
        return introEvent;
    }

    public ItemHintEvent getItemHintEvent() {
        return itemHintEvent;
    }

    public CoinPickupEvent getCoinPickupEvent() {
        return coinPickupEvent;
    }

    public InitialWallEvent getInitialWallEvent() {
        return initialWallEvent;
    }

    public UkkoTalkEvent getUkkoTalkEvent() {
        return ukkoTalkEvent;
    }
}
