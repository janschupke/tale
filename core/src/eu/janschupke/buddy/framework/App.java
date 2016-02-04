package eu.janschupke.buddy.framework;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import eu.janschupke.buddy.framework.base.entity.container.CharacterContainer;
import eu.janschupke.buddy.framework.base.event.GlobalEventHandler;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.table.RootTable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.config.SettingsManager;
import eu.janschupke.buddy.framework.input.BaseInputProcessor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Extension of the base Game class, with some additional boilerplate.
 */
public abstract class App extends Game {
    private GlobalEventHandler eventHandler;
    private SpriteBatch batch;
    private BitmapFont font;
    protected Map<Config.Huds, RootTable> huds;
    protected Map<Config.Screens, BaseScreen> screens;
    protected Map<Config.Input, BaseInputProcessor> inputProcessors;
    protected Skin skin;
    protected Stage ui;
    private I18NBundle lang;
    private SettingsManager settingsManager;
    private ResourceHandler resourceHandler;
    private CharacterContainer character;

    @Override
    public void create() {
        // Language bundle initialization.
        FileHandle baseFileHandle = Gdx.files.internal("languages/language");
        Locale locale = new Locale("en", "GB");
        lang = I18NBundle.createBundle(baseFileHandle, locale);

        eventHandler = new GlobalEventHandler(this);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        huds = new HashMap<>();
        screens = new HashMap<>();
        inputProcessors = new HashMap<>();

        // Logging configuration.
        Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_ERROR);
        if (Config.DEBUG_MODE) {
            Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_DEBUG);
        }

        // Preference configuration.
        settingsManager = new SettingsManager();
        resourceHandler = new ResourceHandler(this);

        // UI initialization.
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas"));
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);
        ui = new Stage();

        character = new CharacterContainer(this);

        initHuds();
        initInputProcessors();
        initScreens();
    }

    @Override
    public void setScreen(Screen screen) {
        Gdx.app.debug("App#setScreen", "Settings");
        super.setScreen(screen);
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

    public Map<Config.Huds, RootTable> getHuds() {
        return huds;
    }

    public RootTable getHud(Config.Huds name) {
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

    public BaseScreen getScreenInstance(Config.Screens name) {
        return screens.get(name);
    }

    public BaseInputProcessor getInputProcessor(Config.Input name) {
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
        resourceHandler.dispose();
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

    public ResourceHandler getResourceHandler() {
        return resourceHandler;
    }

    public CharacterContainer getCharacter() {
        return character;
    }
}
