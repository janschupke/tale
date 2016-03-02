package eu.janschupke.tale.framework.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;
import eu.janschupke.tale.content.config.enumeration.tags.SituationTags;
import eu.janschupke.tale.framework.App;

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
    protected SituationTags tag;
    protected List<Decision> decisions;

    public Situation(final App app, String description, SituationTags tag) {
        this.app = app;
        this.description = description;
        this.tag = tag;
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
            if (decision.getTag().equals(tag)) {
                return decision;
            }
        }

        return null;
    }

    public SituationTags getTag() {
        return tag;
    }
}
