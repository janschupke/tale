package eu.janschupke.buddy.personality;

import eu.janschupke.buddy.personality.enumeration.Trait;
import eu.janschupke.buddy.personality.enumeration.Weight;

/**
 * Trait metric, consisting of one specific personality trait,
 * and a numerical weight that influences the given trait by a certain degree.
 *
 * @author jan.schupke@gmail.com
 */
public class Metric {
    private Trait trait;
    private Weight weight;

    public Metric(Trait trait, Weight weight) {
        this.trait = trait;
        this.weight = weight;
    }

    public Trait getTrait() {
        return trait;
    }

    public Weight getWeight() {
        return weight;
    }
}
