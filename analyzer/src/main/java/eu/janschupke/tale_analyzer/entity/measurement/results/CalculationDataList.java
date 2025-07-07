package eu.janschupke.tale_analyzer.entity.measurement.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * List of (eventOccurrences : traitResult) pairs for each tested user.
 *
 * @author jan.schupke@gmail.com
 */
public class CalculationDataList extends Observable implements Serializable {
    private List<Integer> eventOccurrences;
    private List<Double> traitValues;

    public CalculationDataList() {
        eventOccurrences = new ArrayList<>();
        traitValues = new ArrayList<>();
    }

    public void reset() {
        eventOccurrences.clear();
        traitValues.clear();
        setChanged();
        notifyObservers();
    }

    public void load(CalculationDataList calculationDataList) {
        eventOccurrences = calculationDataList.getEventOccurrences();
        traitValues = calculationDataList.getTraitValues();
        setChanged();
        notifyObservers();
    }

    public void addEntry(int eventOccurrences, double traitValue) {
        this.eventOccurrences.add(eventOccurrences);
        this.traitValues.add(traitValue);
    }

    public List<Integer> getEventOccurrences() {
        return eventOccurrences;
    }

    public List<Double> getTraitValues() {
        return traitValues;
    }
}
