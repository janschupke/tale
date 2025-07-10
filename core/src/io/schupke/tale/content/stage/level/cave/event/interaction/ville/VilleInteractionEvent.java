package io.schupke.tale.content.stage.level.cave.event.interaction.ville;

import io.schupke.tale.base.App;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.interaction.InteractionSwitch;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;

/**
 * Event for the interaction with the Ville unit.
 *
 * @author jan.schupke@gmail.com
 */
public class VilleInteractionEvent extends InteractionEvent {
    public VilleInteractionEvent(final App app) {
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
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_VILLE_TALK, ((BaseScreen) app.getScreen()).getTag());
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getVilleSound());
    }

    @Override
    protected void updateInteractions() {

    }
}
