package eu.janschupke.tale_analyzer.entity.measurement.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Model of the current dataset list.
 *
 * @author jan.schupke@gmail.com
 */
public class DataSetContainer extends Observable implements Serializable {
    private List<DataSet> dataSets;

    public DataSetContainer() {
        dataSets = new ArrayList<>();
    }

    public void reset() {
        dataSets.clear();

        setChanged();
        notifyObservers();
    }

    public void load(DataSetContainer dataSetContainer) {
        dataSets = dataSetContainer.getDataSets();
        setChanged();
        notifyObservers();
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
        setChanged();
        notifyObservers();
    }
}
