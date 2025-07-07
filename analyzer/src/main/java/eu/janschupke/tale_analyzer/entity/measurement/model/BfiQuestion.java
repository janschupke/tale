package eu.janschupke.tale_analyzer.entity.measurement.model;

import eu.janschupke.tale_analyzer.entity.personality.Traits;

import java.io.Serializable;
import java.util.Observable;

/**
 * Represents one question within the BFI questionnaire model.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiQuestion extends Observable implements Serializable {
    private int number;
    private String description;
    private Traits trait;
    private boolean reverse;

    public BfiQuestion(int number, String description, Traits trait, boolean reverse) {
        this.number = number;
        this.description = description;
        this.trait = trait;
        this.reverse = reverse;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Traits getTrait() {
        return trait;
    }

    public boolean isReverse() {
        return reverse;
    }
}
