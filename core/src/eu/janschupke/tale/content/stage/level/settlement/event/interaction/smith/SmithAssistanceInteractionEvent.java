package eu.janschupke.tale.content.stage.level.settlement.event.interaction.smith;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Inquiring for assistance.
 *
 * @author jan.schupke@gmail.com
 */
public class SmithAssistanceInteractionEvent extends InteractionEvent {
    public SmithAssistanceInteractionEvent(App app) {
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
        app.getGameLog().addEntry(GameEventTags.SETTLEMENT_INTERACTION_SMITH_ASSISTANCE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
