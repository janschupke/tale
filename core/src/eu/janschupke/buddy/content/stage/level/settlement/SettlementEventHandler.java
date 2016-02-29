package eu.janschupke.buddy.content.stage.level.settlement;

import eu.janschupke.buddy.content.stage.level.settlement.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementEventHandler extends LevelEventHandler {
    private ChoboExplorationEvent choboExplorationEvent;
    private ChoboHouseInteractionEvent choboHouseInteractionEvent;
    private ChoboInteractionEvent choboInteractionEvent;
    private DungeonTransitionEvent dungeonTransitionEvent;
    private DungeonExplorationEvent dungeonExplorationEvent;
    private DungeonInteractionEvent dungeonInteractionEvent;
    private FarmInteractionEvent farmInteractionEvent;
    private FountainInteractionEvent fountainInteractionEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private SmithHouseTransitionEvent smithHouseTransitionEvent;
    private SmithHouseInteractionEvent smithHouseInteractionEvent;
    private SmithInteractionEvent smithInteractionEvent;
    private TavernInteractionEvent tavernInteractionEvent;

    public SettlementEventHandler(final App app) {
        super(app);
        choboExplorationEvent = new ChoboExplorationEvent(app);
        choboHouseInteractionEvent = new ChoboHouseInteractionEvent(app);
        choboInteractionEvent = new ChoboInteractionEvent(app);
        dungeonTransitionEvent = new DungeonTransitionEvent(app);
        dungeonExplorationEvent = new DungeonExplorationEvent(app);
        dungeonInteractionEvent = new DungeonInteractionEvent(app);
        farmInteractionEvent = new FarmInteractionEvent(app);
        fountainInteractionEvent = new FountainInteractionEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        smithHouseTransitionEvent = new SmithHouseTransitionEvent(app);
        smithHouseInteractionEvent = new SmithHouseInteractionEvent(app);
        smithInteractionEvent = new SmithInteractionEvent(app);
        tavernInteractionEvent = new TavernInteractionEvent(app);
    }

    public ChoboExplorationEvent getChoboExplorationEvent() {
        return choboExplorationEvent;
    }

    public ChoboHouseInteractionEvent getChoboHouseInteractionEvent() {
        return choboHouseInteractionEvent;
    }

    public ChoboInteractionEvent getChoboInteractionEvent() {
        return choboInteractionEvent;
    }

    public DungeonTransitionEvent getDungeonTransitionEvent() {
        return dungeonTransitionEvent;
    }

    public DungeonExplorationEvent getDungeonExplorationEvent() {
        return dungeonExplorationEvent;
    }

    public DungeonInteractionEvent getDungeonInteractionEvent() {
        return dungeonInteractionEvent;
    }

    public FarmInteractionEvent getFarmInteractionEvent() {
        return farmInteractionEvent;
    }

    public FountainInteractionEvent getFountainInteractionEvent() {
        return fountainInteractionEvent;
    }

    public OutskirtsTransitionEvent getOutskirtsTransitionEvent() {
        return outskirtsTransitionEvent;
    }

    public RoadSignInteractionEvent getRoadSignInteractionEvent() {
        return roadSignInteractionEvent;
    }

    public SmithHouseTransitionEvent getSmithHouseTransitionEvent() {
        return smithHouseTransitionEvent;
    }

    public SmithHouseInteractionEvent getSmithHouseInteractionEvent() {
        return smithHouseInteractionEvent;
    }

    public SmithInteractionEvent getSmithInteractionEvent() {
        return smithInteractionEvent;
    }

    public TavernInteractionEvent getTavernInteractionEvent() {
        return tavernInteractionEvent;
    }
}
