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
import eu.janschupke.buddy.GlobalEventHandler;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.BaseDialog;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.RootTable;
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
    protected Map<Config.Dialog, BaseDialog> dialogs;
    protected Skin skin;
    protected Stage ui;
    private I18NBundle lang;
    private SettingsManager settingsManager;
    private ResourceHandler resourceHandler;

    @Override
    public void create() {
        eventHandler = new GlobalEventHandler(this);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        huds = new HashMap<>();
        screens = new HashMap<>();
        inputProcessors = new HashMap<>();
        dialogs = new HashMap<>();

        // Logging configuration.
        Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_ERROR);
        if (Config.DEBUG_MODE) {
            Gdx.app.setLogLevel(com.badlogic.gdx.Application.LOG_DEBUG);
        }

        // Language bundle initialization.
        FileHandle baseFileHandle = Gdx.files.internal("languages/language");
        Locale locale = new Locale("en", "GB");
        lang = I18NBundle.createBundle(baseFileHandle, locale);

        // Preference configuration.
        settingsManager = new SettingsManager();
        resourceHandler = new ResourceHandler(this);

        // UI initialization.
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("skins/uiskin.atlas"));
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        skin.addRegions(atlas);
        ui = new Stage();
        initHuds();
        initInputProcessors();
        initScreens();
        initDialogs();
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

    /**
     * Various dialog instances, not exclusive to specific screens.
     */
    protected abstract void initDialogs();

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

    public BaseDialog getDialog(Config.Dialog name) {
        return dialogs.get(name);
    }

    /**
     * Re-opens all in-game dialogs that were supressed by the menu
     * and need to be shown again.
     */
    public void reopenDialogs() {
        for (Map.Entry<Config.Dialog, BaseDialog> entry : dialogs.entrySet()) {
            BaseDialog d = entry.getValue();
            if (d.isOpen()) {
                d.show(ui);
            }
        }
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
}
