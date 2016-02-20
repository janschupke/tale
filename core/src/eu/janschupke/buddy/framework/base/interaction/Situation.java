package eu.janschupke.buddy.framework.base.interaction;

import eu.janschupke.buddy.framework.base.exception.NoMoreSituationsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one conversational state within the interaction.
 * @author jan.schupke@gmail.com
 */
public abstract class Situation {
    protected String description;
    protected List<Decision> decisions;

    public Situation(String description) {
        this.description = description;
        decisions = new ArrayList<>();
    }

    /**
     * Progresses to the next appropriate situation based on the decision the player has chosen.
     * @param decision Selected decision, based on which the next situation should be presented.
     * @return Following situation based on selected decision. Used for interaction progression.
     * @throws NoMoreSituationsException Thrown when no more situations to progress to are available.
     */
    public abstract Situation getFollowing(Decision decision) throws NoMoreSituationsException;

    public String getDescription() {
        return description;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }
}
