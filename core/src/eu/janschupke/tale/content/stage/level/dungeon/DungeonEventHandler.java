package eu.janschupke.tale.content.stage.level.dungeon;

import eu.janschupke.tale.content.stage.level.dungeon.event.exploration.StudyExplorationEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.*;
import eu.janschupke.tale.content.stage.level.dungeon.event.transition.ExitTransitionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.transition.SettlementTransitionEvent;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.handling.LevelEventHandler;

/**
 * Event handler for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonEventHandler extends LevelEventHandler {
    // Exploration.
    private StudyExplorationEvent studyExplorationEvent;

    // Interaction.
    private BookInteractionEvent bookInteractionEvent;
    private ChestInteractionEvent chestInteractionEvent;
    private HarpsichordInteractionEvent harpsichordInteractionEvent;
    private RoomFourDoorInteractionEvent roomFourDoorInteractionEvent;
    private RoomOneGateInteractionEvent roomOneGateInteractionEvent;
    private RoomTwoDoorInteractionEvent roomTwoDoorInteractionEvent;
    private ScrollInteractionEvent scrollInteractionEvent;

    // Transition.
    private ExitTransitionEvent exitTransitionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;

    public DungeonEventHandler(final App app) {
        super(app);

        // Exploration.
        studyExplorationEvent = new StudyExplorationEvent(app);

        // Interaction.
        bookInteractionEvent = new BookInteractionEvent(app);
        chestInteractionEvent = new ChestInteractionEvent(app);
        harpsichordInteractionEvent = new HarpsichordInteractionEvent(app);
        roomFourDoorInteractionEvent = new RoomFourDoorInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomTwoDoorInteractionEvent = new RoomTwoDoorInteractionEvent(app);
        scrollInteractionEvent = new ScrollInteractionEvent(app);

        // Transition.
        exitTransitionEvent = new ExitTransitionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public BookInteractionEvent getBookInteractionEvent() {
        return bookInteractionEvent;
    }

    public ChestInteractionEvent getChestInteractionEvent() {
        return chestInteractionEvent;
    }

    public ExitTransitionEvent getExitTransitionEvent() {
        return exitTransitionEvent;
    }

    public HarpsichordInteractionEvent getHarpsichordInteractionEvent() {
        return harpsichordInteractionEvent;
    }

    public RoomFourDoorInteractionEvent getRoomFourDoorInteractionEvent() {
        return roomFourDoorInteractionEvent;
    }

    public RoomOneGateInteractionEvent getRoomOneGateInteractionEvent() {
        return roomOneGateInteractionEvent;
    }

    public RoomTwoDoorInteractionEvent getRoomTwoDoorInteractionEvent() {
        return roomTwoDoorInteractionEvent;
    }

    public ScrollInteractionEvent getScrollInteractionEvent() {
        return scrollInteractionEvent;
    }

    public SettlementTransitionEvent getSettlementTransitionEvent() {
        return settlementTransitionEvent;
    }

    public StudyExplorationEvent getStudyExplorationEvent() {
        return studyExplorationEvent;
    }
}
