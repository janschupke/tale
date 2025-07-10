package io.schupke.tale.content.stage.level.cave.event.interaction.ville;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.inventory.InventoryItem;
import io.schupke.tale.base.container.quest.QuestChain;
import io.schupke.tale.base.container.quest.enumeration.TaskStatus;
import io.schupke.tale.base.entity.Item;
import io.schupke.tale.base.entity.Unit;
import io.schupke.tale.base.event.InteractionEvent;
import io.schupke.tale.base.exception.InventoryFullException;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.content.config.enumeration.Screens;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.GameEventTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;
import io.schupke.tale.content.stage.level.cave.CaveScreen;
import io.schupke.tale.content.stage.level.cave.item.BookItem;
import io.schupke.tale.content.stage.level.cave.unit.ville.VilleUnit;
import io.schupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import io.schupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import io.schupke.tale.content.ui.dialog.InventoryFullDialog;

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
        QuestChain chain = ((OutskirtsQuestManager)((OutskirtsScreen) app.getScreenInstance(Screens.OUTSKIRTS))
                .getQuestManager()).getJackQuestChain();
        chain.getActiveQuest().getTasks().get(1).setStatus(TaskStatus.DONE);
    }

    @Override
    protected void updateGameState() {
        app.getGameLog().addEntry(GameEventTags.CAVE_INTERACTION_VILLE_AGGRO, ((BaseScreen) app.getScreen()).getTag());

        // Adding Jack's book to inventory.
        try {
            Item bookItem = new BookItem(app.getGameState().getCurrentLevel().getWorld());
            app.getGameState().getInventory().addItem(new InventoryItem(app, bookItem));
        } catch (InventoryFullException e) {
            new InventoryFullDialog(app).show(app.getUi());
        }

        app.getGameState().getGlobalLevelState().setBookPicked(true);
        updateVilleObject();
        app.getResourceManager().getSoundHandler().playSpeech(
                app.getResourceManager().getSoundHandler().getVilleSadSound());
    }

    @Override
    protected void updateInteractions() {
        // Enabling book delivery decisions.
        Interaction jackInteraction = app.getInteraction(InteractionTags.OUTSKIRTS_JACK);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE).setAvailable(true);
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_CRONE)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_BOOK_GIVE).setAvailable(true);
        // Disabling fail decision, since the book is acquired.
        jackInteraction.getSituation(SituationTags.OUTSKIRTS_JACK_TALK)
                .getDecision(DecisionTags.OUTSKIRTS_JACK_TALK_FAIL).setAvailable(false);

        Interaction villeInteraction = app.getInteraction(InteractionTags.CAVE_VILLE);
        villeInteraction.getSituation(SituationTags.CAVE_VILLE_TALK)
                .getDecision(DecisionTags.CAVE_VILLE_TALK_INQUIRY).setAvailable(false);
    }

    private void updateVilleObject() {
        for (Unit unit : ((CaveScreen) app.getScreen()).getWorld().getUnits()) {
            if (unit instanceof VilleUnit) {
                unit.setTexture(app.getResourceManager().getTextureHandler().getCaveVilleSadTexture());
                break;
            }
        }
    }
}
