package eu.janschupke.buddy.framework.base.interaction;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains interaction logic, decisions etc.
 */
public abstract class Interaction {
    protected String title;
    protected List<Situation> situations;

    /**
     * TODO: describe
     */
    protected Situation currentSituation;

    /**
     * TODO: describe
     */
    protected Situation fallbackSituation;

    public Interaction() {
        situations = new ArrayList<>();
        configure();
    }

    protected abstract void configure();

    /**
     * TODO: describe
     */
    public abstract void handle(Decision decision);

    /**
     * TODO: describe
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

    // TODO: needed?
    public Situation getFallbackSituation() {
        return fallbackSituation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return currentSituation.getDescription();
    }
}
