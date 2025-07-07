package eu.janschupke.tale_analyzer.entity.measurement.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Model representation of user's BFI questionnaire answers.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiAnswers extends Observable implements Serializable {
    private List<Integer> answers;

    public BfiAnswers() {
        answers = new ArrayList<>();
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}
