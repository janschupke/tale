package io.schupke.tale.desktop;

import io.schupke.tale.content.config.DefaultSettings;
import io.schupke.tale.content.config.SettingsKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Platform specific properties parser for extracting screen resolution values.
 * These cannot be obtained through GDX properties loader, since they are required prior
 * to the GDX application construction.
 */
public class PropertiesParser {
    private boolean fullscreen = DefaultSettings.FULLSCREEN;
    private int width = DefaultSettings.SCREEN_WIDTH;
    private int height = DefaultSettings.SCREEN_HEIGHT;

    private final String TAG_NAME = "entry";
    private final String ATTRIBUTE_NAME = "key";

    /**
     * Parses the configuration file in order to read the window configuration.
     * @param filename Name of the configuration file.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws NumberFormatException Thrown if some of the read values cannot be cast to integers.
     */
    public void parse(String filename) throws ParserConfigurationException,
            IOException, SAXException, NumberFormatException {
        File fXmlFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        NodeList nList = doc.getElementsByTagName(TAG_NAME);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                readFullscreen(element);
                readWidth(element);
                readHeight(element);
            }
        }
    }

    /**
     * Fullscreen flag reading.
     * @param element XML element from the configuration.
     */
    private void readFullscreen(Element element) {
        if (element.getAttribute(ATTRIBUTE_NAME).equals(SettingsKeys.GRAPHICS_FULLSCREEN)) {
            fullscreen = Boolean.parseBoolean(element.getTextContent());
        }
    }

    /**
     * Window width reading.
     * @param element XML element from the configuration.
     * @throws NumberFormatException Thrown if the value cannot be cast to an integer.
     */
    private void readWidth(Element element) throws NumberFormatException {
        if (element.getAttribute(ATTRIBUTE_NAME).equals(SettingsKeys.GRAPHICS_SCREEN_WIDTH)) {
            width = Integer.parseInt(element.getTextContent());
        }
    }

    /**
     * Window height reading.
     * @param element XML element from the configuration.
     * @throws NumberFormatException Thrown if the value cannot be cast to an integer.
     */
    private void readHeight(Element element) throws NumberFormatException {
        if (element.getAttribute(ATTRIBUTE_NAME).equals(SettingsKeys.GRAPHICS_SCREEN_HEIGHT)) {
            height = Integer.parseInt(element.getTextContent());
        }
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
