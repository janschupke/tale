package io.schupke.tale.content.stage.level.outskirts.event.interaction.varpunen;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.ItemTags;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Occurs when the Varpunen note is given to the crone.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenGiveInteractionEvent extends InteractionEvent {
    public VarpunenGiveInteractionEvent(App app) {
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
        app.getGameState().getInventory().removeItem(ItemTags.OUTSKIRTS_VARPUNEN);
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_GIVE, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {
        Interaction croneInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_CRONE);
        croneInteraction.getSituation(SituationTags.OUTSKIRTS_CRONE_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_CRONE_VARPUNEN_GIVE).setAvailable(false);
    }
}
