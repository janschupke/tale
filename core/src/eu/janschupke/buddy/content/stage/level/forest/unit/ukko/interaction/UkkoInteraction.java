package eu.janschupke.buddy.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.config.enumeration.interaction.DecisionTags;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;

/**
 * Ukko interaction object.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoInteraction extends Interaction {
    Situation talkSituation;
    Situation deliveryResultSituation;

    public UkkoInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.FOREST_UKKO);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.ukko.title");
        talkSituation = new TalkSituation(app);
        deliveryResultSituation = new DeliveryResultSituation(app);
        situations.add(talkSituation);
        situations.add(deliveryResultSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.FOREST_UKKO_DELIVERY)) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getUkkoDeliveryGeneralEvent().trigger();
            transition(deliveryResultSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
