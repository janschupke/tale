package io.schupke.tale.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.schupke.tale.base.App;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.ui.table.MenuTable;
import io.schupke.tale.content.config.Config;

/**
 * Adjusted menu, accessible from within any level.
 *
 * @author jan.schupke@gmail.com
 */
public class GameMenu extends MenuTable {
    private Label titleLabel;

    private TextButton resumeButton;
    private TextButton settingsButton;
    private TextButton hotkeysButton;
    private TextButton exitButton;
    private Label pathLabel;

    public GameMenu(final App app) {
        super(app);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.game.label.title"), app.getSkin());
        resumeButton = new TextButton(app.getLang().get("menu.game.button.resume"), app.getSkin());
        settingsButton = new TextButton(app.getLang().get("menu.game.button.settings"), app.getSkin());
        hotkeysButton = new TextButton(app.getLang().get("menu.game.button.hotkeys"), app.getSkin());
        exitButton = new TextButton(app.getLang().get("menu.game.button.exit"), app.getSkin());
        String path = app.getLang().get("menu.main.label.path") + "\n" + Config.FILE_PATH;
        pathLabel = new Label(path, app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(resumeButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(settingsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(hotkeysButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(exitButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(pathLabel).padTop(Config.UI_SEPARATOR_SPACE).row();
    }

    @Override
    public void setListeners() {
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                ((GameScreen) app.getScreen()).toggleMenu();
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

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().leaveLevel();
            }
        });
    }
}
