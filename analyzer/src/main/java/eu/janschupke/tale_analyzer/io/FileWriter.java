package eu.janschupke.tale_analyzer.io;

import eu.janschupke.tale_analyzer.config.Config;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Handles all file writing that is required throughout the application.
 *
 * @author jan.schupke@gmail.com
 */
public class FileWriter {
    /**
     * Creates all required folders into which the files will be written.
     *
     * @throws IOException
     */
    private static void createFolders() throws IOException {
        File logPath = new File(Config.FILE_PATH);
        if (!logPath.exists()) {
            if (!logPath.mkdirs()) {
                throw new IOException("Could not create directories.");
            }
        }
    }

    /**
     * Object serialization.
     *
     * @param file   Destination file.
     * @param object Data structure to be saved.
     * @return True if successfully saved, false otherwise.
     * @throws IOException
     */
    public static void writeObject(String file, Object object) throws IOException {
        createFolders();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }

    /**
     * Writes an XML Document object into a file.
     *
     * @param document Parsed document created from the game log.
     * @throws TransformerException
     * @throws IOException Thrown if the directories cannot be created.
     */
    public static void writeXmlFile(final Document document, final String filename)
            throws TransformerException, IOException {
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
}
