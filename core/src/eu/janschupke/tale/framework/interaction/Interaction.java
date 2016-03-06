package eu.janschupke.tale.framework.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Triggerable;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains interaction logic, decisions etc.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Interaction {
    protected App app;
    protected Triggerable triggerable;
    protected String title;
    protected List<Situation> situations;

    /**
     * The situation that is currently active,
     * and therefore visible in the interaction GUI during the interaction.
     */
    protected Situation currentSituation;

    /**
     * Configured situation that is to become current in a case of sudden interaction interruption,
     * e.g. moving away from the triggerable object.
     */
    protected Situation fallbackSituation;

    /**
     * Tag that identifies the interaction across the game.
     */
    protected InteractionTags tag;

    public Interaction(final App app, final Triggerable triggerable, InteractionTags tag) {
        this.app = app;
        this.triggerable = triggerable;
        this.tag = tag;
        situations = new ArrayList<>();
        configure();
    }

    /**
     * Configures the interaction, its situations, current and fallback situations, etc.
     */
    protected abstract void configure();

    /**
     * Transitions to the provided situation.
     * @param situation New situation to be displayed.
     * @param app Application instance.
     */
    protected void transition(Situation situation, App app) {
        currentSituation = situation;
        InteractionSwitch.getTriggerable().startInteraction(app);
    }

    /**
     * All logic that happens when a decision is chosen.
     * Contains logic for each possible decision.
     *
     * @param decision Selected decision.
     */
    public abstract void handle(Decision decision);

    /**
     * Default handling. Selectes the first available decision.
     */
    public void handle() {
        handle(currentSituation.getDecisions().get(0));
    }

    public void fallback() {
        currentSituation = fallbackSituation;
    }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    /**
     * Retrieves specific situation based on the provided tag.
     * @param tag Requested situation's tag.
     * @return Situation with the provided tag.
     */
    public Situation getSituation(SituationTags tag) {
        for (Situation situation : situations) {
            if (situation.getTag().equals(tag)) {
                return situation;
            }
        }

        return null;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return currentSituation.getDescription();
    }

    public InteractionTags getTag() {
        return tag;
    }
}
