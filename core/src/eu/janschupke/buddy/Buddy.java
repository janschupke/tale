package eu.janschupke.buddy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import eu.janschupke.buddy.content.stage.level.forest.ForestInputProcessor;
import eu.janschupke.buddy.content.stage.level.forest.ForestScreen;
import eu.janschupke.buddy.content.stage.level.outskirts.OutskirtsInputProcessor;
import eu.janschupke.buddy.content.stage.menu.MenuScreen;
import eu.janschupke.buddy.content.stage.splash.SplashScreen;
import eu.janschupke.buddy.content.ui.dialog.CharacterDialog;
import eu.janschupke.buddy.content.ui.dialog.EventDialog;
import eu.janschupke.buddy.content.ui.dialog.InventoryDialog;
import eu.janschupke.buddy.content.ui.dialog.QuestDialog;
import eu.janschupke.buddy.content.ui.hud.StandardHud;
import eu.janschupke.buddy.content.ui.menu.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.input.GameInputProcessor;
import eu.janschupke.buddy.framework.input.GlobalInputProcessor;
import eu.janschupke.buddy.framework.input.PlatformInputProcessor;
import eu.janschupke.buddy.framework.input.TopDownInputProcessor;

/**
 * Main game entry point.
 */
public class Buddy extends App {
	@Override
	public void create () {
		super.create();
		Gdx.app.debug("Buddy#create", "Creating");

		// Cursor.
		Pixmap pm = new Pixmap(Gdx.files.internal("textures/gui/cursor.png"));
		Gdx.input.setCursorImage(pm, 0, 0);

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

		GameplayMenu gameplayMenu = new GameplayMenu(this);
		huds.put(Config.Huds.GAMEPLAYMENU, gameplayMenu);

		HotkeysMenu hotkeysMenu = new HotkeysMenu(this);
		huds.put(Config.Huds.HOTKEYSMENU, hotkeysMenu);

		CreditsMenu creditsMenu = new CreditsMenu(this);
		huds.put(Config.Huds.CREDITSMENU, creditsMenu);
	}

	@Override
	protected void initInputProcessors() {
		GlobalInputProcessor globalInputProcessor = new GlobalInputProcessor(this);
		inputProcessors.put(Config.Input.GLOBAL, globalInputProcessor);

		GameInputProcessor gameInputProcessor = new GameInputProcessor(this);
		inputProcessors.put(Config.Input.GAME, gameInputProcessor);

		PlatformInputProcessor platformInputProcessor = new PlatformInputProcessor(this);
		inputProcessors.put(Config.Input.PLATFORM, platformInputProcessor);

		TopDownInputProcessor topDownInputProcessor = new TopDownInputProcessor(this);
		inputProcessors.put(Config.Input.TOPDOWN, topDownInputProcessor);

		ForestInputProcessor forestInputProcessor = new ForestInputProcessor(this);
		inputProcessors.put(Config.Input.FOREST, forestInputProcessor);

		OutskirtsInputProcessor outskirtsInputProcessor = new OutskirtsInputProcessor(this);
		inputProcessors.put(Config.Input.OUTSKIRTS, outskirtsInputProcessor);
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

//		OutskirtsScreen outskirtsScreen = new OutskirtsScreen(this);
//		screens.put(Config.Screens.OUTSKIRTS, outskirtsScreen);
	}

	@Override
	protected void initDialogs() {
		InventoryDialog inventory = new InventoryDialog(this);
		dialogs.put(Config.Dialog.INVENTORY, inventory);

		CharacterDialog character = new CharacterDialog(this);
		dialogs.put(Config.Dialog.CHARACTER, character);

		QuestDialog quest = new QuestDialog(this);
		dialogs.put(Config.Dialog.QUEST, quest);

		EventDialog event = new EventDialog(this);
		dialogs.put(Config.Dialog.EVENT, event);
	}
}
