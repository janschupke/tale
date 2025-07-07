package eu.janschupke.tale_analyzer.entity.measurement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Represents object structure of the BFI calculation,
 * loaded from XML.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiModel extends Observable implements Serializable {
    private List<BfiQuestion> questions;

    public BfiModel() {
        this.questions = new ArrayList<>();
    }

    public void reset() {
        questions.clear();

        setChanged();
        notifyObservers();
    }

    public void load(BfiModel bfiModel) {
        questions = bfiModel.getQuestions();

        setChanged();
        notifyObservers();
    }

    public List<BfiQuestion> getQuestions() {
        return questions;
    }
}
