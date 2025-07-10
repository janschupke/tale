package io.schupke.tale.content.stage.level.settlement.event.interaction.smith;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

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
