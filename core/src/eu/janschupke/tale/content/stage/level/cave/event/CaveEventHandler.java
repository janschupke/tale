package eu.janschupke.tale.content.stage.level.cave.event;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.handling.LevelEventHandler;
import eu.janschupke.tale.content.stage.level.cave.event.exploration.CorpsecExplorationEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.corpsec.CorpsecInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.corpsec.CorpsecLootInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.corpsec.CorpsecSearchInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.ville.VilleAggroInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.ville.VilleInquiryInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.ville.VilleInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.ville.VilleLeaveInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.transition.OutskirtsTransitionEvent;

/**
 * Event handler for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveEventHandler extends LevelEventHandler {
    // Exploration.
    private CorpsecExplorationEvent corpsecExplorationEvent;

    // Interaction.
    private CorpsecInteractionEvent corpsecInteractionEvent;
    private CorpsecLootInteractionEvent corpsecLootInteractionEvent;
    private CorpsecSearchInteractionEvent corpsecSearchInteractionEvent;
    private VilleInteractionEvent villeInteractionEvent;
    private VilleInquiryInteractionEvent villeInquiryInteractionEvent;
    private VilleAggroInteractionEvent villeAggroInteractionEvent;
    private VilleLeaveInteractionEvent villeLeaveInteractionEvent;

    // Transition.
    private OutskirtsTransitionEvent outskirtsTransitionEvent;

    public CaveEventHandler(final App app) {
        super(app);

        // Exploration.
        corpsecExplorationEvent = new CorpsecExplorationEvent(app);

        // Interaction.
        corpsecInteractionEvent = new CorpsecInteractionEvent(app);
        corpsecLootInteractionEvent = new CorpsecLootInteractionEvent(app);
        corpsecSearchInteractionEvent = new CorpsecSearchInteractionEvent(app);
        villeInteractionEvent = new VilleInteractionEvent(app);
        villeInquiryInteractionEvent = new VilleInquiryInteractionEvent(app);
        villeAggroInteractionEvent = new VilleAggroInteractionEvent(app);
        villeLeaveInteractionEvent = new VilleLeaveInteractionEvent(app);

        // Transition.
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
    }

    public CorpsecLootInteractionEvent getCorpsecLootInteractionEvent() {
        return corpsecLootInteractionEvent;
    }

    public CorpsecSearchInteractionEvent getCorpsecSearchInteractionEvent() {
        return corpsecSearchInteractionEvent;
    }

    public VilleAggroInteractionEvent getVilleAggroInteractionEvent() {
        return villeAggroInteractionEvent;
    }

    public VilleInquiryInteractionEvent getVilleInquiryInteractionEvent() {
        return villeInquiryInteractionEvent;
    }

    public VilleLeaveInteractionEvent getVilleLeaveInteractionEvent() {
        return villeLeaveInteractionEvent;
    }

    public CorpsecExplorationEvent getCorpsecExplorationEvent() {
        return corpsecExplorationEvent;
    }

    public CorpsecInteractionEvent getCorpsecInteractionEvent() {
        return corpsecInteractionEvent;
    }

    public OutskirtsTransitionEvent getOutskirtsTransitionEvent() {
        return outskirtsTransitionEvent;
    }

    public VilleInteractionEvent getVilleInteractionEvent() {
        return villeInteractionEvent;
    }
}
