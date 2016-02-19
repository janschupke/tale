package eu.janschupke.buddy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.buddy.content.stage.menu.MenuScreen;
import eu.janschupke.buddy.content.stage.splash.SplashScreen;
import eu.janschupke.buddy.content.ui.hud.StandardHud;
import eu.janschupke.buddy.content.ui.menu.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.input.GlobalInputProcessor;
import eu.janschupke.buddy.framework.input.PlatformInputProcessor;
import eu.janschupke.buddy.framework.input.TopDownInputProcessor;

/**
 * Main game entry point.
 * @author jan.schupke@gmail.com
 */
public class Buddy extends App {
	@Override
	public void create () {
		super.create();
		Gdx.app.debug("Buddy#create", "Creating");

		// Cursor setup.
		Pixmap pm = new Pixmap(Gdx.files.internal("textures/gui/application-cursor.png"));
		Gdx.input.setCursorImage(pm, 0, 0);

		// Entry screen - splash.
		this.setScreen(getScreenInstance(Config.Screens.SPLASH));
	}

	/**
	 * Initiates a collection of all available game HUDs and UIs.
	 */
	@Override
	protected void initHuds() {
		Gdx.app.debug("Buddy#initHuds", "HUDs");

		// Standard in-game overlay.
		StandardHud standardHud = new StandardHud(this);
		huds.put(Config.Huds.STANDARD, standardHud);

		// Main menu UI.
		MainMenu mainMenu = new MainMenu(this);
		huds.put(Config.Huds.MAINMENU, mainMenu);

		// In-game menu UI.
		GameMenu gameMenu = new GameMenu(this);
		huds.put(Config.Huds.GAMEMENU, gameMenu);

		SettingsMenu settingsMenu = new SettingsMenu(this);
		huds.put(Config.Huds.SETTINGSMENU, settingsMenu);

		GraphicsMenu graphicsMenu = new GraphicsMenu(this);
		huds.put(Config.Huds.GRAPHICSMENU, graphicsMenu);

		AudioMenu audioMenu = new AudioMenu(this);
		huds.put(Config.Huds.AUDIOMENU, audioMenu);

		HotkeysMenu hotkeysMenu = new HotkeysMenu(this);
		huds.put(Config.Huds.HOTKEYSMENU, hotkeysMenu);

		CreditsMenu creditsMenu = new CreditsMenu(this);
		huds.put(Config.Huds.CREDITSMENU, creditsMenu);
	}

	@Override
	protected void initInputProcessors() {
		GlobalInputProcessor globalInputProcessor = new GlobalInputProcessor(this);
		inputProcessors.put(Config.Input.GLOBAL, globalInputProcessor);

		PlatformInputProcessor platformInputProcessor = new PlatformInputProcessor(this);
		inputProcessors.put(Config.Input.PLATFORM, platformInputProcessor);

		TopDownInputProcessor topDownInputProcessor = new TopDownInputProcessor(this);
		inputProcessors.put(Config.Input.TOPDOWN, topDownInputProcessor);
	}

	@Override
	protected void initScreens() {
		Gdx.app.debug("Buddy#initScreens", "Screens");

		SplashScreen splashScreen = new SplashScreen(this);
		screens.put(Config.Screens.SPLASH, splashScreen);

		MenuScreen menuScreen = new MenuScreen(this);
		screens.put(Config.Screens.MENU, menuScreen);

		ForestScreen forestScreen = new ForestScreen(this);
		screens.put(Config.Screens.FOREST, forestScreen);

		OutskirtsScreen outskirtsScreen = new OutskirtsScreen(this);
		screens.put(Config.Screens.OUTSKIRTS, outskirtsScreen);
	}
}
