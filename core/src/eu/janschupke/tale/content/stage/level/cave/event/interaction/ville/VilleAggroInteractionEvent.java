package eu.janschupke.tale.content.stage.level.cave.event.interaction.ville;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.content.stage.level.cave.CaveScreen;
import eu.janschupke.tale.content.stage.level.cave.item.BookItem;
import eu.janschupke.tale.content.stage.level.cave.unit.ville.VilleUnit;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.outskirts.quest.OutskirtsQuestManager;
import eu.janschupke.tale.content.ui.dialog.InventoryFullDialog;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.inventory.InventoryItem;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.event.InteractionEvent;
import eu.janschupke.tale.framework.exception.InventoryFullException;
import eu.janschupke.tale.framework.interaction.Interaction;
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
    }

    private void updateVilleObject() {
        for (Unit unit : ((CaveScreen) app.getScreen()).getWorld().getUnits()) {
            if (unit  instanceof VilleUnit) {
                ((VilleUnit) unit).setTexture(new Texture(Gdx.files.internal("textures/levels/cave/units/ville-sad.png")));
                break;
            }
        }
    }
}
