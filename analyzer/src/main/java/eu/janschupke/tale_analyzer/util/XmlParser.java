package eu.janschupke.tale_analyzer.util;

import eu.janschupke.tale_analyzer.config.Config;
import eu.janschupke.tale_analyzer.entity.measurement.data.Playthrough;
import eu.janschupke.tale_analyzer.entity.measurement.data.PlaythroughEvent;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiQuestion;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEvent;
import eu.janschupke.tale_analyzer.entity.measurement.model.GameEventModel;
import eu.janschupke.tale_analyzer.entity.measurement.results.CorrelationResult;
import eu.janschupke.tale_analyzer.entity.personality.Traits;
import eu.janschupke.tale_analyzer.exception.EventNotFoundException;
import eu.janschupke.tale_analyzer.exception.TraitNotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles the parsing of XML Document objects into model objects,
 * and vice versa.
 *
 * @author jan.schupke@gmail.com
 */
public class XmlParser {
    private final static Logger logger = Logger.getLogger(XmlParser.class.getName());

    private static final String RESULT_ELEMENT_ROOT = "result";
    private static final String RESULT_ELEMENT_EVENT = "event";
    private static final String RESULT_ELEMENT_EVENT_TAG = "tag";
    private static final String RESULT_ELEMENT_TRAIT = "trait";
    private static final String RESULT_ELEMENT_TRAIT_TAG = "tag";
    private static final String RESULT_ELEMENT_TRAIT_VALUE = "value";

    /**
     * Creates a Document object out of the result model.
     *
     * @param correlationResult Provided result.
     * @return XML Document of the result.
     * @throws ParserConfigurationException
     */
    public static Document createResultDocument(CorrelationResult correlationResult)
        throws ParserConfigurationException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document document = docBuilder.newDocument();

        // Root.
        Element rootElement = document.createElement(RESULT_ELEMENT_ROOT);
        document.appendChild(rootElement);

        for (GameEvent gameEvent : correlationResult.getEvents()) {
            Element eventElement = document.createElement(RESULT_ELEMENT_EVENT);
            rootElement.appendChild(eventElement);

            Element eventTagElement = document.createElement(RESULT_ELEMENT_EVENT_TAG);
            eventTagElement.appendChild(document.createTextNode(gameEvent.getTag()));
            eventElement.appendChild(eventTagElement);

            for (Traits trait : correlationResult.getTraits()) {
                Element traitElement = document.createElement(RESULT_ELEMENT_TRAIT);
                eventElement.appendChild(traitElement);

                Element traitTagElement = document.createElement(RESULT_ELEMENT_TRAIT_TAG);
                traitTagElement.appendChild(document.createTextNode(trait.toString()));
                traitElement.appendChild(traitTagElement);

                try {
                    double value = correlationResult.getValue(gameEvent.getTag(), trait);

                    Element traitValueElement = document.createElement(RESULT_ELEMENT_TRAIT_VALUE);
                    traitValueElement.appendChild(document.createTextNode(String.format("%.2f", value)));
                    traitElement.appendChild(traitValueElement);
                } catch (EventNotFoundException e) {
                    logger.log(Level.WARNING, "Event not found");
                } catch (TraitNotFoundException e) {
                    logger.log(Level.WARNING, "Trait not found");
                }
            }
        }

        return document;
    }

    /**
     * Parses game event model XML Document into its object representation.
     *
     * @param document Game model XML Document.
     * @return Game model object instance.
     */
    public static GameEventModel parseGameModel(Document document) {
        logger.log(Level.INFO, "Parsing game model");
        GameEventModel gameEventModel = new GameEventModel();

        NodeList eventsNodes = document.getElementsByTagName(Config.ELEMENT_GAME_EVENT);

        // For all events.
        for (int i = 0; i < eventsNodes.getLength(); i++) {
            Node eventNode = eventsNodes.item(i);

            NodeList eventProperties = eventNode.getChildNodes();

            String tag = "";
            String description = "";

            // For all event properties.
            for (int j = 0; j < eventProperties.getLength(); j++) {
                Node propertyNode = eventProperties.item(j);

                if (propertyNode.getNodeName().equals(Config.ELEMENT_GAME_TAG)) {
                    tag = propertyNode.getTextContent();
//                    logger.log(Level.INFO, String.format("%s", propertyNode.getTextContent()));
                }

                if (propertyNode.getNodeName().equals(Config.ELEMENT_GAME_DESCRIPTION)) {
                    description = propertyNode.getTextContent();
                }
            }

            GameEvent gameEvent = new GameEvent(tag, description);
            gameEventModel.getEvents().add(gameEvent);
        }

        return gameEventModel;
    }

    /**
     * Parses XML Document representing the BFI model into the internal BfiModel instance.
     *
     * @param document BFI model XML Document.
     * @return BFI model instance with correct values.
     */
    public static BfiModel parseBfiModel(Document document) {
        logger.log(Level.INFO, "Parsing BFI model");
        BfiModel bfiModel = new BfiModel();

        NodeList questionNodes = document.getElementsByTagName(Config.ELEMENT_BFI_QUESTION);

        // For all questions.
        for (int i = 0; i < questionNodes.getLength(); i++) {
            Node questionNode = questionNodes.item(i);

            NodeList questionProperties = questionNode.getChildNodes();
            BfiQuestion bfiQuestion = buildBfiQuestion(questionProperties);
            bfiModel.getQuestions().add(bfiQuestion);
        }

        return bfiModel;
    }

    /**
     * Builds one BFI question instance based on the XML nodes.
     *
     * @param questionProperties XML nodes of one question.
     * @return BFI question model instance.
     */
    private static BfiQuestion buildBfiQuestion(NodeList questionProperties) {
        int number = 0;
        String description = "";
        Traits trait = null;
        boolean reverse = false;

        for (int j = 0; j < questionProperties.getLength(); j++) {
            Node propertyNode = questionProperties.item(j);

            if (propertyNode.getNodeName().equals(Config.ELEMENT_BFI_NUMBER)) {
                try {
                    number = Integer.parseInt(propertyNode.getTextContent());
                } catch (NumberFormatException e) {
                    logger.log(Level.WARNING, "Invalid BFI question number format");
                }
            }

            if (propertyNode.getNodeName().equals(Config.ELEMENT_BFI_DESCRIPTION)) {
                description = propertyNode.getTextContent();
            }

            if (propertyNode.getNodeName().equals(Config.ELEMENT_BFI_TRAIT)) {
                trait = Traits.parseTrait(propertyNode.getTextContent());
            }

            if (propertyNode.getNodeName().equals(Config.ELEMENT_BFI_REVERSE)) {
                try {
                    reverse = Boolean.parseBoolean(propertyNode.getTextContent());
                } catch (IllegalArgumentException e) {
                    logger.log(Level.WARNING, "Invalid BFI question reverse format");
                }
            }
        }

        return new BfiQuestion(number, description, trait, reverse);
    }

    /**
     * Parses game playthrough log into the model instance.
     *
     * @param document Playthrough XML Document.
     * @return Model instance of the playthrough.
     */
    public static Playthrough parsePlaythrough(Document document) {
        logger.log(Level.INFO, "Parsing playthrough");
        Playthrough playthrough = new Playthrough();

        NodeList eventsNodes = document.getElementsByTagName(Config.ELEMENT_PLAYTHROUGH_EVENT);

        // For all events.
        for (int i = 0; i < eventsNodes.getLength(); i++) {
            Node eventNode = eventsNodes.item(i);

            NodeList eventProperties = eventNode.getChildNodes();

            long time = 0;
            String level = "";
            String tag = "";

            // For all event properties.
            for (int j = 0; j < eventProperties.getLength(); j++) {
                Node propertyNode = eventProperties.item(j);

                if (propertyNode.getNodeName().equals(Config.ELEMENT_PLAYTHROUGH_TIME)) {
                    try {
                        time = Long.parseLong(propertyNode.getTextContent());
                    } catch (NumberFormatException e) {
                        logger.log(Level.WARNING, "Invalid timestamp number format");
                    }
                }
                if (propertyNode.getNodeName().equals(Config.ELEMENT_PLAYTHROUGH_LEVEL)) {
                    level = propertyNode.getTextContent();
                }

                if (propertyNode.getNodeName().equals(Config.ELEMENT_PLAYTHROUGH_TAG)) {
                    tag = propertyNode.getTextContent();
                }
            }

            PlaythroughEvent playthroughEvent = new PlaythroughEvent(time, level, tag);
            playthrough.getEvents().add(playthroughEvent);
        }

        return playthrough;
    }
}
