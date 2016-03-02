package eu.janschupke.tale.content.stage.level.settlement.unit.chobo.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.entity.Triggerable;
import eu.janschupke.tale.framework.base.interaction.Decision;
import eu.janschupke.tale.framework.base.interaction.Interaction;
import eu.janschupke.tale.framework.base.interaction.Situation;

/**
 * Interaction class for the Chobo unit.
 *
 * @author jan.schupke@gmail.com
 */
public class ChoboInteraction extends Interaction {
    public ChoboInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.SETTLEMENT_CHOBO);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.settlement.interaction.chobo.title");
        Situation talkSituation = new TalkSituation(app);
        situations.add(talkSituation);
        currentSituation = talkSituation;
        fallbackSituation = talkSituation;
    }

    @Override
    public void handle(Decision decision) {
        triggerable.endInteraction(app);
    }
}
