package eu.janschupke.tale.content.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.ui.PreferenceMenu;
import eu.janschupke.tale.base.ui.table.MenuTable;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.ui.dialog.RestartDialog;

/**
 * Graphics settings UI.
 *
 * @author jan.schupke@gmail.com
 */
public class GraphicsMenu extends MenuTable implements PreferenceMenu {
    private final String[] resolutions = Config.AVAILABLE_RESOLUTIONS;
    private final int[] screenWidths = Config.AVAILABLE_WIDTHS;
    private final int[] screenHeights = Config.AVAILABLE_HEIGHTS;
    private Label titleLabel;
    private Label resolutionLabel;
    private SelectBox<String> resolutionCombo;
    private CheckBox fullscreenCheckbox;
    private TextButton cancelButton;
    private TextButton applyButton;

    private RestartDialog restartDialog;

    public GraphicsMenu(final App app) {
        super(app);
        initWidgets();
        addWidgets();
        setListeners();
        configureWidgets();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.settings.graphics.label.title"), app.getSkin());
        resolutionLabel = new Label(app.getLang().get("menu.settings.graphics.label.resolution"), app.getSkin());
        resolutionCombo = new SelectBox<>(app.getSkin());
        resolutionCombo.setItems(resolutions);
        fullscreenCheckbox = new CheckBox(app.getLang().get("menu.settings.graphics.label.fullscreen"), app.getSkin());
        cancelButton = new TextButton(app.getLang().get("menu.global.button.cancel"), app.getSkin());
        applyButton = new TextButton(app.getLang().get("menu.global.button.apply"), app.getSkin());

        restartDialog = new RestartDialog(app);
    }

    @Override
    public void addWidgets() {
        add(titleLabel).colspan(2).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(resolutionLabel).right().padRight(Config.UI_MENU_ITEM_PADDING);
        add(resolutionCombo).left().padBottom(Config.UI_MENU_ITEM_PADDING).row();
        // Disabled due to time limitations. Not optimized for use.
//        add(fullscreenCheckbox).padBottom(Config.UI_MENU_ITEM_PADDING).row();

        Table buttons = new Table();
        buttons.add(cancelButton).width(Config.UI_SMALL_BUTTON_WIDTH).left();
        buttons.add(applyButton).width(Config.UI_SMALL_BUTTON_WIDTH).right();
        add(buttons).colspan(2).padTop(Config.UI_SEPARATOR_SPACE).row();
    }

    @Override
    public void setListeners() {
        fullscreenCheckbox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getMenuCheckboxSounds());
            }
        });
        cancelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showSettings();
            }
        });
        applyButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                restartDialog.show(app.getUi());
                applyChanges();
            }
        });
    }

    @Override
    public void configureWidgets() {
        resolutionCombo.setSelectedIndex(app.getSettingsManager().getConfig().getResolutionIndex());
        fullscreenCheckbox.setChecked(app.getSettingsManager().getConfig().isFullscreen());
    }

    @Override
    public void updateRunningConfig() {
        final int resolutionIndex = resolutionCombo.getSelectedIndex();
        app.getSettingsManager().getConfig().setResolutionIndex(resolutionIndex);
        app.getSettingsManager().getConfig().setScreenWidth(screenWidths[resolutionIndex]);
        app.getSettingsManager().getConfig().setScreenHeight(screenHeights[resolutionIndex]);
        app.getSettingsManager().getConfig().setFullscreen(fullscreenCheckbox.isChecked());
    }

    @Override
    public void updateGameState() {
    }

    @Override
    public void applyChanges() {
        Gdx.app.debug("GraphicsMenu#applyChanges", "Updating");
        updateRunningConfig();
        updateGameState();
        app.getSettingsManager().persist();
    }
}
