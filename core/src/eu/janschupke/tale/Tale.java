package eu.janschupke.tale;

import com.badlogic.gdx.Gdx;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.config.enumeration.InputProcessors;
import eu.janschupke.tale.base.input.GlobalInputProcessor;
import eu.janschupke.tale.base.input.PlatformInputProcessor;
import eu.janschupke.tale.base.input.TopDownInputProcessor;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.stage.level.cave.CaveScreen;
import eu.janschupke.tale.content.stage.level.dungeon.DungeonScreen;
import eu.janschupke.tale.content.stage.level.forest.ForestScreen;
import eu.janschupke.tale.content.stage.level.outskirts.OutskirtsScreen;
import eu.janschupke.tale.content.stage.level.settlement.SettlementScreen;
import eu.janschupke.tale.content.stage.menu.MenuScreen;
import eu.janschupke.tale.content.stage.outro.OutroScreen;
import eu.janschupke.tale.content.stage.splash.SplashScreen;
import eu.janschupke.tale.content.ui.hud.OutroHud;
import eu.janschupke.tale.content.ui.hud.main.StandardHud;
import eu.janschupke.tale.content.ui.menu.AudioMenu;
import eu.janschupke.tale.content.ui.menu.CreditsMenu;
import eu.janschupke.tale.content.ui.menu.GameMenu;
import eu.janschupke.tale.content.ui.menu.GraphicsMenu;
import eu.janschupke.tale.content.ui.menu.HotkeysMenu;
import eu.janschupke.tale.content.ui.menu.MainMenu;
import eu.janschupke.tale.content.ui.menu.SettingsMenu;

/**
 * Main game entry point.
 */
public class Tale extends App {
	@Override
	public void create () {
		super.create();
		Gdx.app.debug("Tale#create", "Creating");

		// Entry screen - splash.
		this.setScreen(getScreenInstance(Screens.SPLASH));
	}

	/**
	 * Initiates a collection of all available game HUDs and UIs.
	 */
	@Override
	protected void initHuds() {
		Gdx.app.debug("Tale#initHuds", "HUDs");

		// Standard in-game overlay.
		StandardHud standardHud = new StandardHud(this);
		huds.put(Huds.STANDARD, standardHud);

		// Outro text and exit button.
		OutroHud outroHud = new OutroHud(this);
		huds.put(Huds.OUTRO, outroHud);

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
		Gdx.app.debug("Tale#initScreens", "Screens");

		SplashScreen splashScreen = new SplashScreen(this);
		screens.put(Screens.SPLASH, splashScreen);

		MenuScreen menuScreen = new MenuScreen(this);
		screens.put(Screens.MENU, menuScreen);

		OutroScreen outroScreen = new OutroScreen(this);
		screens.put(Screens.OUTRO, outroScreen);

		ForestScreen forestScreen = new ForestScreen(this);
		screens.put(Screens.FOREST, forestScreen);

		OutskirtsScreen outskirtsScreen = new OutskirtsScreen(this);
		screens.put(Screens.OUTSKIRTS, outskirtsScreen);

		CaveScreen caveScreen = new CaveScreen(this);
		screens.put(Screens.CAVE, caveScreen);

		SettlementScreen settlementScreen = new SettlementScreen(this);
		screens.put(Screens.SETTLEMENT, settlementScreen);

		DungeonScreen dungeonScreen = new DungeonScreen(this);
		screens.put(Screens.DUNGEON, dungeonScreen);
	}
}
