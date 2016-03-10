package eu.janschupke.tale.content.stage.level.dungeon.event;

import eu.janschupke.tale.content.stage.level.dungeon.event.exploration.StudyExplorationEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest.ChestCollectInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest.ChestInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.chest.ChestSearchInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.gate.GateInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.gate.GateOpenInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.harpsichord.HarpsichordInteractionEvent;
import eu.janschupke.tale.content.stage.level.dungeon.event.interaction.harpsichord.HarpsichordPlayInteractionEvent;
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
    private ChestInteractionEvent chestInteractionEvent;
    private ChestSearchInteractionEvent chestSearchInteractionEvent;
    private ChestCollectInteractionEvent chestCollectInteractionEvent;
    private HarpsichordInteractionEvent harpsichordInteractionEvent;
    private HarpsichordPlayInteractionEvent harpsichordPlayInteractionEvent;
    private GateInteractionEvent gateInteractionEvent;
    private GateOpenInteractionEvent gateOpenInteractionEvent;

    // Transition.
    private ExitTransitionEvent exitTransitionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;

    public DungeonEventHandler(final App app) {
        super(app);

        // Exploration.
        studyExplorationEvent = new StudyExplorationEvent(app);

        // Interaction.
        chestInteractionEvent = new ChestInteractionEvent(app);
        chestSearchInteractionEvent = new ChestSearchInteractionEvent(app);
        chestCollectInteractionEvent = new ChestCollectInteractionEvent(app);
        harpsichordInteractionEvent = new HarpsichordInteractionEvent(app);
        harpsichordPlayInteractionEvent = new HarpsichordPlayInteractionEvent(app);
        gateInteractionEvent = new GateInteractionEvent(app);
        gateOpenInteractionEvent = new GateOpenInteractionEvent(app);

        // Transition.
        exitTransitionEvent = new ExitTransitionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public ChestCollectInteractionEvent getChestCollectInteractionEvent() {
        return chestCollectInteractionEvent;
    }

    public ChestSearchInteractionEvent getChestSearchInteractionEvent() {
        return chestSearchInteractionEvent;
    }

    public GateOpenInteractionEvent getGateOpenInteractionEvent() {
        return gateOpenInteractionEvent;
    }

    public HarpsichordPlayInteractionEvent getHarpsichordPlayInteractionEvent() {
        return harpsichordPlayInteractionEvent;
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

    public GateInteractionEvent getGateInteractionEvent() {
        return gateInteractionEvent;
    }

    public SettlementTransitionEvent getSettlementTransitionEvent() {
        return settlementTransitionEvent;
    }

    public StudyExplorationEvent getStudyExplorationEvent() {
        return studyExplorationEvent;
    }
}
