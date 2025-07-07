package eu.janschupke.tale.content.stage.level.forest.item.coin.interaction;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.interaction.Decision;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.forest.event.ForestEventHandler;

/**
 * Gold coin interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinInteraction extends Interaction {
    private InvestigateSituation investigateSituation;

    public CoinInteraction(final App app, final Triggerable triggerable) {
        super(app, triggerable, InteractionTags.FOREST_COIN);
    }

    @Override
    protected void configure() {
        title = app.getLang().get("level.forest.interaction.coin.title");
        investigateSituation = new InvestigateSituation(app);
        situations.add(investigateSituation);
        currentSituation = investigateSituation;
        fallbackSituation = investigateSituation;
    }

    @Override
    public void handle(Decision decision) {
        Gdx.app.debug("Interaction#handle", "Handling coin pickup");
        if (decision.getTag().equals(DecisionTags.FOREST_COIN_PICKUP)) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCoinPickupEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
