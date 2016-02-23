package eu.janschupke.buddy.personality;

import java.util.ArrayList;
import java.util.List;

/**
 * Main personality model, consisting of a list of entries,
 * each of which influences a number of personality traits by a configured values.
 *
 * @author jan.schupke@gmail.com
 */
public class Personality {
    private List<PersonalityEntry> entries;

    public Personality() {
        entries = new ArrayList<>();
    }

    public void addEntry(PersonalityEntry entry) {
        entries.add(entry);
    }

    public void addEntry(String description, List<Metric> metrics) {
        entries.add(new PersonalityEntry(description, metrics));
    }

    public void clear() {
        entries.clear();
    }
}
