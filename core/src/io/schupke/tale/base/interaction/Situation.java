package io.schupke.tale.base.interaction;

import java.util.ArrayList;
import java.util.List;

import io.schupke.tale.base.App;
import io.schupke.tale.content.config.enumeration.tags.DecisionTags;
import io.schupke.tale.content.config.enumeration.tags.SituationTags;

/**
 * Represents one conversational state within the interaction.
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
