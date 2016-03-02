package eu.janschupke.buddy.framework.base.interaction;

import eu.janschupke.buddy.content.config.enumeration.tags.DecisionTags;

/**
 * One decision within a set of decisions for each situation.
 *
 * @author jan.schupke@gmail.com
 */
public class Decision {
    /**
     * Description of the decision, as shown in the HUD.
     */
    protected String description;

    /**
     * Indicates whether given decision is available for picking
     * at the current time.
     * Decisions are available by default.
     */
    protected boolean available;

    /**
     * Tags that uniquely identifies the decision across the entire game.
     */
    protected DecisionTags tag;

    public Decision(String description, DecisionTags tag) {
        this.description = description;
        this.tag = tag;
        available = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public DecisionTags getTag() {
        return tag;
    }
}
