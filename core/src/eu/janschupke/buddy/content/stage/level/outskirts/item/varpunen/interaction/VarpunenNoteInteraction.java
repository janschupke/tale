package eu.janschupke.buddy.content.stage.level.outskirts.item.varpunen.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;

/**
 * Varpunen note interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class VarpunenNoteInteraction extends Interaction {
    public VarpunenNoteInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable);
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
