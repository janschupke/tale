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
    private EastExplorationEvent eastExplorationEvent;
    private InitialWallEvent initialWallEvent;
    private IntroEvent introEvent;
    private ItemIntroEvent itemIntroEvent;
    private NorthExplorationEvent northExplorationEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;
    private QuestWallEvent questWallEvent;
    private SouthExplorationEvent southExplorationEvent;
    private UkkoDeliveryEvent ukkoDeliveryEvent;
    private UkkoInteractionEvent ukkoInteractionEvent;
    private UnitIntroEvent unitIntroEvent;

    public ForestEventHandler(final App app) {
        super(app);

        coinInteractionEvent = new CoinInteractionEvent(app);
        coinPickupEvent = new CoinPickupEvent(app);
        eastExplorationEvent = new EastExplorationEvent(app);
        initialWallEvent = new InitialWallEvent(app);
        introEvent = new IntroEvent(app);
        itemIntroEvent = new ItemIntroEvent(app);
        northExplorationEvent = new NorthExplorationEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
        questWallEvent = new QuestWallEvent(app);
        southExplorationEvent = new SouthExplorationEvent(app);
        ukkoDeliveryEvent = new UkkoDeliveryEvent(app);
        ukkoInteractionEvent = new UkkoInteractionEvent(app);
        unitIntroEvent = new UnitIntroEvent(app);
    }

    public CoinInteractionEvent getCoinInteractionEvent() {
        return coinInteractionEvent;
    }

    public CoinPickupEvent getCoinPickupEvent() {
        return coinPickupEvent;
    }

    public EastExplorationEvent getEastExplorationEvent() {
        return eastExplorationEvent;
    }

    public InitialWallEvent getInitialWallEvent() {
        return initialWallEvent;
    }

    public IntroEvent getIntroEvent() {
        return introEvent;
    }

    public ItemIntroEvent getItemIntroEvent() {
        return itemIntroEvent;
    }

    public NorthExplorationEvent getNorthExplorationEvent() {
        return northExplorationEvent;
    }

    public OutskirtsTransitionEvent getOutskirtsTransitionEvent() {
        return outskirtsTransitionEvent;
    }

    public QuestWallEvent getQuestWallEvent() {
        return questWallEvent;
    }

    public SouthExplorationEvent getSouthExplorationEvent() {
        return southExplorationEvent;
    }

    public UkkoDeliveryEvent getUkkoDeliveryEvent() {
        return ukkoDeliveryEvent;
    }

    public UkkoInteractionEvent getUkkoInteractionEvent() {
        return ukkoInteractionEvent;
    }

    public UnitIntroEvent getUnitIntroEvent() {
        return unitIntroEvent;
    }
}
