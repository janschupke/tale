package eu.janschupke.buddy.content.stage.level.dungeon;

import eu.janschupke.buddy.content.stage.level.dungeon.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

/**
 * Event handler for the dungeon level.
 *
 * @author jan.schupke@gmail.com
 */
public class DungeonEventHandler extends LevelEventHandler {
    private BookOneInteractionEvent bookOneInteractionEvent;
    private ChestInteractionEvent chestInteractionEvent;
    private ExitTransitionEvent exitTransitionEvent;
    private HarpsichordInteractionEvent harpsichordInteractionEvent;
    private RoomFourDoorInteractionEvent roomFourDoorInteractionEvent;
    private RoomOneGateInteractionEvent roomOneGateInteractionEvent;
    private RoomTwoDoorInteractionEvent roomTwoDoorInteractionEvent;
    private RudolfInteractionEvent rudolfInteractionEvent;
    private RuneInteractionEvent runeInteractionEvent;
    private ScrollInteractionEvent scrollInteractionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;
    private SlaveInteractionEvent slaveInteractionEvent;
    private StudyExplorationEvent studyExplorationEvent;

    public DungeonEventHandler(final App app) {
        super(app);
        bookOneInteractionEvent = new BookOneInteractionEvent(app);
        chestInteractionEvent = new ChestInteractionEvent(app);
        exitTransitionEvent = new ExitTransitionEvent(app);
        harpsichordInteractionEvent = new HarpsichordInteractionEvent(app);
        roomFourDoorInteractionEvent = new RoomFourDoorInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomOneGateInteractionEvent = new RoomOneGateInteractionEvent(app);
        roomTwoDoorInteractionEvent = new RoomTwoDoorInteractionEvent(app);
        rudolfInteractionEvent = new RudolfInteractionEvent(app);
        runeInteractionEvent = new RuneInteractionEvent(app);
        scrollInteractionEvent = new ScrollInteractionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
        slaveInteractionEvent = new SlaveInteractionEvent(app);
        studyExplorationEvent = new StudyExplorationEvent(app);
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
