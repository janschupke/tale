package eu.janschupke.tale.content.stage.level.dungeon;

import eu.janschupke.tale.content.stage.level.dungeon.event.exploration.StudyExplorationEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.*;
import eu.janschupke.tale.content.stage.level.dungeon.event.transition.ExitTransitionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.transition.SettlementTransitionEvent;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonEventHandler extends LevelEventHandler {
    // Exploration.
    private StudyExplorationEvent studyExplorationEvent;

    // Interaction.
    private BookOneInteractionEvent bookOneInteractionEvent;
    private ChestInteractionEvent chestInteractionEvent;
    private HarpsichordInteractionEvent harpsichordInteractionEvent;
    private RoomFourDoorInteractionEvent roomFourDoorInteractionEvent;
    private RoomOneGateInteractionEvent roomOneGateInteractionEvent;
    private RoomTwoDoorInteractionEvent roomTwoDoorInteractionEvent;
    private RudolfInteractionEvent rudolfInteractionEvent;
    private RuneInteractionEvent runeInteractionEvent;
    private ScrollInteractionEvent scrollInteractionEvent;
    private SlaveInteractionEvent slaveInteractionEvent;

    // Transition.
    private ExitTransitionEvent exitTransitionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;

    public DungeonEventHandler(final App app) {
        super(app);

        // Exploration.
        studyExplorationEvent = new StudyExplorationEvent(app);

        // Interaction.
        bookOneInteractionEvent = new BookOneInteractionEvent(app);
        chestInteractionEvent = new ChestInteractionEvent(app);
        harpsichordInteractionEvent = new HarpsichordInteractionEvent(app);
        roomFourDoorInteractionEvent = new RoomFourDoorInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomTwoDoorInteractionEvent = new RoomTwoDoorInteractionEvent(app);
        rudolfInteractionEvent = new RudolfInteractionEvent(app);
        runeInteractionEvent = new RuneInteractionEvent(app);
        scrollInteractionEvent = new ScrollInteractionEvent(app);
        slaveInteractionEvent = new SlaveInteractionEvent(app);

        // Transition.
        exitTransitionEvent = new ExitTransitionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public BookOneInteractionEvent getBookOneInteractionEvent() {
        return bookOneInteractionEvent;
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

    public RudolfInteractionEvent getRudolfInteractionEvent() {
        return rudolfInteractionEvent;
    }

    public RuneInteractionEvent getRuneInteractionEvent() {
        return runeInteractionEvent;
    }

    public ScrollInteractionEvent getScrollInteractionEvent() {
        return scrollInteractionEvent;
    }

    public SettlementTransitionEvent getSettlementTransitionEvent() {
        return settlementTransitionEvent;
    }

    public SlaveInteractionEvent getSlaveInteractionEvent() {
        return slaveInteractionEvent;
    }

    public StudyExplorationEvent getStudyExplorationEvent() {
        return studyExplorationEvent;
    }
}
