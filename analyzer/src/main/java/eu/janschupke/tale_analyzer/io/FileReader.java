package eu.janschupke.tale_analyzer.io;

import eu.janschupke.tale_analyzer.exception.InvalidDataSetException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all file reading that is needed across the application.
 *
 * @author jan.schupke@gmail.com
 */
public class FileReader {
    /**
     * Object deserialization.
     *
     * @param file The file to be read from.
     * @return Data structure that was loaded, or null in case of failure.
     * @throws IOException
     */
    public static Object readObject(String file) throws IOException {
        Object object = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            ois.close();
        } catch (Exception e) {
            FileWriter.writeObject(file, null);
        }

        return object;
    }

    /**
     * Reads an XML document and returns its parsed object.
     *
     * @param filename Name of the XML file.
     * @return Parsed XML Document instance.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws NumberFormatException
     */
    public static Document readXmlDocument(String filename) throws ParserConfigurationException,
            IOException, SAXException, NumberFormatException {
        File fXmlFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder.parse(fXmlFile);
    }

    /**
     * Reads a plaintext file.
     *
     * @return Contents of the text file.
     * @throws IOException
     */
    public static String readTextFile(String path) throws IOException {
        String content = "";
        File file = new File(path);

        String inputLine;
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedReader dis = new BufferedReader(new InputStreamReader(bis));

        // Reads lines.
        while ((inputLine = dis.readLine()) != null) {
            content += inputLine + System.getProperty("line.separator");
        }

        // Disposes of all the resources after using them.
        fis.close();
        bis.close();
        dis.close();

        return content;
    }

    /**
     * Reads directory on the provided path and returns all files within.
     * Subfolders are not considered.
     *
     * @param path Path to the requested directory.
     * @param files If true, files are searched and returned.
     *              If false, directories are searched and returned.
     * @return List of all files within the directory.
     */
    public static List<File> readDirectory(String path, boolean files) throws InvalidDataSetException {
        List<File> result = new ArrayList<>();
        File directory = new File(path);

        if (!directory.isDirectory()) {
            throw new InvalidDataSetException();
        }

        File[] directoryContent = directory.listFiles();

        for (File file : directoryContent) {
            // Add file.
            if (files && file.isFile()) {
                result.add(file);
            }

            // Add directory.
            if (!files && file.isDirectory()) {
                result.add(file);
            }
        }

        return result;
    }
}
