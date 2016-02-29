package eu.janschupke.buddy.framework;

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
import eu.janschupke.buddy.content.ui.hud.StandardHud;
import eu.janschupke.buddy.framework.base.entity.Item;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.entity.WorldEntity;
import eu.janschupke.buddy.framework.base.entity.container.GameState;
import eu.janschupke.buddy.framework.base.event.GlobalEventHandler;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.table.RootTable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.SettingsManager;
import eu.janschupke.buddy.framework.config.enumeration.Huds;
import eu.janschupke.buddy.framework.config.enumeration.InputProcessors;
import eu.janschupke.buddy.framework.config.enumeration.Screens;
import eu.janschupke.buddy.framework.config.enumeration.WorldDebugRendering;
import eu.janschupke.buddy.framework.config.enumeration.interaction.InteractionTags;
import eu.janschupke.buddy.framework.input.BaseInputProcessor;
import eu.janschupke.buddy.framework.resources.ResourceManager;
import eu.janschupke.buddy.logging.GameLog;

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
    protected Skin skin;
    protected Stage ui;
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
     * TODO
     * @param tag
     * @return
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

        throw null;
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
            gameState.getEventLog().addObserver(getHud().getEventLogTable());
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
        // TODO: reset measuring model state.
        gameState = new GameState(this);
        huds = new HashMap<>();
        ui = new Stage();
        initHuds();
        screens = new HashMap<>();
        initScreens();
        configureObservers();
    }

    /**
     * Loads the persisted game state that has been previously serialized.
     *
     * @param app Deserialized game state from which to load.
     */
    public void loadState(App app) {
        // TODO: load measuring model state.
        gameState = app.getGameState();
        ui = app.getUi();
        screens = app.getScreens();
        huds = app.getHuds();
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
