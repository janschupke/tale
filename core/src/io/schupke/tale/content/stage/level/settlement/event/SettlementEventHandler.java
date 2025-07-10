package io.schupke.tale.content.stage.level.settlement.event;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.handling.LevelEventHandler;
import io.schupke.tale.content.stage.level.settlement.event.exploration.ChoboExplorationEvent;
import io.schupke.tale.content.stage.level.settlement.event.exploration.DungeonExplorationEvent;
import io.schupke.tale.content.stage.level.settlement.event.interaction.*;
import io.schupke.tale.content.stage.level.settlement.event.interaction.chobo.*;
import io.schupke.tale.content.stage.level.settlement.event.interaction.smith.SmithAssistanceInteractionEvent;
import io.schupke.tale.content.stage.level.settlement.event.interaction.smith.SmithInteractionEvent;
import io.schupke.tale.content.stage.level.settlement.event.interaction.smith.SmithKeyAcceptInteractionEvent;
import io.schupke.tale.content.stage.level.settlement.event.interaction.smith.SmithRamblingInteractionEvent;
import io.schupke.tale.content.stage.level.settlement.event.transition.DungeonTransitionEvent;
import io.schupke.tale.content.stage.level.settlement.event.transition.OutskirtsTransitionEvent;

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
    private ChoboDiscussHouseInteractionEvent choboDiscussHouseInteractionEvent;
    private ChoboDungeonInteractionEvent choboDungeonInteractionEvent;
    private ChoboJournalGiveInteractionEvent choboJournalGiveInteractionEvent;
    private ChoboJournalInteractionEvent choboJournalInteractionEvent;
    private ChoboKeyInteractionEvent choboKeyInteractionEvent;
    private DungeonInteractionEvent dungeonInteractionEvent;
    private FarmInteractionEvent farmInteractionEvent;
    private FountainInteractionEvent fountainInteractionEvent;
    private RoadSignInteractionEvent roadSignInteractionEvent;
    private SmithHouseInteractionEvent smithHouseInteractionEvent;
    private SmithInteractionEvent smithInteractionEvent;
    private SmithAssistanceInteractionEvent smithAssistanceInteractionEvent;
    private SmithKeyAcceptInteractionEvent smithKeyAcceptInteractionEvent;
    private SmithRamblingInteractionEvent smithRamblingInteractionEvent;
    private TavernInteractionEvent tavernInteractionEvent;

    // Transition.
    private DungeonTransitionEvent dungeonTransitionEvent;
    private OutskirtsTransitionEvent outskirtsTransitionEvent;

    public SettlementEventHandler(final App app) {
        super(app);

        // Exploration.
        choboExplorationEvent = new ChoboExplorationEvent(app);
        dungeonExplorationEvent = new DungeonExplorationEvent(app);

        // Interaction.
        choboHouseInteractionEvent = new ChoboHouseInteractionEvent(app);
        choboInteractionEvent = new ChoboInteractionEvent(app);
        choboDiscussHouseInteractionEvent = new ChoboDiscussHouseInteractionEvent(app);
        choboDungeonInteractionEvent = new ChoboDungeonInteractionEvent(app);
        choboJournalGiveInteractionEvent = new ChoboJournalGiveInteractionEvent(app);
        choboJournalInteractionEvent = new ChoboJournalInteractionEvent(app);
        choboKeyInteractionEvent = new ChoboKeyInteractionEvent(app);
        dungeonInteractionEvent = new DungeonInteractionEvent(app);
        farmInteractionEvent = new FarmInteractionEvent(app);
        fountainInteractionEvent = new FountainInteractionEvent(app);
        roadSignInteractionEvent = new RoadSignInteractionEvent(app);
        smithHouseInteractionEvent = new SmithHouseInteractionEvent(app);
        smithInteractionEvent = new SmithInteractionEvent(app);
        smithAssistanceInteractionEvent = new SmithAssistanceInteractionEvent(app);
        smithKeyAcceptInteractionEvent = new SmithKeyAcceptInteractionEvent(app);
        smithRamblingInteractionEvent = new SmithRamblingInteractionEvent(app);
        tavernInteractionEvent = new TavernInteractionEvent(app);

        // Transition.
        dungeonTransitionEvent = new DungeonTransitionEvent(app);
        outskirtsTransitionEvent = new OutskirtsTransitionEvent(app);
    }

    public ChoboDungeonInteractionEvent getChoboDungeonInteractionEvent() {
        return choboDungeonInteractionEvent;
    }

    public SmithRamblingInteractionEvent getSmithRamblingInteractionEvent() {
        return smithRamblingInteractionEvent;
    }

    public ChoboDiscussHouseInteractionEvent getChoboDiscussHouseInteractionEvent() {
        return choboDiscussHouseInteractionEvent;
    }

    public ChoboJournalGiveInteractionEvent getChoboJournalGiveInteractionEvent() {
        return choboJournalGiveInteractionEvent;
    }

    public ChoboJournalInteractionEvent getChoboJournalInteractionEvent() {
        return choboJournalInteractionEvent;
    }

    public ChoboKeyInteractionEvent getChoboKeyInteractionEvent() {
        return choboKeyInteractionEvent;
    }

    public SmithAssistanceInteractionEvent getSmithAssistanceInteractionEvent() {
        return smithAssistanceInteractionEvent;
    }

    public SmithKeyAcceptInteractionEvent getSmithKeyAcceptInteractionEvent() {
        return smithKeyAcceptInteractionEvent;
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
