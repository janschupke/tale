package eu.janschupke.buddy.content.stage.level.cave;

import eu.janschupke.buddy.content.stage.level.cave.event.CorpsecExplorationEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.CorpsecInteractionEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.SpringInteractionEvent;
import eu.janschupke.buddy.content.stage.level.cave.event.VilleInteractionEvent;
import eu.janschupke.buddy.content.stage.level.forest.event.OutskirtsTransitionEvent;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

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
