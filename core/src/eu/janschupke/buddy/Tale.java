package eu.janschupke.buddy;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.content.config.enumeration.Huds;
import eu.janschupke.buddy.content.config.enumeration.Screens;
import eu.janschupke.buddy.content.stage.level.cave.CaveScreen;
import eu.janschupke.buddy.content.stage.level.dungeon.DungeonScreen;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.house.HouseScreen;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.buddy.content.stage.level.settlement.SettlementScreen;
import eu.janschupke.buddy.content.stage.menu.MenuScreen;
import eu.janschupke.buddy.content.stage.splash.SplashScreen;
import eu.janschupke.buddy.content.ui.hud.StandardHud;
import eu.janschupke.buddy.content.ui.menu.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;
import eu.janschupke.buddy.framework.input.GlobalInputProcessor;
import eu.janschupke.buddy.framework.input.PlatformInputProcessor;
import eu.janschupke.buddy.framework.input.TopDownInputProcessor;

/**
 * Main game entry point.
 * @author jan.schupke@gmail.com
 */
public class Tale extends App {
	@Override
	public void create () {
		super.create();
		Gdx.app.debug("Buddy#create", "Creating");

		// Cursor setup.
		Gdx.input.setCursorImage(getResourceManager().getTextureHandler().getGameCursorPixmap(), 0, 0);

		// Entry screen - splash.
		this.setScreen(getScreenInstance(Screens.SPLASH));
	}

	/**
	 * Initiates a collection of all available game HUDs and UIs.
	 */
	@Override
	protected void initHuds() {
		Gdx.app.debug("Buddy#initHuds", "HUDs");

		// Standard in-game overlay.
		StandardHud standardHud = new StandardHud(this);
		huds.put(Huds.STANDARD, standardHud);

		// Main menu UI.
		MainMenu mainMenu = new MainMenu(this);
		huds.put(Huds.MAINMENU, mainMenu);

		// In-game menu UI.
		GameMenu gameMenu = new GameMenu(this);
		huds.put(Huds.GAMEMENU, gameMenu);

		SettingsMenu settingsMenu = new SettingsMenu(this);
		huds.put(Huds.SETTINGSMENU, settingsMenu);

		GraphicsMenu graphicsMenu = new GraphicsMenu(this);
		huds.put(Huds.GRAPHICSMENU, graphicsMenu);

		AudioMenu audioMenu = new AudioMenu(this);
		huds.put(Huds.AUDIOMENU, audioMenu);

		HotkeysMenu hotkeysMenu = new HotkeysMenu(this);
		huds.put(Huds.HOTKEYSMENU, hotkeysMenu);

		CreditsMenu creditsMenu = new CreditsMenu(this);
		huds.put(Huds.CREDITSMENU, creditsMenu);
	}

	@Override
	protected void initInputProcessors() {
		GlobalInputProcessor globalInputProcessor = new GlobalInputProcessor(this);
		inputProcessors.put(InputProcessors.GLOBAL, globalInputProcessor);

		PlatformInputProcessor platformInputProcessor = new PlatformInputProcessor(this);
		inputProcessors.put(InputProcessors.PLATFORM, platformInputProcessor);

		TopDownInputProcessor topDownInputProcessor = new TopDownInputProcessor(this);
		inputProcessors.put(InputProcessors.TOPDOWN, topDownInputProcessor);
	}

	@Override
	protected void initScreens() {
		Gdx.app.debug("Buddy#initScreens", "Screens");

		SplashScreen splashScreen = new SplashScreen(this);
		screens.put(Screens.SPLASH, splashScreen);

		MenuScreen menuScreen = new MenuScreen(this);
		screens.put(Screens.MENU, menuScreen);

		ForestScreen forestScreen = new ForestScreen(this);
		screens.put(Screens.FOREST, forestScreen);

		OutskirtsScreen outskirtsScreen = new OutskirtsScreen(this);
		screens.put(Screens.OUTSKIRTS, outskirtsScreen);

		CaveScreen caveScreen = new CaveScreen(this);
		screens.put(Screens.CAVE, caveScreen);

		SettlementScreen settlementScreen = new SettlementScreen(this);
		screens.put(Screens.SETTLEMENT, settlementScreen);

		HouseScreen houseScreen = new HouseScreen(this);
		screens.put(Screens.HOUSE, houseScreen);

		DungeonScreen dungeonScreen = new DungeonScreen(this);
		screens.put(Screens.DUNGEON, dungeonScreen);
	}
}
