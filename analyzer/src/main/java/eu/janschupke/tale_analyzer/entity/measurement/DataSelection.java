package eu.janschupke.tale_analyzer.entity.measurement;

import eu.janschupke.tale_analyzer.entity.measurement.data.DataSet;

import java.io.Serializable;
import java.util.Observable;

/**
 * Holds references to currently selected data for GUI display.
 *
 * @author jan.schupke@gmail.com
 */
public class DataSelection extends Observable implements Serializable {
    private DataSet activeDataSet;

    public DataSelection() {

    }

    public void reset() {
        activeDataSet = null;
        setChanged();
        notifyObservers();
    }

    public void load(DataSelection dataSelection) {
        this.activeDataSet = dataSelection.getActiveDataSet();
    }

    public DataSet getActiveDataSet() {
        return activeDataSet;
    }

    public void setActiveDataSet(DataSet activeDataSet) {
        this.activeDataSet = activeDataSet;
        setChanged();
        notifyObservers();
    }
}
