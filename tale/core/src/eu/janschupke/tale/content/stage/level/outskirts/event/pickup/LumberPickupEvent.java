package eu.janschupke.tale.content.stage.level.outskirts.event.pickup;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.base.event.PickupEvent;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;

/**
 * Event for the lumber item pickup.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberPickupEvent extends PickupEvent {
    public LumberPickupEvent(final App app) {
        super(app);
    }

    @Override
    protected void updateMessages() {

    }

    @Override
    protected void updateQuests() {
        // If quest is accepted, set pickup task as done.
        if (app.getGameState().getGlobalLevelState().isLumberQuestAccepted()) {
            QuestChain chain = ((OutskirtsQuestManager) ((OutskirtsScreen) app.getScreen()).getQuestManager()).getJackQuestChain();
            chain.getActiveQuest().getTasks().get(0).setStatus(TaskStatus.DONE);
        }
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.OUTSKIRTS_PICKUP_LUMBER, ((BaseScreen) app.getScreen()).getTag());
        app.getGameState().getGlobalLevelState().setLumberPicked(true);
        app.getResourceManager().getSoundHandler().playSound(
                app.getResourceManager().getSoundHandler().getLumberSound());
    }

    @Override
    protected void updateInteractions() {
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);
        // If quest exists, allow direct give decisions.
        if (app.getGameState().getGlobalLevelState().isLumberQuestAccepted()) {
            jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                    .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(true);
            jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_CRONE)
                    .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(true);
            jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_LUMBER_ACCEPT)
                    .getDecision(DecisionTags.OUTSKIRTS_JACK_LUMBER_GIVE).setAvailable(true);
        }
    }
}
