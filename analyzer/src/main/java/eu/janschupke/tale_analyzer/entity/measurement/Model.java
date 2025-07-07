package eu.janschupke.tale_analyzer.entity.measurement;

import eu.janschupke.tale_analyzer.entity.measurement.data.EventSummary;
import eu.janschupke.tale_analyzer.entity.measurement.results.BfiResult;
import eu.janschupke.tale_analyzer.entity.measurement.data.DataSetContainer;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventModel;
import eu.janschupke.tale_analyzer.entity.measurement.results.CalculationDataList;
import eu.janschupke.tale_analyzer.entity.measurement.results.CorrelationResult;
import eu.janschupke.tale_analyzer.entity.measurement.results.GroupedResult;

import java.io.Serializable;
import java.util.Observable;

/**
 * Provider of all model classes.
 *
 * @author jan.schupke@gmail.com
 */
public class Model extends Observable implements Serializable {
    // Input models.
    private BfiModel bfiModel;
    private GameEventModel gameEventModel;

    // Loaded data.
    private InputState inputState;
    private DataSetContainer dataSetContainer;

    // Player actions.
    private EventSummary eventSummary;

    // BFI result (questionnaire).
    private BfiResult bfiResult;

    private DataSelection dataSelection;

    private CorrelationResult correlationResult;
    private GroupedResult groupedResult;
    private CalculationDataList calculationDataList;

    public Model() {
        bfiModel = new BfiModel();
        gameEventModel = new GameEventModel();
        inputState = new InputState();
        dataSetContainer = new DataSetContainer();
        eventSummary = new EventSummary();
        bfiResult = new BfiResult();
        dataSelection = new DataSelection();
        correlationResult = new CorrelationResult();
        groupedResult = new GroupedResult();
        calculationDataList = new CalculationDataList();
    }

    public void reset() {
        bfiModel.reset();
        gameEventModel.reset();
        inputState.reset();
        dataSetContainer.reset();
        eventSummary.reset();
        bfiResult.reset();
        dataSelection.reset();
        correlationResult.reset();
        groupedResult.reset();
        calculationDataList.reset();

        setChanged();
        notifyObservers();
    }

    /**
     * Sets its state according to the loaded model state.
     *
     * @param model Loaded model.
     */
    public void load(Model model) {
        // Loaded model is in default state. Nothing to load.
        if (model == null) {
            return;
        }

        bfiModel.load(model.getBfiModel());
        gameEventModel.load(model.getGameEventModel());
        inputState.load(model.getInputState());
        dataSetContainer.load(model.getDataSetContainer());
        eventSummary.load(model.getEventSummary());
        bfiResult.load(model.getBfiResult());
        dataSelection.load(model.getDataSelection());
        correlationResult.load(model.getCorrelationResult());
        groupedResult.load(model.getGroupedResult());
        calculationDataList.load(model.getCalculationDataList());

        setChanged();
        notifyObservers();
    }

    public GroupedResult getGroupedResult() {
        return groupedResult;
    }

    public CalculationDataList getCalculationDataList() {
        return calculationDataList;
    }

    public CorrelationResult getCorrelationResult() {
        return correlationResult;
    }

    public BfiModel getBfiModel() {
        return bfiModel;
    }

    public GameEventModel getGameEventModel() {
        return gameEventModel;
    }

    public InputState getInputState() {
        return inputState;
    }

    public DataSetContainer getDataSetContainer() {
        return dataSetContainer;
    }

    public EventSummary getEventSummary() {
        return eventSummary;
    }

    public BfiResult getBfiResult() {
        return bfiResult;
    }

    public DataSelection getDataSelection() {
        return dataSelection;
    }
}
