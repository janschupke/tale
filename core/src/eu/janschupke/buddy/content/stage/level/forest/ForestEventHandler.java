package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestEventHandler extends LevelEventHandler {
    private CoinInteractionEvent coinInteractionEvent;
    private CoinPickupEvent coinPickupEvent;
    private EastExplorationEvent eastExplorationEvent;
    private InitialWallGeneralEvent initialWallGeneralEvent;
    private IntroGeneralEvent introGeneralEvent;
    private ItemIntroGeneralEvent itemIntroGeneralEvent;
    private NorthExplorationEvent northExplorationEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;
    private QuestWallGeneralEvent questWallGeneralEvent;
    private SouthExplorationEvent southExplorationEvent;
    private UkkoDeliveryGeneralEvent ukkoDeliveryGeneralEvent;
    private UkkoInteractionEvent ukkoInteractionEvent;
    private UnitIntroGeneralEvent unitIntroGeneralEvent;

    public ForestEventHandler(final App app) {
        super(app);

        coinInteractionEvent = new CoinInteractionEvent(app);
        coinPickupEvent = new CoinPickupEvent(app);
        eastExplorationEvent = new EastExplorationEvent(app);
        initialWallGeneralEvent = new InitialWallGeneralEvent(app);
        introGeneralEvent = new IntroGeneralEvent(app);
        itemIntroGeneralEvent = new ItemIntroGeneralEvent(app);
        northExplorationEvent = new NorthExplorationEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
        questWallGeneralEvent = new QuestWallGeneralEvent(app);
        southExplorationEvent = new SouthExplorationEvent(app);
        ukkoDeliveryGeneralEvent = new UkkoDeliveryGeneralEvent(app);
        ukkoInteractionEvent = new UkkoInteractionEvent(app);
        unitIntroGeneralEvent = new UnitIntroGeneralEvent(app);
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

    public InitialWallGeneralEvent getInitialWallGeneralEvent() {
        return initialWallGeneralEvent;
    }

    public IntroGeneralEvent getIntroGeneralEvent() {
        return introGeneralEvent;
    }

    public ItemIntroGeneralEvent getItemIntroGeneralEvent() {
        return itemIntroGeneralEvent;
    }

    public NorthExplorationEvent getNorthExplorationEvent() {
        return northExplorationEvent;
    }

    public OutskirtsTransitionEvent getOutskirtsTransitionEvent() {
        return outskirtsTransitionEvent;
    }

    public QuestWallGeneralEvent getQuestWallGeneralEvent() {
        return questWallGeneralEvent;
    }

    public SouthExplorationEvent getSouthExplorationEvent() {
        return southExplorationEvent;
    }

    public UkkoDeliveryGeneralEvent getUkkoDeliveryGeneralEvent() {
        return ukkoDeliveryGeneralEvent;
    }

    public UkkoInteractionEvent getUkkoInteractionEvent() {
        return ukkoInteractionEvent;
    }

    public UnitIntroGeneralEvent getUnitIntroGeneralEvent() {
        return unitIntroGeneralEvent;
    }
}
