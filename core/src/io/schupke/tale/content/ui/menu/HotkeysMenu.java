package io.schupke.tale.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.MenuTable;
import io.schupke.tale.content.config.Config;

/**
 * Hotkey overview UI.
 *
 * @author jan.schupke@gmail.com
 */
public class HotkeysMenu extends MenuTable {
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
    private Label messagesLabel;
    private Label messagesHotkey;
    private Label questsLabel;
    private Label questsHotkey;
    private Label inventoryLabel;
    private Label inventoryHotkey;
    private TextButton backButton;

    public HotkeysMenu(final App app) {
        super(app);
        initWidgets();
        addWidgets();
        setListeners();
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
        messagesLabel = new Label(app.getLang().get("menu.hotkeys.label.messages.label"), app.getSkin());
        messagesHotkey = new Label(app.getLang().get("menu.hotkeys.label.messages.hotkey"), app.getSkin());
        questsLabel = new Label(app.getLang().get("menu.hotkeys.label.quests.label"), app.getSkin());
        questsHotkey = new Label(app.getLang().get("menu.hotkeys.label.quests.hotkey"), app.getSkin());
        inventoryLabel = new Label(app.getLang().get("menu.hotkeys.label.inventory.label"), app.getSkin());
        inventoryHotkey = new Label(app.getLang().get("menu.hotkeys.label.inventory.hotkey"), app.getSkin());
        backButton = new TextButton(app.getLang().get("menu.global.button.back"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).colspan(2).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(invokeMenuLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(invokeMenuHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(toggleMusicLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(toggleMusicHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();

        add(toggleSoundLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(toggleSoundHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(movementLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(movementHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(interactLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(interactHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(dialogLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(dialogsHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(messagesLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(messagesHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(questsLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(questsHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(inventoryLabel).right().padRight(Config.UI_MENU_ITEM_PADDING).padBottom(Config.UI_MENU_ITEM_PADDING_DIM);
        add(inventoryHotkey).left().padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
        add(backButton).colspan(2).width(Config.UI_BUTTON_WIDTH).padTop(Config.UI_SEPARATOR_SPACE)
                .padBottom(Config.UI_MENU_ITEM_PADDING_DIM).row();
    }

    @Override
    public void setListeners() {
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
