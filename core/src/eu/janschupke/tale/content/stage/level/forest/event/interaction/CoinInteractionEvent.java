package eu.janschupke.tale.content.stage.level.forest.event.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.event.handling.InteractionSwitch;
import eu.janschupke.tale.framework.screen.BaseScreen;

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
