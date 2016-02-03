package eu.janschupke.buddy.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import eu.janschupke.buddy.Buddy;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.DefaultSettings;
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

	public static void main (String[] arg) {
		// Platform specific parsing for window resolution.
		PropertiesParser propertiesParser = new PropertiesParser();
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

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Buddy buddy = new Buddy();
		config.fullscreen = propertiesParser.isFullscreen();
		if (!propertiesParser.isFullscreen()) {
			config.width = propertiesParser.getWidth();
			config.height = propertiesParser.getHeight();
		}
		config.resizable = Config.SCREEN_RESIZABLE;
		config.foregroundFPS = DefaultSettings.FOREGROUND_FPS;
		config.backgroundFPS = DefaultSettings.BACKGROUND_FPS;
		config.title = Config.GAME_TITLE;
		config.addIcon("textures/gui/application-icon.png", Files.FileType.Internal);
		new LwjglApplication(buddy, config);
	}
}
