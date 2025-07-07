package eu.janschupke.tale_analyzer.entity.measurement;

import java.io.Serializable;
import java.util.Observable;

/**
 * Model representation of current file input paths.
 *
 * @author jan.schupke@gmail.com
 */
public class InputState extends Observable implements Serializable {
    private String gameModelPath;
    private String bfiModelPath;
    private String dataFolderPath;
    private String exportFolder;

    public InputState() {
        gameModelPath = ".";
        bfiModelPath = ".";
        dataFolderPath = ".";
        exportFolder = ".";
    }

    public void reset() {
        gameModelPath = ".";
        bfiModelPath = ".";
        dataFolderPath = ".";
        exportFolder = ".";

        setChanged();
        notifyObservers();
    }

    public void load(InputState inputState) {
        gameModelPath = inputState.getGameModelPath();
        bfiModelPath = inputState.getBfiModelPath();
        dataFolderPath = inputState.getDataFolderPath();
        exportFolder = inputState.getExportFolder();

        setChanged();
        notifyObservers();
    }

    public String getExportFolder() {
        return exportFolder;
    }

    public String getGameModelPath() {
        return gameModelPath;
    }

    public void setGameModelPath(String gameModelPath) {
        this.gameModelPath = gameModelPath;
        setChanged();
        notifyObservers();
    }

    public String getBfiModelPath() {
        return bfiModelPath;
    }

    public void setBfiModelPath(String bfiModelPath) {
        this.bfiModelPath = bfiModelPath;
        setChanged();
        notifyObservers();
    }

    public String getDataFolderPath() {
        return dataFolderPath;
    }

    public void setDataFolderPath(String dataFolderPath) {
        this.dataFolderPath = dataFolderPath;
        setChanged();
        notifyObservers();
    }
}
