package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.stage.level.outskirts.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the outskirts level.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsEventHandler extends LevelEventHandler {
    private CaveTransitionEvent caveTransitionEvent;
    private CaveExplorationEvent caveExplorationEvent;
    private CaveInteractionEvent caveInteractionEvent;
    private CroneInteractionEvent croneInteractionEvent;
    private CroneShackInteractionEvent croneShackInteractionEvent;
    private ForestTransitionEvent forestTransitionEvent;
    private JackExplorationEvent jackExplorationEvent;
    private JackHouseInteractionEvent jackHouseInteractionEvent;
    private JackInteractionEvent jackInteractionEvent;
    private LumberInteractionEvent lumberInteractionEvent;
    private LumberPickupEvent lumberPickupEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private SettlementTransitionEvent settlementTransitionEvent;
    private VarpunenExplorationEvent varpunenExplorationEvent;
    private VarpunenInteractionEvent varpunenInteractionEvent;
    private VarpunenPickupEvent varpunenPickupEvent;

    public OutskirtsEventHandler(final App app) {
        super(app);

        caveTransitionEvent = new CaveTransitionEvent(app);
        caveExplorationEvent = new CaveExplorationEvent(app);
        caveInteractionEvent = new CaveInteractionEvent(app);
        croneInteractionEvent = new CroneInteractionEvent(app);
        croneShackInteractionEvent = new CroneShackInteractionEvent(app);
        forestTransitionEvent = new ForestTransitionEvent(app);
        jackExplorationEvent = new JackExplorationEvent(app);
        jackHouseInteractionEvent = new JackHouseInteractionEvent(app);
        jackInteractionEvent = new JackInteractionEvent(app);
        lumberInteractionEvent = new LumberInteractionEvent(app);
        lumberPickupEvent = new LumberPickupEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
        varpunenExplorationEvent = new VarpunenExplorationEvent(app);
        varpunenInteractionEvent = new VarpunenInteractionEvent(app);
        varpunenPickupEvent = new VarpunenPickupEvent(app);
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
