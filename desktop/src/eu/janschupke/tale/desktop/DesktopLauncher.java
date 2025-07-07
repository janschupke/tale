package eu.janschupke.tale.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import eu.janschupke.tale.Tale;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.DefaultSettings;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Launcher class for desktop platform.
 * Other platforms are not supported for this application,
 * making this class the single entry point.
 */
public class DesktopLauncher {
	private final static Logger logger = Logger.getLogger(DesktopLauncher.class.getName());

	/**
	 * Attempts to parse window dimensions from configuration
	 * before the window itself is created.
	 * @param propertiesParser XML parses instance responsible for the configuration reading.
	 */
	private static void parseWindowConfig(PropertiesParser propertiesParser) {
		try {
			String path = System.getProperty("user.home") + System.getProperty("file.separator") + ".prefs";
			String filename = Config.GAME_PREFIX + "-" + Config.PREFERENCES_SETTINGS;
			propertiesParser.parse(path + System.getProperty("file.separator") + filename);
		} catch (ParserConfigurationException e) {
			logger.log(Level.WARNING, "DesktopLauncher#main - ParserConfigurationException: " + e.getMessage());
		} catch (IOException e) {
			logger.log(Level.WARNING, "DesktopLauncher#main - IOException: " + e.getMessage());
		} catch (SAXException e) {
			logger.log(Level.WARNING, "DesktopLauncher#main - SAXException: " + e.getMessage());
		} catch (NumberFormatException e) {
			logger.log(Level.WARNING, "DesktopLauncher#main - NumberFormatException: " + e.getMessage());
		}
	}

	public static void main (String[] args) {
		// Platform specific parsing for window resolution.
		PropertiesParser propertiesParser = new PropertiesParser();
		parseWindowConfig(propertiesParser);

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		Tale tale = new Tale();
		
		config.setFullscreenMode(propertiesParser.isFullscreen() ? 
			Lwjgl3ApplicationConfiguration.getDisplayMode() : null);
		
		if (!propertiesParser.isFullscreen()) {
			config.setWindowedMode(propertiesParser.getWidth(), propertiesParser.getHeight());
		}
		
		config.setResizable(Config.SCREEN_RESIZABLE);
		config.setForegroundFPS(DefaultSettings.FOREGROUND_FPS);
		config.setIdleFPS(DefaultSettings.BACKGROUND_FPS);
		config.setTitle(Config.GAME_TITLE);
		config.setWindowIcon("textures/gui/application-icon.png");
		
		new Lwjgl3Application(tale, config);
	}
}
