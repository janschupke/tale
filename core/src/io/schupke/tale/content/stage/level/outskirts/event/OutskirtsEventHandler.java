package io.schupke.tale.content.stage.level.outskirts.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.handling.LevelEventHandler;
import io.schupke.tale.content.stage.level.outskirts.event.exploration.CaveExplorationEvent;
import io.schupke.tale.content.stage.level.outskirts.event.exploration.JackExplorationEvent;
import io.schupke.tale.content.stage.level.outskirts.event.exploration.VarpunenExplorationEvent;
import io.schupke.tale.content.stage.level.outskirts.event.interaction.*;
import io.schupke.tale.content.stage.level.outskirts.event.interaction.jack.*;
import io.schupke.tale.content.stage.level.outskirts.event.interaction.varpunen.VarpunenGiveInteractionEvent;
import io.schupke.tale.content.stage.level.outskirts.event.interaction.varpunen.VarpunenInteractionEvent;
import io.schupke.tale.content.stage.level.outskirts.event.interaction.varpunen.VarpunenShowInteractionEvent;
import io.schupke.tale.content.stage.level.outskirts.event.pickup.LumberPickupEvent;
import io.schupke.tale.content.stage.level.outskirts.event.pickup.VarpunenPickupEvent;
import io.schupke.tale.content.stage.level.outskirts.event.transition.CaveTransitionEvent;
import io.schupke.tale.content.stage.level.outskirts.event.transition.ForestTransitionEvent;
import io.schupke.tale.content.stage.level.outskirts.event.transition.SettlementTransitionEvent;

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
    private JackCroneInteractionEvent jackCroneInteractionEvent;
    private JackLumberAcceptInteractionEvent jackLumberAcceptInteractionEvent;
    private JackLumberGiveInteractionEvent jackLumberGiveInteractionEvent;
    private JackDisputeAcceptInteractionEvent jackDisputeAcceptInteractionEvent;
    private JackDisputeSolveInteractionEvent jackDisputeSolveInteractionEvent;
    private JackDisputeRequestInteractionEvent jackDisputeRequestInteractionEvent;
    private JackLumberRequestInteractionEvent jackLumberRequestInteractionEvent;
    private JackFailInteractionEvent jackFailInteractionEvent;
    private LumberInteractionEvent lumberInteractionEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private VarpunenInteractionEvent varpunenInteractionEvent;
    private VarpunenShowInteractionEvent varpunenShowInteractionEvent;
    private VarpunenGiveInteractionEvent varpunenGiveInteractionEvent;

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
        jackCroneInteractionEvent = new JackCroneInteractionEvent(app);
        jackLumberAcceptInteractionEvent = new JackLumberAcceptInteractionEvent(app);
        jackLumberGiveInteractionEvent = new JackLumberGiveInteractionEvent(app);
        jackDisputeAcceptInteractionEvent = new JackDisputeAcceptInteractionEvent(app);
        jackDisputeSolveInteractionEvent = new JackDisputeSolveInteractionEvent(app);
        lumberInteractionEvent = new LumberInteractionEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        varpunenInteractionEvent = new VarpunenInteractionEvent(app);
        varpunenShowInteractionEvent = new VarpunenShowInteractionEvent(app);
        varpunenGiveInteractionEvent = new VarpunenGiveInteractionEvent(app);
        jackDisputeRequestInteractionEvent = new JackDisputeRequestInteractionEvent(app);
        jackLumberRequestInteractionEvent = new JackLumberRequestInteractionEvent(app);
        jackFailInteractionEvent = new JackFailInteractionEvent(app);

        // Pickup.
        lumberPickupEvent = new LumberPickupEvent(app);
        varpunenPickupEvent = new VarpunenPickupEvent(app);

        // Transition.
        caveTransitionEvent = new CaveTransitionEvent(app);
        forestTransitionEvent = new ForestTransitionEvent(app);
        settlementTransitionEvent = new SettlementTransitionEvent(app);
    }

    public JackFailInteractionEvent getJackFailInteractionEvent() {
        return jackFailInteractionEvent;
    }

    public JackCroneInteractionEvent getJackCroneInteractionEvent() {
        return jackCroneInteractionEvent;
    }

    public JackDisputeRequestInteractionEvent getJackDisputeRequestInteractionEvent() {
        return jackDisputeRequestInteractionEvent;
    }

    public JackLumberRequestInteractionEvent getJackLumberRequestInteractionEvent() {
        return jackLumberRequestInteractionEvent;
    }

    public JackDisputeAcceptInteractionEvent getJackDisputeAcceptInteractionEvent() {
        return jackDisputeAcceptInteractionEvent;
    }

    public JackDisputeSolveInteractionEvent getJackDisputeSolveInteractionEvent() {
        return jackDisputeSolveInteractionEvent;
    }

    public JackLumberAcceptInteractionEvent getJackLumberAcceptInteractionEvent() {
        return jackLumberAcceptInteractionEvent;
    }

    public JackLumberGiveInteractionEvent getJackLumberGiveInteractionEvent() {
        return jackLumberGiveInteractionEvent;
    }

    public VarpunenShowInteractionEvent getVarpunenShowInteractionEvent() {
        return varpunenShowInteractionEvent;
    }

    public VarpunenGiveInteractionEvent getVarpunenGiveInteractionEvent() {
        return varpunenGiveInteractionEvent;
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
