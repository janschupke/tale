package eu.janschupke.buddy.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Resource handler/provider for sounds and textures.
 */
public class ResourceHandler {
    private final App app;

    private Music menuMusic;
    private Music forestMusic;
    private Music outskirtsMusic;

    private Sound menuButtonSound;
    private Sound menuCheckboxSounds;

    public ResourceHandler(final App app) {
        this.app = app;

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.wav"));
        forestMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-rumbling.wav"));
        outskirtsMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.wav"));

        menuButtonSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/BUTTON_Deep_Smooth_Click_mono.wav"));
        menuCheckboxSounds = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/CLASP_Plastic_Open_stereo.wav"));
    }

    public void playSound(Sound sound) {
        if (!app.getSettingsManager().getConfig().isEnableSound()) {
            return;
        }
        sound.play(app.getSettingsManager().getConfig().getMasterVolume() * app.getSettingsManager().getConfig().getSoundVolume());
    }

    public Music getMenuMusic() {
        return menuMusic;
    }

    public Music getForestMusic() {
        return forestMusic;
    }

    public Music getOutskirtsMusic() {
        return outskirtsMusic;
    }

    public Sound getMenuButtonSound() {
        return menuButtonSound;
    }

    public Sound getMenuCheckboxSounds() {
        return menuCheckboxSounds;
    }

    public void dispose() {
        menuButtonSound.dispose();
    }
}
