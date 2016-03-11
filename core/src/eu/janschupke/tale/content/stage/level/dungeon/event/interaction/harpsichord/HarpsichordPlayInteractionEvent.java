package eu.janschupke.tale.content.stage.level.dungeon.event.interaction.harpsichord;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.event.InteractionEvent;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;

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
        app.getResourceManager().getMusicHandler().playHarpsichord();
    }

    @Override
    protected void updateInteractions() {

    }
}
