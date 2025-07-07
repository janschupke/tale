package eu.janschupke.tale_analyzer.entity.measurement.results;

import eu.janschupke.tale_analyzer.entity.personality.Traits;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Model representation of user's BFI personality result.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiResult extends Observable implements Serializable {
    private Map<Traits, Double> personality;

    public BfiResult() {
        personality = new HashMap<>();
    }

    public void reset() {
        personality.clear();
        setChanged();
        notifyObservers();
    }

    public void load(BfiResult bfiResult) {
        personality = bfiResult.getPersonality();
        setChanged();
        notifyObservers();
    }

    public void setPersonality(Map<Traits, Double> personality) {
        this.personality = personality;
        setChanged();
        notifyObservers();
    }

    public Map<Traits, Double> getPersonality() {
        return personality;
    }
}
