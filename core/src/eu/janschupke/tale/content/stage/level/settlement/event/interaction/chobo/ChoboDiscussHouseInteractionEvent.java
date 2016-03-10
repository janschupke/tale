package eu.janschupke.tale.content.stage.level.settlement.event.interaction.chobo;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * House is discussed.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboDiscussHouseInteractionEvent extends InteractionEvent {
    public ChoboDiscussHouseInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_CHOBO_HOUSE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}