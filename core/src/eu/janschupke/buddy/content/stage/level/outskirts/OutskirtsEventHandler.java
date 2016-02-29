package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.stage.level.outskirts.event.exploration.CaveExplorationEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.exploration.JackExplorationEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.exploration.VarpunenExplorationEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.interaction.*;
import eu.janschupke.buddy.content.stage.level.outskirts.event.pickup.LumberPickupEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.pickup.VarpunenPickupEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.transition.CaveTransitionEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.transition.ForestTransitionEvent;
import eu.janschupke.buddy.content.stage.level.outskirts.event.transition.SettlementTransitionEvent;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the outskirts level.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsEventHandler extends LevelEventHandler {
    // Exploration.
    private CaveExplorationEvent caveExplorationEvent;
    private JackExplorationEvent jackExplorationEvent;
    private VarpunenExplorationEvent varpunenExplorationEvent;

    // Interaction.
    private CaveInteractionEvent caveInteractionEvent;
    private CroneInteractionEvent croneInteractionEvent;
    private CroneShackInteractionEvent croneShackInteractionEvent;
    private JackHouseInteractionEvent jackHouseInteractionEvent;
    private JackInteractionEvent jackInteractionEvent;
    private LumberInteractionEvent lumberInteractionEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private VarpunenInteractionEvent varpunenInteractionEvent;

    // Pickup.
    private LumberPickupEvent lumberPickupEvent;
    private VarpunenPickupEvent varpunenPickupEvent;

    // Transition.
    private CaveTransitionEvent caveTransitionEvent;
    private ForestTransitionEvent forestTransitionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;

    public OutskirtsEventHandler(final App app) {
        super(app);

        // Exploration.
        caveExplorationEvent = new CaveExplorationEvent(app);
        jackExplorationEvent = new JackExplorationEvent(app);
        varpunenExplorationEvent = new VarpunenExplorationEvent(app);

        // Interaction.
        caveInteractionEvent = new CaveInteractionEvent(app);
        croneInteractionEvent = new CroneInteractionEvent(app);
        croneShackInteractionEvent = new CroneShackInteractionEvent(app);
        jackHouseInteractionEvent = new JackHouseInteractionEvent(app);
        jackInteractionEvent = new JackInteractionEvent(app);
        lumberInteractionEvent = new LumberInteractionEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        varpunenInteractionEvent = new VarpunenInteractionEvent(app);

        // Pickup.
        lumberPickupEvent = new LumberPickupEvent(app);
        varpunenPickupEvent = new VarpunenPickupEvent(app);

        // Transition.
        caveTransitionEvent = new CaveTransitionEvent(app);
        forestTransitionEvent = new ForestTransitionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public CaveTransitionEvent getCaveTransitionEvent() {
        return caveTransitionEvent;
    }

    public CaveExplorationEvent getCaveExplorationEvent() {
        return caveExplorationEvent;
    }

    public CaveInteractionEvent getCaveInteractionEvent() {
        return caveInteractionEvent;
    }

    public CroneInteractionEvent getCroneInteractionEvent() {
        return croneInteractionEvent;
    }

    public CroneShackInteractionEvent getCroneShackInteractionEvent() {
        return croneShackInteractionEvent;
    }

    public ForestTransitionEvent getForestTransitionEvent() {
        return forestTransitionEvent;
    }

    public JackExplorationEvent getJackExplorationEvent() {
        return jackExplorationEvent;
    }

    public JackHouseInteractionEvent getJackHouseInteractionEvent() {
        return jackHouseInteractionEvent;
    }

    public JackInteractionEvent getJackInteractionEvent() {
        return jackInteractionEvent;
    }

    public LumberInteractionEvent getLumberInteractionEvent() {
        return lumberInteractionEvent;
    }

    public LumberPickupEvent getLumberPickupEvent() {
        return lumberPickupEvent;
    }

    public RoadSignInteractionEvent getRoadSignInteractionEvent() {
        return roadSignInteractionEvent;
    }

    public SettlementTransitionEvent getSettlementTransitionEvent() {
        return settlementTransitionEvent;
    }

    public VarpunenExplorationEvent getVarpunenExplorationEvent() {
        return varpunenExplorationEvent;
    }

    public VarpunenInteractionEvent getVarpunenInteractionEvent() {
        return varpunenInteractionEvent;
    }

    public VarpunenPickupEvent getVarpunenPickupEvent() {
        return varpunenPickupEvent;
    }
}
