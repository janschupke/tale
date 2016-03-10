package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.gate;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Opening the gate.
 *
 * @author jan.schupke@gmail.com
 */
public class GateOpenInteractionEvent extends InteractionEvent {
    public GateOpenInteractionEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {

    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_GATE_OPEN, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
