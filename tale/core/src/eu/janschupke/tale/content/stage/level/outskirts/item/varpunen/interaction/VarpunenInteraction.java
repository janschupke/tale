package eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.Situation;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.outskirts.event.OutskirtsEventHandler;

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
