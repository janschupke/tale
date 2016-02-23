package eu.janschupke.buddy.framework.base.interaction;

import eu.janschupke.buddy.personality.Metric;

import java.util.ArrayList;
import java.util.List;

/**
 * One decision within a set of decisions for each situation.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Decision {
    /**
     * List of personality metrics that are applied to the overall personality
     * if this decision is chosen.
     */
    protected List<Metric> metrics;

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

    public Decision(String description) {
        metrics = new ArrayList<>();
        this.description = description;
        available = true;
    }

    /**
     * Sets all personality metrics this decision influences.
     * May be empty if a decision is not related to personality measurements.
     */
    protected abstract void configureMetrics();

    /**
     * Indicates whether this decision influences personality measurement.
     *
     * @return True is any personality metrics are found, false otherwise.
     */
    public boolean hasMetrics() {
        return !metrics.isEmpty();
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
}
