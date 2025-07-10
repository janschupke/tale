package eu.janschupke.tale.base.resource;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import eu.janschupke.tale.base.App;

/**
 * Handles music playback and management.
 * Controls background music and audio settings.
 */
public class MusicHandler extends BaseResourceContainer {
    private Music menuMusic;
    private Music forestMusic;
    private Music outskirtsMusic;
    private Music caveMusic;
    private Music settlementMusic;
    private Music dungeonMusic;
    private Music outroMusic;

    private List<Music> harpsichordMusic;
    private int lastHarpsi;
    private int plays = 0;

    public MusicHandler(final App app) {
        super(app);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.mp3"));
        forestMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/forest.mp3"));
        outskirtsMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/outskirts.mp3"));
        caveMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/cave.mp3"));
        settlementMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/settlement.mp3"));
        dungeonMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/dungeon.mp3"));
        outroMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/outro.mp3"));

        harpsichordMusic = new ArrayList<>();
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/harpsi/bwv847.mp3")));
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/harpsi/bwv857.mp3")));
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/harpsi/bwv996.mp3")));
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/harpsi/sonata14.mp3")));
    }

    /**
     * Plays random harpsichord track over background music.
     * Does not loop. On repeated calls stop the previous harpsichord track,
     * if it is still playing.
     */
    public void playHarpsichord() {
        Gdx.app.debug("MusicHandler#playHarpsichord", "Playing harpsichord");
        stopHarpsichord();

        float volume = app.getSettingsManager().getConfig().getMasterVolume()
                * app.getSettingsManager().getConfig().getMusicVolume();

        int trackNumber;

        // Cycle through all at first.
        if (plays < harpsichordMusic.size()) {
            trackNumber = plays;
        // Random pick after.
        } else {
            do {
                int min = 0;
                int max = harpsichordMusic.size() - 1;
                trackNumber = min + (int) (Math.random() * ((max - min) + 1));
            } while (trackNumber == lastHarpsi);
        }

        plays++;
        lastHarpsi = trackNumber;

        harpsichordMusic.get(trackNumber).setVolume(volume);
        harpsichordMusic.get(trackNumber).setLooping(false);
        harpsichordMusic.get(trackNumber).play();
    }

    public void stopHarpsichord() {
        harpsichordMusic.forEach(Music::stop);
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

    public Music getCaveMusic() {
        return caveMusic;
    }

    public Music getSettlementMusic() {
        return settlementMusic;
    }

    public Music getDungeonMusic() {
        return dungeonMusic;
    }

    public Music getOutroMusic() {
        return outroMusic;
    }

    @Override
    public void dispose() {
        menuMusic.dispose();
        forestMusic.dispose();
        outskirtsMusic.dispose();
        caveMusic.dispose();
        settlementMusic.dispose();
        dungeonMusic.dispose();
        outroMusic.dispose();

        harpsichordMusic.forEach(Music::dispose);
    }
}
