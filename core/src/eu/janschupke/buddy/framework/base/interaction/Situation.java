package eu.janschupke.buddy.framework.base.interaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one conversational state within the interaction.
 */
public abstract class Situation {
    protected String description;
    protected List<Decision> decisions;

    public Situation(String description) {
        this.description = description;
        decisions = new ArrayList<>();
    }

    /**
     * TODO: progression graph.
     * @param decision
     * @return Following situation based on selected decision. Used for interaction progression.
     * @throws NoMoreSituationsException TODO
     */
    public abstract Situation getFollowing(Decision decision) throws NoMoreSituationsException;

    public String getDescription() {
        return description;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }
}
