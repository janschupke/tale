package eu.janschupke.tale.content.stage.level.cave.event.interaction.ville;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Aggro book taking event.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleAggroInteractionEvent extends InteractionEvent {
    public VilleAggroInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_VILLE_AGGRO, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
