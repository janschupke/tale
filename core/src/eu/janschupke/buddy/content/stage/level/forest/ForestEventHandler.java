package eu.janschupke.buddy.content.stage.level.forest;

import eu.janschupke.buddy.content.stage.level.forest.event.exploration.EastExplorationEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.exploration.NorthExplorationEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.exploration.SouthExplorationEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.general.*;
import eu.janschupke.buddy.content.stage.level.forest.event.interaction.CoinInteractionEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.interaction.UkkoDeliveryInteractionEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.interaction.UkkoInteractionEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.pickup.CoinPickupEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.transition.OutskirtsTransitionEvent;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

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
    private CoinInteractionEvent coinInteractionEvent;
    private UkkoDeliveryInteractionEvent ukkoDeliveryInteractionEvent;
    private UkkoInteractionEvent ukkoInteractionEvent;

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
        coinInteractionEvent = new CoinInteractionEvent(app);
        ukkoDeliveryInteractionEvent = new UkkoDeliveryInteractionEvent(app);
        ukkoInteractionEvent = new UkkoInteractionEvent(app);

        // Pickup.
        coinPickupEvent = new CoinPickupEvent(app);

        // Transition.
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
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
