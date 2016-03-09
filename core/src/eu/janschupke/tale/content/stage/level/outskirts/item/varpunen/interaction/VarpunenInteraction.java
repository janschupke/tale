package eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.interaction;

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
 * Varpunen note interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenInteraction extends Interaction {
    public VarpunenInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_VARPUNEN_NOTE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.varpunen.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.OUTSKIRTS_VARPUNEN_PICKUP)) {
            ((OutskirtsEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getVarpunenPickupEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
