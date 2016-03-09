package eu.janschupke.tale.content.stage.level.house.event;

import eu.janschupke.tale.content.stage.level.house.event.exploration.FarExplorationEvent;
import eu.janschupke.tale.content.stage.level.house.event.exploration.RoomExplorationEvent;
import eu.janschupke.tale.content.stage.level.house.event.interaction.BedInteractionEvent;
import eu.janschupke.tale.content.stage.level.house.event.interaction.BookInteractionEvent;
import eu.janschupke.tale.content.stage.level.house.event.interaction.BookShelfInteractionEvent;
import eu.janschupke.tale.content.stage.level.house.event.interaction.MeadInteractionEvent;
import eu.janschupke.tale.content.stage.level.house.event.pickup.BookPickupEvent;
import eu.janschupke.tale.content.stage.level.house.event.pickup.MeadPickupEvent;
import eu.janschupke.tale.content.stage.level.house.event.transition.SettlementTransitionEvent;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.handling.LevelEventHandler;

/**
 * Event handler for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseEventHandler extends LevelEventHandler {
    // Exploration.
    private FarExplorationEvent farExplorationEvent;
    private RoomExplorationEvent roomExplorationEvent;

    // Interaction.
    private BedInteractionEvent bedInteractionEvent;
    private BookInteractionEvent bookInteractionEvent;
    private BookShelfInteractionEvent bookShelfInteractionEvent;
    private MeadInteractionEvent meadInteractionEvent;

    // Pickup.
    private BookPickupEvent bookPickupEvent;
    private MeadPickupEvent meadPickupEvent;

    // Transition.
    private SettlementTransitionEvent settlementTransitionEvent;

    public HouseEventHandler(final App app) {
        super(app);

        // Exploration.
        farExplorationEvent = new FarExplorationEvent(app);
        roomExplorationEvent = new RoomExplorationEvent(app);

        // Interaction.
        bedInteractionEvent = new BedInteractionEvent(app);
        bookInteractionEvent = new BookInteractionEvent(app);
        bookShelfInteractionEvent = new BookShelfInteractionEvent(app);
        meadInteractionEvent = new MeadInteractionEvent(app);

        // Pickup.
        bookPickupEvent = new BookPickupEvent(app);
        meadPickupEvent = new MeadPickupEvent(app);

        // Transition.
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public BedInteractionEvent getBedInteractionEvent() {
        return bedInteractionEvent;
    }

    public BookInteractionEvent getBookInteractionEvent() {
        return bookInteractionEvent;
    }

    public BookPickupEvent getBookPickupEvent() {
        return bookPickupEvent;
    }

    public BookShelfInteractionEvent getBookShelfInteractionEvent() {
        return bookShelfInteractionEvent;
    }

    public FarExplorationEvent getFarExplorationEvent() {
        return farExplorationEvent;
    }

    public MeadInteractionEvent getMeadInteractionEvent() {
        return meadInteractionEvent;
    }

    public MeadPickupEvent getMeadPickupEvent() {
        return meadPickupEvent;
    }

    public RoomExplorationEvent getRoomExplorationEvent() {
        return roomExplorationEvent;
    }

    public SettlementTransitionEvent getSettlementTransitionEvent() {
        return settlementTransitionEvent;
    }
}
