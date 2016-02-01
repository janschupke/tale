package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.MenuTable;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;

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
    private Label mapLabel;
    private Label mapHotkey;
    private Label inventoryLabel;
    private Label inventoryHotkey;
    private Label characterLabel;
    private Label characterHotkey;
    private Label eventLogLabel;
    private Label eventLogHotkey;
    private Label questLogLabel;
    private Label questLogHotkey;
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
        mapLabel = new Label(app.getLang().get("menu.hotkeys.label.map.label"), app.getSkin());
        mapHotkey = new Label(app.getLang().get("menu.hotkeys.label.map.hotkey"), app.getSkin());
        inventoryLabel = new Label(app.getLang().get("menu.hotkeys.label.inventory.label"), app.getSkin());
        inventoryHotkey = new Label(app.getLang().get("menu.hotkeys.label.inventory.hotkey"), app.getSkin());
        characterLabel = new Label(app.getLang().get("menu.hotkeys.label.character.label"), app.getSkin());
        characterHotkey = new Label(app.getLang().get("menu.hotkeys.label.character.hotkey"), app.getSkin());
        eventLogLabel = new Label(app.getLang().get("menu.hotkeys.label.event-log.label"), app.getSkin());
        eventLogHotkey = new Label(app.getLang().get("menu.hotkeys.label.event-log.hotkey"), app.getSkin());
        questLogLabel = new Label(app.getLang().get("menu.hotkeys.label.quest-log.label"), app.getSkin());
        questLogHotkey = new Label(app.getLang().get("menu.hotkeys.label.quest-log.hotkey"), app.getSkin());
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
        add(mapLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(mapHotkey).left().padBottom(menuItemPadding).row();
        add(inventoryLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(inventoryHotkey).left().padBottom(menuItemPadding).row();
        add(characterLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(characterHotkey).left().padBottom(menuItemPadding).row();
        add(eventLogLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(eventLogHotkey).left().padBottom(menuItemPadding).row();
        add(questLogLabel).right().padRight(menuItemPadding).padBottom(menuItemPadding);
        add(questLogHotkey).left().padBottom(menuItemPadding).row();
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
