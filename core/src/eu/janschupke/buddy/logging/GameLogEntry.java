package eu.janschupke.buddy.logging;

/**
 * One personality entry, consisting of a description
 * and a number of metrics.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogEntry {
    /**
     * Text description that will be shown during the personality analysis.
     * Taken from the text of the decision tied to this entry etc.
     */
    private String description;

    // TODO: some tag

    public GameLogEntry(String description) {
        this.description = description;
    }
}
