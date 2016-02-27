package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

/**
 * Event handler for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestEventHandler extends LevelEventHandler {
    private CoinInteractionEvent coinInteractionEvent;
    private CoinPickupEvent coinPickupEvent;
    private InitialWallEvent initialWallEvent;
    private IntroEvent introEvent;
    private ItemHintEvent itemHintEvent;
    private UkkoInteractionEvent ukkoInteractionEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;

    public ForestEventHandler(final App app) {
        super(app);

        coinInteractionEvent = new CoinInteractionEvent(app);
        coinPickupEvent = new CoinPickupEvent(app);
        initialWallEvent = new InitialWallEvent(app);
        introEvent = new IntroEvent(app);
        itemHintEvent = new ItemHintEvent(app);
        ukkoInteractionEvent = new UkkoInteractionEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
    }

    public CoinInteractionEvent getCoinInteractionEvent() {
        return coinInteractionEvent;
    }

    public CoinPickupEvent getCoinPickupEvent() {
        return coinPickupEvent;
    }

    public InitialWallEvent getInitialWallEvent() {
        return initialWallEvent;
    }

    public IntroEvent getIntroEvent() {
        return introEvent;
    }

    public ItemHintEvent getItemHintEvent() {
        return itemHintEvent;
    }

    public UkkoInteractionEvent getUkkoInteractionEvent() {
        return ukkoInteractionEvent;
    }

    public OutskirtsTransitionEvent getOutskirtsTransitionEvent() {
        return outskirtsTransitionEvent;
    }
}
