package eu.janschupke.buddy.content.stage.level.forest.event.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionEvent;
import eu.janschupke.buddy.framework.base.event.handling.InteractionSwitch;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.config.enumeration.tags.GameEventTags;

/**
 * Event that is triggered by interacting with the coin.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinInteractionEvent extends InteractionEvent {
    public CoinInteractionEvent(final App app) {
        super(app);
        repeatable = true;
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
        app.getGameLog().addEntry(GameEventTags.FOREST_COIN_INTERACTION, ((BaseScreen)app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
