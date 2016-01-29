package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.UITable;

/**
 * Gameplay settings UI.
 */
public class GameplayMenu extends UITable implements PreferenceMenu {
    private Label titleLabel;
    private CheckBox showHintsCheckbox;
    private TextButton cancelButton;
    private TextButton applyButton;

    public GameplayMenu(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
        configureWidgets();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.settings.gameplay.label.title"), app.getSkin());
        showHintsCheckbox = new CheckBox(app.getLang().get("menu.settings.gameplay.checkbox.show-hints"), app.getSkin());
        cancelButton = new TextButton(app.getLang().get("menu.global.button.cancel"), app.getSkin());
        applyButton = new TextButton(app.getLang().get("menu.global.button.apply"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).colspan(2).padBottom(separatorSpace).row();
        add(showHintsCheckbox).colspan(2).padBottom(menuItemPadding).row();
        add(cancelButton).width(smallButtonWidth).left().padBottom(menuItemPadding).padTop(separatorSpace);
        add(applyButton).width(smallButtonWidth).right().padBottom(menuItemPadding).padTop(separatorSpace).row();
    }

    @Override
    public void setListeners() {
        showHintsCheckbox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuCheckboxSounds());
            }
        });
        cancelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showSettings();
            }
        });
        applyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                applyChanges();
                app.getEventHandler().showSettings();
            }
        });
    }

    @Override
    public void configureWidgets() {
        showHintsCheckbox.setChecked(app.getSettingsManager().getConfig().isShowHints());
    }

    @Override
    public void updateRunningConfig() {
        app.getSettingsManager().getConfig().setShowHints(showHintsCheckbox.isChecked());
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
