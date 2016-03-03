package eu.janschupke.tale.framework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.SettingsManager;
import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.content.config.enumeration.tags.InteractionTags;
import eu.janschupke.tale.content.ui.hud.StandardHud;
import eu.janschupke.tale.framework.config.enumeration.InputProcessors;
import eu.janschupke.tale.framework.config.enumeration.WorldDebugRendering;
import eu.janschupke.tale.framework.container.GameState;
import eu.janschupke.tale.framework.entity.Item;
import eu.janschupke.tale.framework.entity.Triggerable;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.entity.WorldEntity;
import eu.janschupke.tale.framework.event.handling.GlobalEventHandler;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.input.BaseInputProcessor;
import eu.janschupke.tale.framework.interaction.Interaction;
import eu.janschupke.tale.framework.resource.ResourceManager;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.ui.PreferenceMenu;
import eu.janschupke.tale.framework.ui.table.RootTable;
import eu.janschupke.tale.logging.GameLog;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Extension of the base Game class, with some additional boilerplate.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class App extends Game {
    protected Map<Huds, RootTable> huds;
    protected Map<Screens, BaseScreen> screens;
    protected Map<InputProcessors, BaseInputProcessor> inputProcessors;
    private Skin skin;
    private Stage ui;
    private GlobalEventHandler eventHandler;
    private SpriteBatch batch;
    private BitmapFont font;
    private I18NBundle lang;
    private SettingsManager settingsManager;
    private ResourceManager resourceManager;
    private GameState gameState;
    private GameLog gameLog;

    @Override
    public void create() {
        // Language bundle initialization.
        FileHandle baseFileHandle = Gdx.files.internal("languages/language");
        Locale locale = new Locale("en", "GB");
        lang = I18NBundle.createBundle(baseFileHandle, locale);

        eventHandler = new GlobalEventHandler(this);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        inputProcessors = new HashMap<>();

        // Logging configuration.
        Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_ERROR);
        if (Config.DEBUG_MODE) {
            Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_DEBUG);
        }

        toggleStartupDebugRendering();

        // Preference configuration.
        settingsManager = new SettingsManager();
        resourceManager = new ResourceManager(this);

        // UI initialization.
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas"));
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);

        initInputProcessors();
        resetState();

        gameLog = new GameLog();
    }

    /**
     * Searches through all game's instantiated interactions for the one
     * with provided tag.
     * @param tag Tag of the requested interaction.
     * @return Interaction with provided tag, or null, if not found.
     */
    public Interaction getInteraction(InteractionTags tag) {
        for (Map.Entry entry : screens.entrySet()) {
            if (!(entry.getValue() instanceof GameScreen)) {
                continue;
            }

            GameScreen screen = (GameScreen) entry.getValue();

            for (Item item : screen.getWorld().getItems()) {
                if (item instanceof Triggerable && ((Triggerable) item).getInteraction().getTag().equals(tag)) {
                    return ((Triggerable) item).getInteraction();
                }
            }

            for (Unit unit : screen.getWorld().getUnits()) {
                if (unit instanceof Triggerable && ((Triggerable) unit).getInteraction().getTag().equals(tag)) {
                    return ((Triggerable) unit).getInteraction();
                }
            }

            for (WorldEntity obstacle : screen.getWorld().getObstacles()) {
                if (obstacle instanceof Triggerable && ((Triggerable) obstacle).getInteraction().getTag().equals(tag)) {
                    return ((Triggerable) obstacle).getInteraction();
                }
            }
        }

        return null;
    }

    /**
     * Retrieves the in-game hud instance.
     *
     * @return In-game hud instance.
     */
    public StandardHud getHud() throws NoHudException {
        Actor actor = ui.getActors().get(0);
        if (!(actor instanceof StandardHud)) {
            throw new NoHudException();
        }
        return ((StandardHud) actor);
    }

    /**
     * Ties together all observable objects and their observers.
     */
    private void configureObservers() {
        try {
            gameState.getMessageLog().addObserver(getHud().getMessageLogTable());
            gameState.getInventory().addObserver(getHud().getInventoryTable());
            gameState.getQuestLog().addObserver(getHud().getQuestLogTable());
            gameState.getGlobalLevelState().addObserver(getHud().getIndicatorTable());
            gameState.getGlobalLevelState().addObserver(getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.debug("EventLogTable#setListeners", "Could not get HUD instance");
        }
    }

    /**
     * Resets the current game state in order to start a new one.
     */
    public void resetState() {
        gameLog.clear();
        gameState = new GameState(this);
        huds = new HashMap<>();
        ui = new Stage();
        initHuds();
        screens = new HashMap<>();
        initScreens();
        configureObservers();
    }

    /**
     * Disables debug rendering in case of enabled values in configuration,
     * but disabled on the application level.
     */
    private void toggleStartupDebugRendering() {
        if (!Config.DEBUG_MODE) {
            settingsManager.getConfig().setUiDebugRendering(false);
            settingsManager.getConfig().setWorldDebugRendering(WorldDebugRendering.GRAPHICS);
        }
    }

    @Override
    public void setScreen(Screen screen) {
        Gdx.app.debug("App#setScreen", "Settings");
        super.setScreen(screen);
        // For game state saving purposes.
        if (screen instanceof GameScreen) {
            gameState.setCurrentLevel((GameScreen) screen);
        }
    }

    /**
     * Initiates the instances of all available HUDs.
     */
    protected abstract void initHuds();

    /**
     * Initiates the instances of all available input processors.
     */
    protected abstract void initInputProcessors();

    /**
     * Initiates the instances of all available screens.
     */
    protected abstract void initScreens();

    public Map<Huds, RootTable> getHuds() {
        return huds;
    }

    public RootTable getHud(Huds name) {
        return huds.get(name);
    }

    public void swapHuds(RootTable hud) {
        ui.clear();

        // Update configurable widgets with the most current values.
        if (hud instanceof PreferenceMenu) {
            ((PreferenceMenu) hud).configureWidgets();
        }

        ui.addActor(hud);
    }

    public Map<Screens, BaseScreen> getScreens() {
        return screens;
    }

    public BaseScreen getScreenInstance(Screens name) {
        return screens.get(name);
    }

    public BaseInputProcessor getInputProcessor(InputProcessors name) {
        return inputProcessors.get(name);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        skin.dispose();
        ui.dispose();
        resourceManager.dispose();
    }

    public SpriteBatch getBatch() {
        return this.batch;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public Skin getSkin() {
        return skin;
    }

    public Stage getUi() {
        return ui;
    }

    public I18NBundle getLang() {
        return lang;
    }

    public GlobalEventHandler getEventHandler() {
        return eventHandler;
    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public GameState getGameState() {
        return gameState;
    }

    public GameLog getGameLog() {
        return gameLog;
    }
}
