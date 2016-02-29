package eu.janschupke.buddy.content.stage.level.cave;

import eu.janschupke.buddy.content.stage.level.cave.event.exploration.CorpsecExplorationEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.interaction.CorpsecInteractionEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.interaction.SpringInteractionEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.interaction.VilleInteractionEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.transition.OutskirtsTransitionEvent;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the cave level.
 *
 * @author jan.schupke@gmail.com
 */
public class CaveEventHandler extends LevelEventHandler {
    private CorpsecExplorationEvent corpsecExplorationEvent;
    private CorpsecInteractionEvent corpsecInteractionEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;
    private SpringInteractionEvent springInteractionEvent;
    private VilleInteractionEvent villeInteractionEvent;

    public CaveEventHandler(final App app) {
        super(app);
        corpsecExplorationEvent = new CorpsecExplorationEvent(app);
        corpsecInteractionEvent = new CorpsecInteractionEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
        springInteractionEvent = new SpringInteractionEvent(app);
        villeInteractionEvent = new VilleInteractionEvent(app);
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
