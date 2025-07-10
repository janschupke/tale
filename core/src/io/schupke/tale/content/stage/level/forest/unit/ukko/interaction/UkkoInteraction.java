package io.schupke.tale.content.stage.level.forest.unit.ukko.interaction;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Triggerable;
import io.schupke.tale.base.interaction.Decision;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.InteractionTags;
import io.schupke.tale.content.stage.level.forest.event.ForestEventHandler;

/**
 * Ukko interaction object.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoInteraction extends Interaction {
    private DiscussSituation discussSituation;
    private DeliveryResultSituation deliveryResultSituation;

    public UkkoInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.FOREST_UKKO);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.ukko.title");
        TalkSituation talkSituation = new TalkSituation(app);
        discussSituation = new DiscussSituation(app);
        deliveryResultSituation = new DeliveryResultSituation(app);
        situations.add(talkSituation);
        situations.add(deliveryResultSituation);
        situations.add(discussSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        if (decision.getTag().equals(DecisionTags.FOREST_UKKO_DELIVERY)) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getUkkoDeliveryInteractionEvent().trigger();
            transition(deliveryResultSituation, app);
        } else if (decision.getTag().equals(DecisionTags.FOREST_UKKO_DISCUSS)) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getUkkoDiscussInteractionEvent().trigger();
            transition(discussSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
