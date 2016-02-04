package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.table.MenuTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Hotkey overview UI.
 */
public class HotkeysMenu extends MenuTable implements PreferenceMenu {
    private Label titleLabel;
    private Label invokeMenuLabel;
    private Label invokeMenuHotkey;
    private Label toggleMusicLabel;
    private Label toggleMusicHotkey;
    private Label toggleSoundLabel;
    private Label toggleSoundHotkey;
    private Label movementLabel;
    private Label movementHotkey;
    private Label interactLabel;
    private Label interactHotkey;
    private Label dialogLabel;
    private Label dialogsHotkey;
    private TextButton backButton;

    public HotkeysMenu(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
        configureWidgets();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.hotkeys.label.title"), app.getSkin());
        invokeMenuLabel = new Label(app.getLang().get("menu.hotkeys.label.menu.label"), app.getSkin());
        invokeMenuHotkey = new Label(app.getLang().get("menu.hotkeys.label.menu.hotkey"), app.getSkin());
        toggleMusicLabel = new Label(app.getLang().get("menu.hotkeys.label.music.label"), app.getSkin());
        toggleMusicHotkey = new Label(app.getLang().get("menu.hotkeys.label.music.hotkey"), app.getSkin());
        toggleSoundLabel = new Label(app.getLang().get("menu.hotkeys.label.sound.label"), app.getSkin());
        toggleSoundHotkey = new Label(app.getLang().get("menu.hotkeys.label.sound.hotkey"), app.getSkin());
        movementLabel = new Label(app.getLang().get("menu.hotkeys.label.movement.label"), app.getSkin());
        movementHotkey = new Label(app.getLang().get("menu.hotkeys.label.movement.hotkey"), app.getSkin());
        interactLabel = new Label(app.getLang().get("menu.hotkeys.label.interact.label"), app.getSkin());
        interactHotkey = new Label(app.getLang().get("menu.hotkeys.label.interact.hotkey"), app.getSkin());
        dialogLabel = new Label(app.getLang().get("menu.hotkeys.label.dialog.label"), app.getSkin());
        dialogsHotkey = new Label(app.getLang().get("menu.hotkeys.label.dialog.hotkey"), app.getSkin());
        backButton = new TextButton(app.getLang().get("menu.global.button.back"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).colspan(2).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(invokeMenuLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(invokeMenuHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(toggleMusicLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(toggleMusicHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();

        add(toggleSoundLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(toggleSoundHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(movementLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(movementHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(interactLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(interactHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(dialogLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING);
        add(dialogsHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        add(backButton).colspan(2).width(Config.UI_BUTTON_WIDTH).padTop(Config.UI_SEPARATOR_SPACE).padBottom(Config.UI_MENU_ITEM_PADDING).row();
    }

    @Override
    public void setListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showMainMenu();
            }
        });
    }

    @Override
    public void configureWidgets() {
        //
    }

    @Override
    public void updateRunningConfig() {
        //
    }

    @Override
    public void updateGameState() {
        //
    }

    @Override
    public void applyChanges() {
        updateRunningConfig();
        updateGameState();
        app.getSettingsManager().persist();
    }
}
