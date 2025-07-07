package eu.janschupke.tale.content.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.ui.table.MenuTable;
import eu.janschupke.tale.content.config.Config;

/**
 * Main menu UI layout.
 *
 * @author jan.schupke@gmail.com
 */
public class MainMenu extends MenuTable {
    private Label titleLabel;
    private TextButton continueGameButton;
    private TextButton newGameButton;
    private TextButton settingsButton;
    private TextButton hotkeysButton;
    private TextButton creditsButton;
    private TextButton exitButton;
    private Label pathLabel;

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
        continueGameButton = new TextButton(app.getLang().get("menu.main.button.continue-game"), app.getSkin());
        newGameButton = new TextButton(app.getLang().get("menu.main.button.new-game"), app.getSkin());
        settingsButton = new TextButton(app.getLang().get("menu.main.button.settings"), app.getSkin());
        hotkeysButton = new TextButton(app.getLang().get("menu.main.button.hotkeys"), app.getSkin());
        creditsButton = new TextButton(app.getLang().get("menu.main.button.credits"), app.getSkin());
        exitButton = new TextButton(app.getLang().get("menu.main.button.exit"), app.getSkin());
        String path = app.getLang().get("menu.main.label.path") + "\n" + Config.FILE_PATH;
        pathLabel = new Label(path, app.getSkin());
    }

    @Override
    public void addWidgets() {
        boolean canContinue = (app.getGameState().getCurrentLevel() != null);
        setupWidgets(canContinue);
    }

    public void setupWidgets(boolean canContinue) {
        clear();
        add(titleLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        if (canContinue) {
            add(continueGameButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        }
        add(newGameButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(settingsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(hotkeysButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(creditsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(exitButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(pathLabel).padTop(Config.UI_SEPARATOR_SPACE).row();
    }

    @Override
    public void setListeners() {
        continueGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().continueGame();
            }
        });

        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().startNewGame();
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showSettings();
            }
        });

        hotkeysButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showHotkeys();
            }
        });

        creditsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showCredits();
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().exitGame();
            }
        });
    }
}
