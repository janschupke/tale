package eu.janschupke.tale.content.stage.level.outskirts.event.interaction.jack;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Jack's lumber quest was accepted.
 *
 * @author jan.schupke@gmail.com
 */
public class JackLumberAcceptInteractionEvent extends InteractionEvent {
    public JackLumberAcceptInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_INTERACTION_JACK_LUMBER_ACCEPT, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
