package eu.janschupke.tale_analyzer.entity.measurement.results;

import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;
import eu.janschupke.tale_analyzer.entity.personality.Traits;
import eu.janschupke.tale_analyzer.exception.EventNotFoundException;
import eu.janschupke.tale_analyzer.exception.InvalidCorrelationValueException;
import eu.janschupke.tale_analyzer.exception.TraitNotFoundException;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;

/**
 * Model of the calculated correlations.
 *
 * @author jan.schupke@gmail.com
 */
public class CorrelationResult extends Observable implements Serializable {
    protected double[][] correlations;
    protected GameEvent[] events;
    protected Traits[] traits;

    public CorrelationResult() {
    }

    /**
     * Initializes all required objects.
     *
     * @param events List of events from the model.
     */
    public void initiate(List<GameEvent> events) {
        initEvents(events);
        initTraits();
        initCorrelations();
        setChanged();
        notifyObservers();
    }

    public void reset() {
        correlations = null;
        events = null;
        traits = null;
        setChanged();
        notifyObservers();
    }

    public void load(CorrelationResult correlationResult) {
        correlations = correlationResult.getCorrelations();
        events = correlationResult.getEvents();
        traits = correlationResult.getTraits();
        setChanged();
        notifyObservers();
    }

    /**
     * Initiates event array.
     *
     * @param events Game events from the model.
     */
    protected void initEvents(List<GameEvent> events) {
        this.events = new GameEvent[events.size()];

        int i = 0;
        for (GameEvent gameEvent : events) {
            this.events[i++] = gameEvent;
        }
    }

    /**
     * Initiates traits' array.
     */
    private void initTraits() {
        this.traits = new Traits[5];
        int i = 0;
        for (Traits trait : Traits.values()) {
            traits[i++] = trait;
        }
    }

    /**
     * Initiates the correlation value array.
     */
    private void initCorrelations() {
        correlations = new double[events.length][traits.length];
    }

    /**
     * Sets the correlation value at the requested position.
     *
     * @param eventIndex Index of the requested event.
     * @param traitIndex Index of the requested trait.
     * @param value Correlation value.
     * @throws InvalidCorrelationValueException
     * @throws ArrayIndexOutOfBoundsException
     */
    public void setValueAt(int eventIndex, int traitIndex, double value)
            throws InvalidCorrelationValueException, ArrayIndexOutOfBoundsException {
        if (eventIndex >= events.length || traitIndex >= traits.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (value < -1 || value > 1) {
            throw new InvalidCorrelationValueException();
        }

        correlations[eventIndex][traitIndex] = value;
        setChanged();
        notifyObservers();
    }

    /**
     * Sets the correlation value for the requested event and trait.
     *
     * @param eventTag Associated event.
     * @param trait Associated trait.
     * @param value Correlation value.
     * @throws EventNotFoundException
     * @throws InvalidCorrelationValueException
     * @throws TraitNotFoundException
     */
    public void setValueAt(String eventTag, Traits trait, double value)
            throws EventNotFoundException, InvalidCorrelationValueException, TraitNotFoundException {
        int eventIndex = getEventIndex(eventTag);
        int traitIndex = getTraitIndex(trait);

        if (value < -1 || value > 1) {
            throw new InvalidCorrelationValueException();
        }

        correlations[eventIndex][traitIndex] = value;
        setChanged();
        notifyObservers();
    }

    /**
     * Gets the correlation value at the requested position.
     *
     * @param eventIndex Array index of the requested event.
     * @param traitIndex Array index of the requested trait.
     * @return Correlation value.
     */
    public double getValueAt(int eventIndex, int traitIndex) {
        if (eventIndex >= events.length || traitIndex >= traits.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return correlations[eventIndex][traitIndex];
    }

    /**
     * Gets the correlation value for the requested event and trait.
     *
     * @param eventTag Associated event tag.
     * @param trait Associated trait.
     * @return Correlation value.
     * @throws EventNotFoundException
     * @throws TraitNotFoundException
     */
    public double getValue(String eventTag, Traits trait)
            throws EventNotFoundException, TraitNotFoundException {
        int eventIndex = getEventIndex(eventTag);
        int traitIndex = getTraitIndex(trait);

        return correlations[eventIndex][traitIndex];
    }

    /**
     * Gets the event array index based on its tag.
     *
     * @param eventTag Provided event tag.
     * @return Index of the event.
     * @throws EventNotFoundException
     */
    public int getEventIndex(String eventTag) throws EventNotFoundException {
        for (int i = 0; i < events.length; i++) {
            if (events[i].getTag().equals(eventTag)) {
                return i;
            }
        }

        throw new EventNotFoundException();
    }

    /**
     * Gets the array index of the requested trait.
     *
     * @param trait Provided trait.
     * @return Trait's array index.
     * @throws TraitNotFoundException
     */
    public int getTraitIndex(Traits trait) throws TraitNotFoundException {
        for (int i = 0; i < traits.length; i++) {
            if (traits[i].equals(trait)) {
                return i;
            }
        }

        throw new TraitNotFoundException();
    }

    public double[][] getCorrelations() {
        return correlations;
    }

    public GameEvent[] getEvents() {
        return events;
    }

    public Traits[] getTraits() {
        return traits;
    }
}
