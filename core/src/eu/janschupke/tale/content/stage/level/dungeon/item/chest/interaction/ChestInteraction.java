package eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.dungeon.event.DungeonEventHandler;
import eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction.situation.InvestigateSituation;
import eu.janschupke.tale.content.stage.level.dungeon.item.chest.interaction.situation.SearchSituation;

/**
 * Interaction class for the chest item.
 *
 * @author jan.schupke@gmail.com
 */
public class ChestInteraction extends Interaction {
    private Situation searchSituation;

    public ChestInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.DUNGEON_CHEST);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.dungeon.interaction.chest.title");
        Situation investigateSituation = new InvestigateSituation(app);
        searchSituation = new SearchSituation(app);
        situations.add(investigateSituation);
        situations.add(searchSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.DUNGEON_CHEST_SEARCH)) {
            ((DungeonEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChestSearchInteractionEvent().trigger();
            transition(searchSituation, app);
        } else if (decision.getTag().equals(DecisionTags.DUNGEON_CHEST_COLLECT)) {
            ((DungeonEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler())
                    .getChestCollectInteractionEvent().trigger();
            triggerable.endInteraction(app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
