package eu.janschupke.tale.content.stage.level.outskirts.item.varpunen.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.interaction.Situation;

/**
 * Varpunen note interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenNoteInteraction extends Interaction {
    public VarpunenNoteInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.OUTSKIRTS_VARPUNEN_NOTE);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.outskirts.interaction.varpunen-note.title");
        Situation investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        triggerable.endInteraction(app);
    }
}
