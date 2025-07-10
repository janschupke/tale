package io.schupke.tale.content.stage.level.forest.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.handling.LevelEventHandler;
import io.schupke.tale.content.stage.level.forest.event.exploration.EastExplorationEvent;
import io.schupke.tale.content.stage.level.forest.event.exploration.NorthExplorationEvent;
import io.schupke.tale.content.stage.level.forest.event.exploration.SouthExplorationEvent;
import io.schupke.tale.content.stage.level.forest.event.general.*;
import io.schupke.tale.content.stage.level.forest.event.interaction.*;
import io.schupke.tale.content.stage.level.forest.event.pickup.CoinPickupEvent;
import io.schupke.tale.content.stage.level.forest.event.transition.OutskirtsTransitionEvent;

/**
 * Event handler for the forest level.
 *
 * @author jan.schupke@gmail.com
 */
public class ForestEventHandler extends LevelEventHandler {
    // Exploration.
    private EastExplorationEvent eastExplorationEvent;
    private NorthExplorationEvent northExplorationEvent;
    private SouthExplorationEvent southExplorationEvent;

    // General.
    private InitialWallGeneralEvent initialWallGeneralEvent;
    private IntroGeneralEvent introGeneralEvent;
    private ItemIntroGeneralEvent itemIntroGeneralEvent;
    private QuestWallGeneralEvent questWallGeneralEvent;
    private UnitIntroGeneralEvent unitIntroGeneralEvent;

    // Interaction.
    private CaravanInteractionEvent caravanInteractionEvent;
    private CoinInteractionEvent coinInteractionEvent;
    private UkkoDeliveryInteractionEvent ukkoDeliveryInteractionEvent;
    private UkkoInteractionEvent ukkoInteractionEvent;
    private UkkoDiscussInteractionEvent ukkoDiscussInteractionEvent;

    // Pickup.
    private CoinPickupEvent coinPickupEvent;

    // Transition.
    private OutskirtsTransitionEvent outskirtsTransitionEvent;

    public ForestEventHandler(final App app) {
        super(app);

        // Exploration.
        eastExplorationEvent = new EastExplorationEvent(app);
        northExplorationEvent = new NorthExplorationEvent(app);
        southExplorationEvent = new SouthExplorationEvent(app);

        // General.
        initialWallGeneralEvent = new InitialWallGeneralEvent(app);
        introGeneralEvent = new IntroGeneralEvent(app);
        itemIntroGeneralEvent = new ItemIntroGeneralEvent(app);
        questWallGeneralEvent = new QuestWallGeneralEvent(app);
        unitIntroGeneralEvent = new UnitIntroGeneralEvent(app);

        // Interaction.
        caravanInteractionEvent = new CaravanInteractionEvent(app);
        coinInteractionEvent = new CoinInteractionEvent(app);
        ukkoDeliveryInteractionEvent = new UkkoDeliveryInteractionEvent(app);
        ukkoInteractionEvent = new UkkoInteractionEvent(app);
        ukkoDiscussInteractionEvent = new UkkoDiscussInteractionEvent(app);

        // Pickup.
        coinPickupEvent = new CoinPickupEvent(app);

        // Transition.
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
    }

    public UkkoDiscussInteractionEvent getUkkoDiscussInteractionEvent() {
        return ukkoDiscussInteractionEvent;
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

    public CaravanInteractionEvent getCaravanInteractionEvent() {
        return caravanInteractionEvent;
    }

    public UkkoDeliveryInteractionEvent getUkkoDeliveryInteractionEvent() {
        return ukkoDeliveryInteractionEvent;
    }

    public UkkoInteractionEvent getUkkoInteractionEvent() {
        return ukkoInteractionEvent;
    }

    public UnitIntroGeneralEvent getUnitIntroGeneralEvent() {
        return unitIntroGeneralEvent;
    }
}
