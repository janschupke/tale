package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.table.MenuTable;

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
        add(titleLabel).colspan(2).padBottom(separatorSpace).row();
        add(invokeMenuLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(invokeMenuHotkey).left().padBottom(menuItemPadding).row();
        add(toggleMusicLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(toggleMusicHotkey).left().padBottom(menuItemPadding).row();

        add(toggleSoundLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(toggleSoundHotkey).left().padBottom(menuItemPadding).row();
        add(movementLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(movementHotkey).left().padBottom(menuItemPadding).row();
        add(interactLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(interactHotkey).left().padBottom(menuItemPadding).row();
        add(dialogLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(dialogsHotkey).left().padBottom(menuItemPadding).row();
        add(backButton).colspan(2).width(buttonWidth).padTop(separatorSpace).padBottom(menuItemPadding).row();
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
