package eu.janschupke.tale.content.stage.level.settlement;

import eu.janschupke.tale.content.stage.level.settlement.event.exploration.ChoboExplorationEvent;
import eu.janschupke.tale.content.stage.level.settlement.event.exploration.DungeonExplorationEvent;
import eu.janschupke.tale.content.stage.level.settlement.event.interaction.*;
import eu.janschupke.tale.content.stage.level.settlement.event.transition.DungeonTransitionEvent;
import eu.janschupke.tale.content.stage.level.settlement.event.transition.OutskirtsTransitionEvent;
import eu.janschupke.tale.content.stage.level.settlement.event.transition.SmithHouseTransitionEvent;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.event.handling.LevelEventHandler;

/**
 * Event handler for the settlement level.
 *
 * @author jan.schupke@gmail.com
 */
public class SettlementEventHandler extends LevelEventHandler {
    // Exploration.
    private ChoboExplorationEvent choboExplorationEvent;
    private DungeonExplorationEvent dungeonExplorationEvent;

    // Interaction.
    private ChoboHouseInteractionEvent choboHouseInteractionEvent;
    private ChoboInteractionEvent choboInteractionEvent;
    private DungeonInteractionEvent dungeonInteractionEvent;
    private FarmInteractionEvent farmInteractionEvent;
    private FountainInteractionEvent fountainInteractionEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private SmithHouseInteractionEvent smithHouseInteractionEvent;
    private SmithInteractionEvent smithInteractionEvent;
    private TavernInteractionEvent tavernInteractionEvent;

    // Transition.
    private DungeonTransitionEvent dungeonTransitionEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;
    private SmithHouseTransitionEvent smithHouseTransitionEvent;

    public SettlementEventHandler(final App app) {
        super(app);

        // Exploration.
        choboExplorationEvent = new ChoboExplorationEvent(app);
        dungeonExplorationEvent = new DungeonExplorationEvent(app);

        // Interaction.
        choboHouseInteractionEvent = new ChoboHouseInteractionEvent(app);
        choboInteractionEvent = new ChoboInteractionEvent(app);
        dungeonInteractionEvent = new DungeonInteractionEvent(app);
        farmInteractionEvent = new FarmInteractionEvent(app);
        fountainInteractionEvent = new FountainInteractionEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        smithHouseInteractionEvent = new SmithHouseInteractionEvent(app);
        smithInteractionEvent = new SmithInteractionEvent(app);
        tavernInteractionEvent = new TavernInteractionEvent(app);

        // Transition.
        dungeonTransitionEvent = new DungeonTransitionEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
        smithHouseTransitionEvent = new SmithHouseTransitionEvent(app);
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
