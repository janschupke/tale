package eu.janschupke.buddy.content.stage.level.house;

import eu.janschupke.buddy.content.stage.level.house.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

/**
 * Event handler for the house level.
 *
 * @author jan.schupke@gmail.com
 */
public class HouseEventHandler extends LevelEventHandler {
    private BedInteractionEvent bedInteractionEvent;
    private BookInteractionEvent bookInteractionEvent;
    private BookPickupEvent bookPickupEvent;
    private BookShelfInteractionEvent bookShelfInteractionEvent;
    private CauldronInteractionEvent cauldronInteractionEvent;
    private FarExplorationEvent farExplorationEvent;
    private MeadInteractionEvent meadInteractionEvent;
    private MeadPickupEvent meadPickupEvent;
    private RoomExplorationEvent roomExplorationEvent;
    private SettlementTransitionEvent settlementTransitionEvent;

    public HouseEventHandler(final App app) {
        super(app);

        bedInteractionEvent = new BedInteractionEvent(app);
        bookInteractionEvent = new BookInteractionEvent(app);
        bookPickupEvent = new BookPickupEvent(app);
        bookShelfInteractionEvent = new BookShelfInteractionEvent(app);
        cauldronInteractionEvent = new CauldronInteractionEvent(app);
        farExplorationEvent = new FarExplorationEvent(app);
        meadInteractionEvent = new MeadInteractionEvent(app);
        meadPickupEvent = new MeadPickupEvent(app);
        roomExplorationEvent = new RoomExplorationEvent(app);
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

    public CauldronInteractionEvent getCauldronInteractionEvent() {
        return cauldronInteractionEvent;
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
