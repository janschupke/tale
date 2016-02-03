package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.PreferenceMenu;
import eu.janschupke.buddy.framework.base.ui.table.MenuTable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Audio settings UI.
 */
public class AudioMenu extends MenuTable implements PreferenceMenu {
    private Label titleLabel;
    private Label masterVolumeLabel;
    private Slider masterVolumeSlider;
    private Label masterVolumeValueLabel;
    private Label musicVolumeLabel;
    private Slider musicVolumeSlider;
    private Label musicVolumeValueLabel;
    private Label sfxVolumeLabel;
    private Slider sfxVolumeSlider;
    private Label sfxVolumeValueLabel;
    private Label speechVolumeLabel;
    private Slider speechVolumeSlider;
    private Label speechVolumeValueLabel;
    private CheckBox enableMusicCheckbox;
    private CheckBox enableSoundCheckbox;
    private TextButton cancelButton;
    private TextButton applyButton;

    public AudioMenu(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
        configureWidgets();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.settings.audio.label.title"), app.getSkin());
        masterVolumeLabel = new Label(app.getLang().get("menu.settings.audio.label.master"), app.getSkin());
        masterVolumeSlider = new Slider(Config.SLIDER_MIN, Config.SLIDER_MAX, Config.SLIDER_STEP, false, app.getSkin());
        masterVolumeValueLabel = new Label("", app.getSkin());
        musicVolumeLabel = new Label(app.getLang().get("menu.settings.audio.label.music"), app.getSkin());
        musicVolumeSlider = new Slider(Config.SLIDER_MIN, Config.SLIDER_MAX, Config.SLIDER_STEP, false, app.getSkin());
        musicVolumeValueLabel = new Label("", app.getSkin());
        sfxVolumeLabel = new Label(app.getLang().get("menu.settings.audio.label.sfx"), app.getSkin());
        sfxVolumeSlider = new Slider(Config.SLIDER_MIN, Config.SLIDER_MAX, Config.SLIDER_STEP, false, app.getSkin());
        sfxVolumeValueLabel = new Label("", app.getSkin());
        speechVolumeLabel = new Label(app.getLang().get("menu.settings.audio.label.speech"), app.getSkin());
        speechVolumeSlider = new Slider(Config.SLIDER_MIN, Config.SLIDER_MAX, Config.SLIDER_STEP, false, app.getSkin());
        speechVolumeValueLabel = new Label("", app.getSkin());
        enableMusicCheckbox = new CheckBox(app.getLang().get("menu.settings.audio.checkbox.enable-music"), app.getSkin());
        enableSoundCheckbox = new CheckBox(app.getLang().get("menu.settings.audio.checkbox.enable-sound"), app.getSkin());
        cancelButton = new TextButton(app.getLang().get("menu.global.button.cancel"), app.getSkin());
        applyButton = new TextButton(app.getLang().get("menu.global.button.apply"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).colspan(3).padBottom(separatorSpace).row();
        add(masterVolumeLabel).right().padRight(menuItemPadding);
        add(masterVolumeSlider).left().padBottom(menuItemPadding);
        add(masterVolumeValueLabel).left().padBottom(menuItemPadding).width(percentWidth).row();
        add(musicVolumeLabel).right().padRight(menuItemPadding);
        add(musicVolumeSlider).left().padBottom(menuItemPadding);
        add(musicVolumeValueLabel).left().padBottom(menuItemPadding).width(percentWidth).row();
        add(sfxVolumeLabel).right().padRight(menuItemPadding);
        add(sfxVolumeSlider).left().padBottom(menuItemPadding);
        add(sfxVolumeValueLabel).left().padBottom(menuItemPadding).width(percentWidth).row();
        add(speechVolumeLabel).right().padRight(menuItemPadding);
        add(speechVolumeSlider).left().padBottom(menuItemPadding);
        add(speechVolumeValueLabel).left().padBottom(menuItemPadding).width(percentWidth).row();
        add(enableMusicCheckbox).colspan(3).padBottom(menuItemPadding).row();
        add(enableSoundCheckbox).colspan(3).padBottom(menuItemPadding).row();

        Table buttons = new Table();
        buttons.add(cancelButton).width(smallButtonWidth).left();
        buttons.add(applyButton).width(smallButtonWidth).right();
        add(buttons).colspan(3).padTop(separatorSpace).row();
    }

    @Override
    public void setListeners() {
        masterVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                masterVolumeValueLabel.setText(String.format("%.0f%%", masterVolumeSlider.getValue()));
            }
        });
        musicVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                musicVolumeValueLabel.setText(String.format("%.0f%%", musicVolumeSlider.getValue()));
            }
        });
        sfxVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sfxVolumeValueLabel.setText(String.format("%.0f%%", sfxVolumeSlider.getValue()));
            }
        });
        speechVolumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                speechVolumeValueLabel.setText(String.format("%.0f%%", speechVolumeSlider.getValue()));
            }
        });
        enableMusicCheckbox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuCheckboxSounds());
                app.getEventHandler().toggleMusic();
            }
        });
        enableSoundCheckbox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuCheckboxSounds());
                app.getEventHandler().toggleSound();
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
        masterVolumeSlider.setValue(app.getSettingsManager().getConfig().getMasterVolume() * Config.SLIDER_MAX);
        musicVolumeSlider.setValue(app.getSettingsManager().getConfig().getMusicVolume() * Config.SLIDER_MAX);
        sfxVolumeSlider.setValue(app.getSettingsManager().getConfig().getSoundVolume() * Config.SLIDER_MAX);
        speechVolumeSlider.setValue(app.getSettingsManager().getConfig().getSpeechVolume() * Config.SLIDER_MAX);
        enableMusicCheckbox.setChecked(app.getSettingsManager().getConfig().isEnableMusic());
        enableSoundCheckbox.setChecked(app.getSettingsManager().getConfig().isEnableSound());
    }

    @Override
    public void updateRunningConfig() {
        app.getSettingsManager().getConfig().setMasterVolume(masterVolumeSlider.getValue() / Config.SLIDER_MAX);
        app.getSettingsManager().getConfig().setMusicVolume(musicVolumeSlider.getValue() / Config.SLIDER_MAX);
        app.getSettingsManager().getConfig().setSoundVolume(sfxVolumeSlider.getValue() / Config.SLIDER_MAX);
        app.getSettingsManager().getConfig().setSpeechVolume(speechVolumeSlider.getValue() / Config.SLIDER_MAX);
        app.getSettingsManager().getConfig().setEnableMusic(enableMusicCheckbox.isChecked());
        app.getSettingsManager().getConfig().setEnableSound(enableSoundCheckbox.isChecked());
    }

    @Override
    public void updateGameState() {
        app.getEventHandler().adjustMusicVolume();
    }

    @Override
    public void applyChanges() {
        updateRunningConfig();
        updateGameState();
        app.getSettingsManager().persist();
    }

    public CheckBox getEnableMusicCheckbox() {
        return enableMusicCheckbox;
    }

    public CheckBox getEnableSoundCheckbox() {
        return enableSoundCheckbox;
    }
}
