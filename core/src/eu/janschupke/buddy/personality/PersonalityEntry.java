package eu.janschupke.buddy.personality;

import java.util.ArrayList;
import java.util.List;

/**
 * One personality entry, consisting of a description
 * and a number of metrics.
 *
 * @author jan.schupke@gmail.com
 */
public class PersonalityEntry {
    /**
     * Text description that will be shown during the personality analysis.
     * Taken from the text of the decision tied to this entry etc.
     */
    private String description;

    /**
     * List of personality metrics this entry influences.
     */
    private List<Metric> metrics;

    public PersonalityEntry(String description) {
        this(description, new ArrayList<>());
    }

    public PersonalityEntry(String description, List<Metric> metrics) {
        this.description = description;
        this.metrics = metrics;
    }

    public void addMetric(Metric metric) {
        metrics.add(metric);
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }
}
