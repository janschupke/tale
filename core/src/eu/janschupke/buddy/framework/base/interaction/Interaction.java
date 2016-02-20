package eu.janschupke.buddy.framework.base.interaction;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.base.exception.NoMoreSituationsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains interaction logic, decisions etc.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Interaction {
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

    public Interaction() {
        situations = new ArrayList<>();
        configure();
    }

    /**
     * Configures the interaction, its situations, current and fallback situations, etc.
     */
    protected abstract void configure();

    /**
     * All logic that happens when a decision is chosen.
     * Contains logic for each possible decision.
     *
     * @param decision Selected decision.
     */
    public abstract void handle(Decision decision);

    /**
     * Transitions to the next situation,
     * based on the current situation and selected decision.
     *
     * @param decision Selected decision.
     */
    protected void transition(Decision decision) {
        try {
            currentSituation = currentSituation.getFollowing(decision);
        } catch (NoMoreSituationsException e) {
            Gdx.app.debug("Interaction#transition", "No more situations to transition to");
        }
    }

    public void fallback() {
        currentSituation = fallbackSituation;
    }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return currentSituation.getDescription();
    }
}
