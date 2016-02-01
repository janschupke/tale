package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.content.ui.dialog.DefaultSettingDialog;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.MenuTable;

/**
 * Main settings menu UI.
 */
public class SettingsMenu extends MenuTable {
    private Label titleLabel;
    private TextButton graphicsButton;
    private TextButton audioButton;
    private TextButton gameplayButton;
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
        gameplayButton = new TextButton(app.getLang().get("menu.settings.main.button.gameplay"), app.getSkin());
        restoreDefaults = new TextButton(app.getLang().get("menu.settings.main.button.default"), app.getSkin());
        backButton = new TextButton(app.getLang().get("menu.global.button.back"), app.getSkin());

        defaultSettingsDialog = new DefaultSettingDialog(app);
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(separatorSpace).row();
        add(graphicsButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(audioButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(gameplayButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(restoreDefaults).width(buttonWidth).padTop(separatorSpace).padBottom(separatorSpace).row();
        add(backButton).width(buttonWidth).padBottom(separatorSpace).row();
    }

    @Override
    public void setListeners() {
        graphicsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showGraphicsMenu();
            }
        });
        audioButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showAudioMenu();
            }
        });
        gameplayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showGameplayMenu();
            }
        });
        restoreDefaults.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                defaultSettingsDialog.show(app.getUi());
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showMainMenu();
            }
        });
    }
}
