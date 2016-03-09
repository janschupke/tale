package eu.janschupke.tale.content.stage.level.outskirts.item.lumber.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;
import eu.janschupke.tale.framework.screen.GameScreen;

/**
 * Lumber item interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberInteraction extends Interaction {
    public LumberInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_LUMBER);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.lumber.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_LUMBER_PICKUP)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getLumberPickupEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
