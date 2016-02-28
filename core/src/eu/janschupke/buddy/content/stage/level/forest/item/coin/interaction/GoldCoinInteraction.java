package eu.janschupke.buddy.content.stage.level.forest.item.coin.interaction;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.base.screen.GameScreen;

/**
 * Gold coin interaction object.
 *
 * @author jan.schupke@gmail.com
 */
public class GoldCoinInteraction extends Interaction {
    public GoldCoinInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.coin.title");
        Situation pickupSituation = new InvestigateSituation(app);
        situations.add(pickupSituation);
        currentSituation = pickupSituation;
        fallbackSituation = pickupSituation;
    }

    @Override
    public void handle(Decision decision) {
        Gdx.app.debug("Interaction#handle", "Handling gold coin pickup");
        if (decision instanceof InvestigateSituation.PickupDecision) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCoinPickupEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
