package eu.janschupke.tale.content.stage.level.forest.item.coin.interaction;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.interaction.Decision;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.screen.GameScreen;

/**
 * Gold coin interaction class.
 *
 * @author jan.schupke@gmail.com
 */
public class GoldCoinInteraction extends Interaction {
    private InvestigateSituation investigateSituation;

    public GoldCoinInteraction(final App app, final Triggerable triggerable) {
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
        Gdx.app.debug("Interaction#handle", "Handling gold coin pickup");
        if (decision.getTag().equals(DecisionTags.FOREST_COIN_PICKUP)) {
            ((ForestEventHandler) ((GameScreen) app.getScreen()).getLevelEventHandler()).getCoinPickupEvent().trigger();
        } else {
            triggerable.endInteraction(app);
        }
    }
}
