package eu.janschupke.tale.logging.utility;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.tags.GameEventTags;
import eu.janschupke.tale.logging.GameLog;
import eu.janschupke.tale.logging.GameLogEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Parser class that takes care of the personality model processing
 * and parsing into XML.
 *
 * @author jan.schupke@gmail.com
 */
public class GameLogParser {
    private final static Logger logger = Logger.getLogger(GameLogParser.class.getName());

    private static final String LOG_ELEMENT_ROOT = "playthrough";
    private static final String LOG_ELEMENT_EVENT = "event";
    private static final String LOG_ELEMENT_TIME = "time";
    private static final String LOG_ELEMENT_LEVEL = "level";
    private static final String LOG_ELEMENT_TAG = "tag";

    private static final String MODEL_ELEMENT_ROOT = "model";
    private static final String MODEL_ELEMENT_EVENT = "event";
    private static final String MODEL_ELEMENT_EVENT_TAG = "tag";
    private static final String MODEL_ELEMENT_EVENT_DESCRIPTION = "description";

    /**
     * Parses the game log into an XML document and saves it to the
     * pre-configured location on the disk.
     *
     * @param gameLog Provided game log object.
     */
    public static void parseToXml(final GameLog gameLog) {
        // No events.
        if (gameLog.getEntries().size() == 0) {
            return;
        }

        if (Config.DEBUG_MODE) {
            for (GameLogEntry entry : gameLog.getEntries()) {
                System.out.println(entry.getTag());
            }
        }

        try {
            Document document = createLog(gameLog);
            writeFile(document, Config.FILE_PATH + Calendar.getInstance().getTimeInMillis() + ".xml");
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - ParserConfigurationException: " + e.getMessage());
        } catch (TransformerException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - TransformerException: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - IOException: " + e.getMessage());
        }
    }

    /**
     * Exports all possible events and their descriptions the a XML file.
     */
    public static void exportEventModel() {
        try {
            Document document = createEventModel();
            writeFile(document, Config.FILE_PATH + "event-model.xml");
        } catch (ParserConfigurationException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - ParserConfigurationException: " + e.getMessage());
        } catch (TransformerException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - TransformerException: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "GameLogParser#parseToXml - IOException: " + e.getMessage());
        }
    }

    /**
     * Creates XML document containing all game events and their descriptions.
     *
     * @return XML document containing all game events.
     * @throws ParserConfigurationException
     */
    private static Document createEventModel() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document document = docBuilder.newDocument();

        // Root.
        Element rootElement = document.createElement(MODEL_ELEMENT_ROOT);
        document.appendChild(rootElement);

        // Iterate through all possible events in the game.
        for (GameEventTags event : GameEventTags.values()) {
            Element eventElement = document.createElement(MODEL_ELEMENT_EVENT);
            rootElement.appendChild(eventElement);

            Element tagElement = document.createElement(MODEL_ELEMENT_EVENT_TAG);
            tagElement.appendChild(document.createTextNode(event.toString()));
            eventElement.appendChild(tagElement);

            Element descriptionElement = document.createElement(MODEL_ELEMENT_EVENT_DESCRIPTION);
            descriptionElement.appendChild(document.createTextNode(event.getValue()));
            eventElement.appendChild(descriptionElement);
        }

        return document;
    }

    /**
     * Parses the in-game log object into an XML document.
     *
     * @param gameLog Log of all game entries.
     * @return Parsed document.
     * @throws ParserConfigurationException
     */
    private static Document createLog(final GameLog gameLog) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document document = docBuilder.newDocument();

        // Root.
        Element rootElement = document.createElement(LOG_ELEMENT_ROOT);
        document.appendChild(rootElement);

        // Entry for each event.
        for (GameLogEntry entry : gameLog.getEntries()) {
            // Event encapsulating element.
            Element eventElement = document.createElement(LOG_ELEMENT_EVENT);
            rootElement.appendChild(eventElement);

            // Data elements.
            Element dateElement = document.createElement(LOG_ELEMENT_TIME);
            dateElement.appendChild(document.createTextNode(entry.getTimestamp().toString()));
            eventElement.appendChild(dateElement);

            Element levelElement = document.createElement(LOG_ELEMENT_LEVEL);
            levelElement.appendChild(document.createTextNode(entry.getLevel().toString()));
            eventElement.appendChild(levelElement);

            Element tagElement = document.createElement(LOG_ELEMENT_TAG);
            tagElement.appendChild(document.createTextNode(entry.getTag().toString()));
            eventElement.appendChild(tagElement);
        }

        return document;
    }

    /**
     * Writes the XML document object into a file.
     *
     * @param document Parsed document created from the game log.
     * @throws TransformerException
     * @throws IOException Thrown if the directories cannot be created.
     */
    private static void writeFile(final Document document, final String filename) throws TransformerException, IOException {
        createFolders();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(document);
        StreamResult fileStream = new StreamResult(new File(filename));
        transformer.transform(source, fileStream);

        // Console output for debugging.
        if (Config.DEBUG_MODE) {
            StreamResult consoleStream = new StreamResult(System.out);
            transformer.transform(source, consoleStream);
        }
    }

    /**
     * Attempts to create all necessary directories before saving log files.
     *
     * @throws IOException Thrown if the directories cannot be created.
     */
    private static void createFolders() throws IOException {
        File logPath = new File(Config.FILE_PATH);
        if (!logPath.exists()) {
            if (!logPath.mkdirs()) {
                throw new IOException("Could not create directories.");
            }
        }
    }
}
