package eu.janschupke.tale.logging.utility;

import java.io.File;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.logging.GameLog;
import eu.janschupke.tale.logging.GameLogEntry;

/**
 * Parser class that takes care of the personality model processing
 * and parsing into XML.
 */
public class GameLogParser {
    private static final Logger logger = Logger.getLogger(GameLogParser.class.getName());

    /**
     * Exports the event model to XML format.
     * Creates a structured XML document containing all game events
     * for personality analysis.
     */
    public static void exportEventModel() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("eventModel");
            document.appendChild(root);

            // Add timestamp for when the model was exported
            Element timestamp = document.createElement("timestamp");
            timestamp.appendChild(document.createTextNode(String.valueOf(Calendar.getInstance().getTimeInMillis())));
            root.appendChild(timestamp);

            // Add game information
            Element gameInfo = document.createElement("gameInfo");
            Element gameTitle = document.createElement("title");
            gameTitle.appendChild(document.createTextNode(Config.GAME_TITLE));
            gameInfo.appendChild(gameTitle);
            root.appendChild(gameInfo);

            // Write to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(Config.FILE_PATH + "eventModel.xml"));
            transformer.transform(source, result);

            logger.info("Event model exported successfully");
        } catch (ParserConfigurationException | TransformerException e) {
            logger.log(Level.SEVERE, "Error exporting event model", e);
        }
    }

    /**
     * Parses a GameLog object into XML format.
     * Converts the game log entries into a structured XML document.
     *
     * @param gameLog The game log to parse
     */
    public static void parseToXml(GameLog gameLog) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("gameLog");
            document.appendChild(root);

            // Add timestamp for when the log was exported
            Element timestamp = document.createElement("exportTimestamp");
            timestamp.appendChild(document.createTextNode(String.valueOf(Calendar.getInstance().getTimeInMillis())));
            root.appendChild(timestamp);

            // Add each log entry
            for (GameLogEntry entry : gameLog.getEntries()) {
                Element entryElement = document.createElement("entry");
                
                Element entryTimestamp = document.createElement("timestamp");
                entryTimestamp.appendChild(document.createTextNode(String.valueOf(entry.getTimestamp())));
                entryElement.appendChild(entryTimestamp);
                
                Element level = document.createElement("level");
                level.appendChild(document.createTextNode(entry.getLevel().toString()));
                entryElement.appendChild(level);
                
                Element tag = document.createElement("tag");
                tag.appendChild(document.createTextNode(entry.getTag().toString()));
                entryElement.appendChild(tag);
                
                root.appendChild(entryElement);
            }

            // Write to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(Config.FILE_PATH + "gameLog.xml"));
            transformer.transform(source, result);

            logger.info("Game log parsed to XML successfully");
        } catch (ParserConfigurationException | TransformerException e) {
            logger.log(Level.SEVERE, "Error parsing game log to XML", e);
        }
    }
}
