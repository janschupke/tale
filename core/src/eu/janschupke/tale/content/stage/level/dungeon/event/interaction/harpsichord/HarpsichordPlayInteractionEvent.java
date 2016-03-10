package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.harpsichord;

import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.screen.BaseScreen;

/**
 * Playing the harpsichord.
 *
 * @author jan.schupke@gmail.com
 */
public class HarpsichordPlayInteractionEvent extends InteractionEvent {
    public HarpsichordPlayInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.DUNGEON_INTERACTION_HARPSICHORD_PLAY, ((BaseScreen) app.getScreen()).getTag());
    }

    @Override
    protected void updateInteractions() {

    }
}
