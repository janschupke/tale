package eu.janschupke.tale_analyzer.event;

import eu.janschupke.tale_analyzer.Analyzer;
import eu.janschupke.tale_analyzer.calculation.BfiCalculator;
import eu.janschupke.tale_analyzer.config.Config;
import eu.janschupke.tale_analyzer.entity.measurement.Model;
import eu.janschupke.tale_analyzer.entity.measurement.data.*;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventGroupModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventModel;
import eu.janschupke.tale_analyzer.entity.measurement.results.CalculationDataList;
import eu.janschupke.tale_analyzer.entity.measurement.results.CorrelationResult;
import eu.janschupke.tale_analyzer.entity.measurement.results.GroupedResult;
import eu.janschupke.tale_analyzer.entity.personality.Traits;
import eu.janschupke.tale_analyzer.exception.EventNotFoundException;
import eu.janschupke.tale_analyzer.exception.InvalidCorrelationValueException;
import eu.janschupke.tale_analyzer.exception.InvalidDataSetException;
import eu.janschupke.tale_analyzer.exception.TraitNotFoundException;
import eu.janschupke.tale_analyzer.io.FileReader;
import eu.janschupke.tale_analyzer.io.FileWriter;
import eu.janschupke.tale_analyzer.language.Lang;
import eu.janschupke.tale_analyzer.util.XmlParser;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handler of all application execution events.
 *
 * @author jan.schupke@gmail.com
 */
public class EventHandler {
    private final static Logger logger = Logger.getLogger(EventHandler.class.getName());

    private Analyzer analyzer;

    public EventHandler(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Invokes the export save dialog.
     */
    public void invokeExport() {
        int result = analyzer.getMainWindow().getExportChooser().showSaveDialog(analyzer.getMainWindow());

        if (result == JFileChooser.APPROVE_OPTION) {
            File outputDirectory = analyzer.getMainWindow().getExportChooser().getSelectedFile();
            exportResults(outputDirectory);
        }
    }

    /**
     * Exports result data into the filesystem.
     *
     * @param outputDirectory Directory where the result files will be saved.
     */
    public void exportResults(File outputDirectory) {
        logger.log(Level.INFO, "Exporting data");

        executeExport(analyzer.getModel().getCorrelationResult(), outputDirectory, Config.EXPORT_FULL_FILENAME);
        executeExport(analyzer.getModel().getGroupedResult(), outputDirectory, Config.EXPORT_GROUPED_FILENAME);
    }

    /**
     * Creates the XML Document for the export and saved it to the filesystem.
     *
     * @param correlationResult Data model that is to be exported.
     * @param outputDirectory Directory of the output file.
     * @param filename Name of the output file.
     */
    private void executeExport(CorrelationResult correlationResult, File outputDirectory, String filename) {
        try {
            Document document = XmlParser.createResultDocument(correlationResult);

            String path = outputDirectory.getAbsolutePath() +
                    System.getProperty("file.separator") +
                    filename;

            FileWriter.writeXmlFile(document, path);
        } catch (TransformerException e) {
            logger.log(Level.WARNING, "Transformer exception " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException " + e.getMessage());
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, "ParserConfigurationException " + e.getMessage());
        }
    }

    /**
     * Updates data in browser panels according to the currently
     * selected data set from the list.
     *
     * @param index Selected index from the dataset list.
     */
    public void updateSelection(int index) {
        logger.log(Level.INFO, "Updating browser selection");

        // No datasets are available.
        if (index == -1) {
            analyzer.getModel().getEventSummary().reset();
            analyzer.getModel().getDataSelection().reset();
            analyzer.getModel().getBfiResult().reset();
            return;
        }

        DataSet dataSet = analyzer.getModel().getDataSetContainer().getDataSets().get(index);
        analyzer.getModel().getDataSelection().setActiveDataSet(dataSet);

        // Update summary table.
        GameEventModel gameEventModel = analyzer.getModel().getGameEventModel();
        Playthrough playthrough = analyzer.getModel().getDataSelection().getActiveDataSet().getPlaythrough();
        analyzer.getModel().getEventSummary().refresh(gameEventModel, playthrough);

        // Update BFI result table.
        BfiAnswers bfiAnswers = analyzer.getModel().getDataSelection().getActiveDataSet().getBfiAnswers();
        BfiModel bfiModel = analyzer.getModel().getBfiModel();
        Map<Traits, Double> personality = BfiCalculator.calculate(bfiAnswers, bfiModel);
        analyzer.getModel().getBfiResult().setPersonality(personality);
    }

    /**
     * Loads game model from the specified file.
     *
     * @param path Selected file path.
     */
    public void loadGameModel(String path) {
        logger.log(Level.INFO, "Loading game model");
        try {
            Document document = FileReader.readXmlDocument(path);
            GameEventModel gameEventModel = XmlParser.parseGameModel(document);
            analyzer.getModel().getGameEventModel().load(gameEventModel);
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, "ParserConfigurationException: " + e.getMessage());
        } catch (SAXException e) {
            logger.log(Level.WARNING, "SAXException: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException: " + e.getMessage());
        }
    }

    /**
     * Loads BFI model from the specified file.
     *
     * @param path Selected file path.
     */
    public void loadBfiModel(String path) {
        logger.log(Level.INFO, "Loading BFI model");
        try {
            Document document = FileReader.readXmlDocument(path);
            BfiModel bfiModel = XmlParser.parseBfiModel(document);
            analyzer.getModel().getBfiModel().load(bfiModel);
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, "ParserConfigurationException: " + e.getMessage());
        } catch (SAXException e) {
            logger.log(Level.WARNING, "SAXException: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException: " + e.getMessage());
        }
    }

    /**
     * Loads data files from the specified folder.
     *
     * @param path Selected folder path.
     */
    public void loadData(String path) {
        logger.log(Level.INFO, "Loading user data");
        List<File> directories;

        try {
            // Search for all dataset directories.
            directories = FileReader.readDirectory(path, false);
        } catch (InvalidDataSetException e) {
            logger.log(Level.WARNING, "Invalid dataset - root data path is not a directory");
            JOptionPane.showMessageDialog(analyzer.getMainWindow(),
                    Lang.write("dialog.error.data.invalid.text"),
                    Lang.write("dialog.error.data.invalid.title"), JOptionPane.ERROR_MESSAGE);
            return;
        }

        analyzer.getModel().getDataSetContainer().reset();
        List<DataSet> dataSets = new ArrayList<>();

        // Create dataset for each directory.
        for (File directory : directories) {
            logger.log(Level.INFO, String.format("Loading dataset: %s", directory.getName()));
            try {
                DataSet dataSet = parseDataSet(directory);
                dataSets.add(dataSet);
            } catch (InvalidDataSetException e) {
                logger.log(Level.WARNING, String.format("Invalid dataset - %s", e.getMessage()));
                JOptionPane.showMessageDialog(analyzer.getMainWindow(),
                        Lang.write("dialog.error.data.invalid.text"),
                        Lang.write("dialog.error.data.invalid.title"), JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                logger.log(Level.WARNING, "IOException: " + e.getMessage());
                JOptionPane.showMessageDialog(analyzer.getMainWindow(),
                        Lang.write("dialog.error.data.invalid.text"),
                        Lang.write("dialog.error.data.invalid.title"), JOptionPane.ERROR_MESSAGE);
            } catch (ParserConfigurationException e) {
                logger.log(Level.WARNING, "ParserConfigurationException: " + e.getMessage());
            } catch (SAXException e) {
                logger.log(Level.WARNING, "SAXException: " + e.getMessage());
            }
        }

        analyzer.getModel().getDataSetContainer().setDataSets(dataSets);
    }

    /**
     * Parses one of the datasets found in the data folder.
     *
     * @param directory The dataset folder.
     * @return Instance of the user's DataSet.
     * @throws InvalidDataSetException If data files are somehow invalid.
     * @throws IOException In case of a file reading problem.
     */
    private DataSet parseDataSet(File directory)
            throws InvalidDataSetException, IOException, SAXException, ParserConfigurationException {
        logger.log(Level.INFO, "Parsing dataset");
        List<File> files;

        // Searching for data files.
        files = FileReader.readDirectory(directory.getAbsolutePath(), true);
        validateDataFiles(files);

        File bfiDataFile = (files.get(0).getName().equals(Config.FILE_DATA_BFI)) ? files.get(0) : files.get(1);
        File logDataFiles = (files.get(0).getName().equals(Config.FILE_DATA_LOG)) ? files.get(0) : files.get(1);

        DataSet dataSet = new DataSet(directory.getName());
        parseBfiAnswers(dataSet, bfiDataFile);
        parseGameLog(dataSet, logDataFiles);

        return dataSet;
    }

    /**
     * Validates the consistency of dataset input files.
     *
     * @param files Log files that form a dataset.
     * @throws InvalidDataSetException If the amount of files is not 2,
     * or they are not names according to the configuration requirements.
     */
    private void validateDataFiles(List<File> files) throws InvalidDataSetException {
        logger.log(Level.INFO, "Validating dataset integrity");
        logger.log(Level.INFO, String.format("File 01 - %s", files.get(0).getName()));
        logger.log(Level.INFO, String.format("File 02 - %s", files.get(1).getName()));

        if (files.size() != 2) {
            throw new InvalidDataSetException("amount of files");
        }

        if (!(files.get(0).getName().equals(Config.FILE_DATA_BFI) && files.get(1).getName().equals(Config.FILE_DATA_LOG)) &&
                !(files.get(1).getName().equals(Config.FILE_DATA_BFI) && files.get(0).getName().equals(Config.FILE_DATA_LOG))) {
            throw new InvalidDataSetException("file names");
        }
    }

    /**
     * Parses user's BFI quiestionnaire answers into the model object instance.
     *
     * @param dataSet Target dataset.
     * @param bfiDataFile BFI questionnaire answers input file.
     * @throws IOException In case of a file reading problem.
     */
    private void parseBfiAnswers(DataSet dataSet, File bfiDataFile) throws IOException {
        logger.log(Level.INFO, "Parsing BFI answers");
        String data = FileReader.readTextFile(bfiDataFile.getAbsolutePath());
        String[] lines = data.split(System.getProperty("line.separator"));

        for (String line : lines) {
            // This is pretty cool:
            int answer = Integer.parseInt(line.split(";")[2].substring(1));
            dataSet.getBfiAnswers().getAnswers().add(answer);
        }
    }

    /**
     * Parses user's game log into the model object instance.
     *
     * @param dataSet Target dataset.
     * @param logDataFile Game log input file.
     */
    private void parseGameLog(DataSet dataSet, File logDataFile)
            throws IOException, SAXException, ParserConfigurationException {
        logger.log(Level.INFO, "Parsing game log");
        Document document = FileReader.readXmlDocument(logDataFile.getAbsolutePath());

        Playthrough playthrough = XmlParser.parsePlaythrough(document);
        dataSet.setPlaythrough(playthrough);
    }

    /**
     * Calculates the correlation results.
     */
    public void calculate() {
        logger.log(Level.INFO, "Calculating");

        calculateMatrix();
        calculateGroups();
    }

    private Map<GameEvent, Integer> fillOccurrences(Playthrough playthrough, GameEventGroupModel gameEventGroupModel) {
        Map<GameEvent, Integer> occurrences = new HashMap<>();

        for (GameEvent gameEvent : gameEventGroupModel.getEvents()) {
            occurrences.put(gameEvent, 0);
        }

        for (PlaythroughEvent playthroughEvent : playthrough.getEvents()) {
            String tag = playthroughEvent.getTag();

            for (Map.Entry entry : occurrences.entrySet()) {
                GameEvent key = (GameEvent) entry.getKey();

                if (tag.contains(key.getTag())) {
                    occurrences.put(key, (int)entry.getValue() + 1);
                }
            }
        }

        return occurrences;
    }

    private void calculateGroups() {
        GameEventGroupModel gameEventGroupModel = buildGroups();

        DataSetContainer dataSetContainer = analyzer.getModel().getDataSetContainer();
        BfiModel bfiModel = analyzer.getModel().getBfiModel();
        CalculationDataList calculationDataList = new CalculationDataList();

        GroupedResult groupedResult = analyzer.getModel().getGroupedResult();
        groupedResult.initiate(gameEventGroupModel.getEvents());

        // For each event group.
        for (GameEvent gameEvent : gameEventGroupModel.getEvents()) {
            // For each trait.
            for (Traits trait : Traits.values()) {
                // For each data set.
                for (DataSet dataSet : dataSetContainer.getDataSets()) {
                    Map<Traits, Double> bfiResult = BfiCalculator.calculate(dataSet.getBfiAnswers(), bfiModel);

                    // Extract trait value in question.
                    double traitValue = 0;
                    for (Map.Entry entry : bfiResult.entrySet()) {
                        Traits key = (Traits) entry.getKey();
                        if (key.equals(trait)) {
                            traitValue = (double) entry.getValue();
                        }
                    }

                    // Extract event occurrences.
                    Map<GameEvent, Integer> occurrences = fillOccurrences(dataSet.getPlaythrough(), gameEventGroupModel);
                    int eventOccurrences = 0;

                    for (Map.Entry entry : occurrences.entrySet()) {
                        GameEvent key = (GameEvent) entry.getKey();

                        if (key.getTag().equals(gameEvent.getTag())) {
                            eventOccurrences = (int) entry.getValue();
                        }
                    }

                    calculationDataList.addEntry(eventOccurrences, traitValue);
                }

                double[] occurrenceArray = new double[calculationDataList.getEventOccurrences().size()];
                double[] valueArray = new double[calculationDataList.getTraitValues().size()];

                for (int i = 0; i < calculationDataList.getEventOccurrences().size(); i++) {
                    occurrenceArray[i] = calculationDataList.getEventOccurrences().get(i);
                }

                for (int i = 0; i < calculationDataList.getTraitValues().size(); i++) {
                    valueArray[i] = calculationDataList.getTraitValues().get(i);
                }

                double correlation = new PearsonsCorrelation().correlation(occurrenceArray, valueArray);

                // Push to the model.
                try {
                    groupedResult.setValueAt(gameEvent.getTag(), trait, correlation);
                } catch (EventNotFoundException e) {
                    logger.log(Level.WARNING, "Event not found");
                } catch (TraitNotFoundException e) {
                    logger.log(Level.WARNING, "Trait not found");
                } catch (InvalidCorrelationValueException e) {
                    logger.log(Level.WARNING, "Invalid correlation value");
                }

                calculationDataList.reset();
            }
        }
    }

    private GameEventGroupModel buildGroups() {
        GameEventGroupModel gameEventGroupModel = new GameEventGroupModel();

        gameEventGroupModel.getEvents().add(new GameEvent("EXPLORATION", ""));
        gameEventGroupModel.getEvents().add(new GameEvent("INTERACTION", ""));
        gameEventGroupModel.getEvents().add(new GameEvent("PLAY", ""));
        gameEventGroupModel.getEvents().add(new GameEvent("TALK", ""));

        return gameEventGroupModel;
    }

    private void calculateMatrix() {
        GameEventModel gameEventModel = analyzer.getModel().getGameEventModel();
        BfiModel bfiModel = analyzer.getModel().getBfiModel();
        DataSetContainer dataSetContainer = analyzer.getModel().getDataSetContainer();

        CorrelationResult correlationResult = analyzer.getModel().getCorrelationResult();
        correlationResult.initiate(gameEventModel.getEvents());

        CalculationDataList calculationDataList = analyzer.getModel().getCalculationDataList();

        // For each game event.
        for (GameEvent gameEvent : gameEventModel.getEvents()) {
            // For each trait.
            for (Traits trait : Traits.values()) {
                // For each data set.
                for (DataSet dataSet : dataSetContainer.getDataSets()) {
                    Map<Traits, Double> bfiResult = BfiCalculator.calculate(dataSet.getBfiAnswers(), bfiModel);

                    // Extract trait value in question.
                    double traitValue = 0;
                    for (Map.Entry entry : bfiResult.entrySet()) {
                        Traits key = (Traits) entry.getKey();
                        if (key.equals(trait)) {
                            traitValue = (double) entry.getValue();
                        }
                    }

                    // Extract event occurrences.
                    EventSummary eventSummary = new EventSummary();
                    eventSummary.refresh(gameEventModel, dataSet.getPlaythrough());
                    int eventOccurrences = 0;

                    for (Map.Entry entry : eventSummary.getEvents().entrySet()) {
                        String key = (String) entry.getKey();

                        if (key.equals(gameEvent.getTag())) {
                            eventOccurrences = (int) entry.getValue();
                        }
                    }

                    calculationDataList.addEntry(eventOccurrences, traitValue);
                }

                double[] occurrenceArray = new double[calculationDataList.getEventOccurrences().size()];
                double[] valueArray = new double[calculationDataList.getTraitValues().size()];

                for (int i = 0; i < calculationDataList.getEventOccurrences().size(); i++) {
                    occurrenceArray[i] = calculationDataList.getEventOccurrences().get(i);
                }

                for (int i = 0; i < calculationDataList.getTraitValues().size(); i++) {
                    valueArray[i] = calculationDataList.getTraitValues().get(i);
                }

                double correlation = new PearsonsCorrelation().correlation(occurrenceArray, valueArray);

//                logger.log(Level.INFO, String.format("Correlation for %s, trait %s:\t %.2f",
//                        gameEvent.getTag(), trait.toString(), correlation));

                // Push to the model.
                try {
                    correlationResult.setValueAt(gameEvent.getTag(), trait, correlation);
                } catch (EventNotFoundException e) {
                    logger.log(Level.WARNING, "Event not found");
                } catch (TraitNotFoundException e) {
                    logger.log(Level.WARNING, "Trait not found");
                } catch (InvalidCorrelationValueException e) {
                    logger.log(Level.WARNING, "Invalid correlation value");
                }

                calculationDataList.reset();
            }
        }
    }

    /**
     * Resets all loaded model data.
     */
    public void clearData() {
        analyzer.getModel().reset();
    }

    /**
     * Persists model state onto the filesystem.
     */
    public void saveState() {
        logger.log(Level.INFO, "Saving state");
        Model model = analyzer.getModel();
        String filename = Config.FILE_PATH +
                System.getProperty("file.separator") +
                Config.FILE_MODEL;

        try {
            FileWriter.writeObject(filename, model);
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException: " + e.getMessage());
        }
    }

    /**
     * Loads application state from the filesystem and initiates the model accordingly.
     */
    public void loadState() {
        logger.log(Level.INFO, "Loading state");
        String filename = Config.FILE_PATH +
                System.getProperty("file.separator") +
                Config.FILE_MODEL;

        try {
            Model model = (Model) FileReader.readObject(filename);
            analyzer.getModel().load(model);

            // Reloading files.
            loadGameModel(analyzer.getModel().getInputState().getGameModelPath());
            loadBfiModel(analyzer.getModel().getInputState().getBfiModelPath());
            loadData(analyzer.getModel().getInputState().getDataFolderPath());
        } catch (IOException e) {
            logger.log(Level.WARNING, "IOException: " + e.getMessage());
        }
    }

    /**
     * Saves application state and exits.
     */
    public void exitApplication() {
        saveState();
        System.exit(0);
    }
}
