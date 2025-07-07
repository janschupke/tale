package eu.janschupke.tale.base.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import eu.janschupke.tale.base.App;

/**
 * Resource handler for all sound files.
 *
 * @author jan.schupke@gmail.com
 */
public class SoundHandler extends BaseResourceContainer {
    private Sound heavyButtonSound;
    private Sound lightButtonSound;
    private Sound menuCheckboxSounds;
    private Sound eventSound;

    // Forest.
    private Sound coinSound;
    private Sound ukkoSound;

    // Cave.
    private Sound villeSound;
    private Sound villeSadSound;

    // Outskirts.
    private Sound varpunenSound;
    private Sound lumberSound;
    private Sound jackSound;
    private Sound croneSound;

    // Settlement.
    private Sound smithSound;
    private Sound choboSound;

    // Dungeon.
    private Sound gateSound;
    private Sound chestSound;

    public SoundHandler(final App app) {
        super(app);
        heavyButtonSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/button-heavy.mp3"));
        lightButtonSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/button-light.mp3"));
        menuCheckboxSounds = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/checkbox.mp3"));
        eventSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/gui/event.mp3"));

        // Forest.
        coinSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/forest/coin.mp3"));
        ukkoSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/forest/ukko.mp3"));

        // Cave.
        villeSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/cave/ville.mp3"));
        villeSadSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/cave/ville-sad.mp3"));

        // Outskirts.
        varpunenSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/outskirts/varpunen.mp3"));
        lumberSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/outskirts/lumber.mp3"));
        jackSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/outskirts/jack.mp3"));
        croneSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/outskirts/crone.mp3"));

        // Settlement.
        smithSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/settlement/smith.mp3"));
        choboSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/settlement/chobo.mp3"));

        // Dungeon.
        gateSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/dungeon/gate.mp3"));
        chestSound = Gdx.audio.newSound(Gdx.files.internal("audio/sfx/level/dungeon/chest.mp3"));
    }

    public Sound getEventSound() {
        return eventSound;
    }

    public Sound getVilleSadSound() {
        return villeSadSound;
    }

    public Sound getVilleSound() {
        return villeSound;
    }

    public Sound getCoinSound() {
        return coinSound;
    }

    public Sound getUkkoSound() {
        return ukkoSound;
    }

    public Sound getVarpunenSound() {
        return varpunenSound;
    }

    public Sound getLumberSound() {
        return lumberSound;
    }

    public Sound getJackSound() {
        return jackSound;
    }

    public Sound getCroneSound() {
        return croneSound;
    }

    public Sound getSmithSound() {
        return smithSound;
    }

    public Sound getChoboSound() {
        return choboSound;
    }

    public Sound getGateSound() {
        return gateSound;
    }

    public Sound getChestSound() {
        return chestSound;
    }

    public void playSpeech(Sound sound) {
        if (!app.getSettingsManager().getConfig().isEnableSound()) {
            return;
        }
        sound.play(app.getSettingsManager().getConfig().getMasterVolume() * app.getSettingsManager().getConfig().getSpeechVolume());
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
        eventSound.dispose();
        coinSound.dispose();
        ukkoSound.dispose();
        villeSound.dispose();
        villeSadSound.dispose();
        varpunenSound.dispose();
        lumberSound.dispose();
        jackSound.dispose();
        croneSound.dispose();
        smithSound.dispose();
        choboSound.dispose();
        gateSound.dispose();
        chestSound.dispose();
    }
}
