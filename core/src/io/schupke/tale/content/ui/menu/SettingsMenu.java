package io.schupke.tale.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.MenuTable;
import io.schupke.tale.content.config.Config;
import io.schupke.tale.content.ui.dialog.DefaultSettingDialog;

/**
 * Main settings menu UI.
 *
 * @author jan.schupke@gmail.com
 */
public class SettingsMenu extends MenuTable {
    private Label titleLabel;
    private TextButton graphicsButton;
    private TextButton audioButton;
    private TextButton restoreDefaults;
    private TextButton backButton;

    private DefaultSettingDialog defaultSettingsDialog;

    public SettingsMenu(final App app) {
        super(app);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.settings.main.label.title"), app.getSkin());
        graphicsButton = new TextButton(app.getLang().get("menu.settings.main.button.graphics"), app.getSkin());
        audioButton = new TextButton(app.getLang().get("menu.settings.main.button.audio"), app.getSkin());
        restoreDefaults = new TextButton(app.getLang().get("menu.settings.main.button.default"), app.getSkin());
        backButton = new TextButton(app.getLang().get("menu.global.button.back"), app.getSkin());

        defaultSettingsDialog = new DefaultSettingDialog(app);
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(graphicsButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(audioButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(restoreDefaults).width(Config.UI_BUTTON_WIDTH).padTop(Config.UI_SEPARATOR_SPACE).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(backButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_SEPARATOR_SPACE).row();
    }

    @Override
    public void setListeners() {
        graphicsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showGraphicsMenu();
            }
        });
        audioButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showAudioMenu();
            }
        });
        restoreDefaults.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                defaultSettingsDialog.show(app.getUi());
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showMainMenu();
            }
        });
    }
}
