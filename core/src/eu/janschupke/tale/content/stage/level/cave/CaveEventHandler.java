package eu.janschupke.tale.content.stage.level.cave;

import eu.janschupke.tale.content.stage.level.cave.event.exploration.CorpsecExplorationEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.CorpsecInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.SpringInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.interaction.VilleInteractionEvent;
import eu.janschupke.tale.content.stage.level.cave.event.transition.OutskirtsTransitionEvent;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.handling.LevelEventHandler;

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
    private SpringInteractionEvent springInteractionEvent;
    private VilleInteractionEvent villeInteractionEvent;

    // Transition.
    private OutskirtsTransitionEvent outskirtsTransitionEvent;

    public CaveEventHandler(final App app) {
        super(app);

        // Exploration.
        corpsecExplorationEvent = new CorpsecExplorationEvent(app);

        // Interaction.
        corpsecInteractionEvent = new CorpsecInteractionEvent(app);
        springInteractionEvent = new SpringInteractionEvent(app);
        villeInteractionEvent = new VilleInteractionEvent(app);

        // Transition.
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
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

    public SpringInteractionEvent getSpringInteractionEvent() {
        return springInteractionEvent;
    }

    public VilleInteractionEvent getVilleInteractionEvent() {
        return villeInteractionEvent;
    }
}
