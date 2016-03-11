package eu.janschupke.tale.base.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import eu.janschupke.tale.base.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource handler for all music files.
 *
 * @author jan.schupke@gmail.com
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

    public MusicHandler(final App app) {
        super(app);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.mp3"));
        forestMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-rumbling.mp3"));
        outskirtsMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        caveMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        settlementMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        dungeonMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        outroMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));

        harpsichordMusic = new ArrayList<>();
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.mp3")));
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-rumbling.mp3")));
        harpsichordMusic.add(Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3")));
    }

    /**
     * Plays random harpsichord track over background music.
     * Does not loop. On repeated calls stop the previous harpsichord track,
     * if it is still playing.
     */
    public void playHarpsichord() {
        Gdx.app.debug("MusicHandler#playHarpsichord", "Playing harpsichord");
        harpsichordMusic.forEach(Music::stop);

        float volume = app.getSettingsManager().getConfig().getMasterVolume()
                * app.getSettingsManager().getConfig().getMusicVolume();

        int min = 0;
        int max = harpsichordMusic.size() - 1;
        int trackNumber = min + (int)(Math.random() * ((max - min) + 1));

        harpsichordMusic.get(trackNumber).setVolume(volume);
        harpsichordMusic.get(trackNumber).setLooping(false);
        harpsichordMusic.get(trackNumber).play();
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