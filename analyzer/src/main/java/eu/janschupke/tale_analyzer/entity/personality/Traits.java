package eu.janschupke.tale_analyzer.entity.personality;

/**
 * All FFM traits.
 *
 * @author jan.schupke@gmail.com
 */
public enum Traits {
    O, C, E, A, N;

    /**
     * Parses string value into one of the Trait values.
     *
     * @param input Input string to be parsed.
     * @return Trait value, if string value is valid. Null otherwise.
     */
    public static Traits parseTrait(String input) {
        switch (input) {
            case "O":
                return Traits.O;
            case "C":
                return Traits.C;
            case "E":
                return Traits.E;
            case "A":
                return Traits.A;
            case "N":
                return Traits.N;
            default:
                return null;
        }
    }
}
