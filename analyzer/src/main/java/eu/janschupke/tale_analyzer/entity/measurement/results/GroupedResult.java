package eu.janschupke.tale_analyzer.entity.measurement.results;

import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;

import java.util.List;

/**
 * Result class for the grouped events.
 *
 * @author jan.schupke@gmail.com
 */
public class GroupedResult extends CorrelationResult {
    public void load(GroupedResult groupedResult) {
        correlations = groupedResult.getCorrelations();
        events = groupedResult.getEvents();
        traits = groupedResult.getTraits();
        setChanged();
        notifyObservers();
    }
}
