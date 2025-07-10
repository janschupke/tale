package io.schupke.tale.content.stage.level.forest.event.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event that is triggered by interacting with the coin.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinInteractionEvent extends InteractionEvent {
    public CoinInteractionEvent(final App app) {
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
        InteractionSwitch.getTriggerable().startInteraction(app);
        app.getGameLog().addEntry(GameEventTags.FOREST_INTERACTION_COIN_INVESTIGATE, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
