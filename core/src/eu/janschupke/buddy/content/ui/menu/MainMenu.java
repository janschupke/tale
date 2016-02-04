package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.table.MenuTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Main menu UI layout.
 */
public class MainMenu extends MenuTable {
    private Label titleLabel;
    private TextButton newGameButton;
    private TextButton continueGameButton;
    private TextButton settingsButton;
    private TextButton hotkeysButton;
    private TextButton creditsButton;
    private TextButton exitButton;

    public MainMenu(final App app) {
        super(app);

        Gdx.app.debug("MainMenu#<init>", "Constructing");

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.main.label.title"), app.getSkin());
        newGameButton = new TextButton(app.getLang().get("menu.main.button.new-game"), app.getSkin());
        continueGameButton = new TextButton(app.getLang().get("menu.main.button.continue-game"), app.getSkin());
        settingsButton = new TextButton(app.getLang().get("menu.main.button.settings"), app.getSkin());
        hotkeysButton = new TextButton(app.getLang().get("menu.main.button.hotkeys"), app.getSkin());
        creditsButton = new TextButton(app.getLang().get("menu.main.button.credits"), app.getSkin());
        exitButton = new TextButton(app.getLang().get("menu.main.button.exit"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(newGameButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(continueGameButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(settingsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(hotkeysButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(creditsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(exitButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
    }

    @Override
    public void setListeners() {
        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().startNewGame();
            }
        });

        continueGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().continueGame();
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showSettings();
            }
        });

        hotkeysButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showHotkeys();
            }
        });

        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showCredits();
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().exitGame();
            }
        });
    }
}
