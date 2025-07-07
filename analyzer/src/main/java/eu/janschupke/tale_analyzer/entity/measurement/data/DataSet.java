package eu.janschupke.tale_analyzer.entity.measurement.data;

import java.io.Serializable;
import java.util.Observable;

/**
 * Input data set of one player.
 *
 * @author jan.schupke@gmail.com
 */
public class DataSet extends Observable implements Serializable {
    private String name;
    private BfiAnswers bfiAnswers;
    private Playthrough playthrough;

    public DataSet(String name) {
        this.name = name;
        bfiAnswers = new BfiAnswers();
        playthrough = new Playthrough();
    }

    public String getName() {
        return name;
    }

    public BfiAnswers getBfiAnswers() {
        return bfiAnswers;
    }

    public Playthrough getPlaythrough() {
        return playthrough;
    }

    public void setPlaythrough(Playthrough playthrough) {
        this.playthrough = playthrough;
    }
}
