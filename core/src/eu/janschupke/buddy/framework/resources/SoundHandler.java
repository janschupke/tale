package eu.janschupke.buddy.framework.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import eu.janschupke.buddy.framework.App;

/**
 * Resource handler for all sound files.
 *
 * @author jan.schupke@gmail.com
 */
public class SoundHandler extends BaseResourceContainer {
    private Sound heavyButtonSound;
    private Sound lightButtonSound;
    private Sound menuCheckboxSounds;

    public SoundHandler(final App app) {
        super(app);
        heavyButtonSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/button-heavy.wav"));
        lightButtonSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/button-light.wav"));
        menuCheckboxSounds = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/checkbox.wav"));
    }

    public void playSound(Sound sound) {
        if (!app.getSettingsManager().getConfig().isEnableSound()) {
            return;
        }
        sound.play(app.getSettingsManager().getConfig().getMasterVolume() * app.getSettingsManager().getConfig().getSoundVolume());
    }

    public Sound getHeavyButtonSound() {
        return heavyButtonSound;
    }

    public Sound getLightButtonSound() {
        return lightButtonSound;
    }

    public Sound getMenuCheckboxSounds() {
        return menuCheckboxSounds;
    }

    public void dispose() {
        heavyButtonSound.dispose();
        lightButtonSound.dispose();
        menuCheckboxSounds.dispose();
    }
}
