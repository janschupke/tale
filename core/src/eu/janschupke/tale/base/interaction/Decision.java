package eu.janschupke.tale.base.interaction;

import eu.janschupke.tale.content.config.enumeration.tags.DecisionTags;

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
        this(description, tag, true);
    }

    public Decision(String description, DecisionTags tag, boolean available) {
        this.description = description;
        this.tag = tag;
        this.available = available;
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
