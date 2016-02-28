package eu.janschupke.buddy.framework.base.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.enumeration.DecisionTags;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one conversational state within the interaction.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Situation {
    protected App app;
    protected String description;
    protected List<Decision> decisions;

    public Situation(final App app, String description) {
        this.app = app;
        this.description = description;
        decisions = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public Decision getDecision(DecisionTags tag) {
        for (Decision decision : decisions) {
            if (decision.getTag() == tag) {
                return decision;
            }
        }

        return null;
    }
}
