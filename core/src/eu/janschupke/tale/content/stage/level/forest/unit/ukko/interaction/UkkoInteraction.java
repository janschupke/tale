package eu.janschupke.tale.content.stage.level.forest.unit.ukko.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.screen.GameScreen;

/**
 * Ukko interaction object.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoInteraction extends Interaction {
    private TalkSituation talkSituation;
    private DiscussSituation discussSituation;
    private DeliveryResultSituation deliveryResultSituation;

    public UkkoInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.FOREST_UKKO);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.ukko.title");
        talkSituation = new TalkSituation(app);
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
            transition(discussSituation, app);
        } else {
            triggerable.endInteraction(app);
        }
    }
}
