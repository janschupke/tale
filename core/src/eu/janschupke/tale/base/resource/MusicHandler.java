package eu.janschupke.tale.base.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import eu.janschupke.tale.base.App;

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
    private Music houseMusic;
    private Music dungeonMusic;

    public MusicHandler(final App app) {
        super(app);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.mp3"));
        forestMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-rumbling.mp3"));
        outskirtsMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        caveMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        settlementMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        houseMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
        dungeonMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.mp3"));
    }

    /**
     * Plays random harpsichord track over background music.
     * Does not loop. On repeated calls stop the previous harpsichord track,
     * if it is still playing.
     */
    public void playHarpsichord() {
        Gdx.app.debug("MusicHandler#playHarpsichord", "Playing harpsichord");
        // TODO: implement.
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

    public Music getHouseMusic() {
        return houseMusic;
    }

    public Music getDungeonMusic() {
        return dungeonMusic;
    }

    @Override
    public void dispose() {
        menuMusic.dispose();
        forestMusic.dispose();
        outskirtsMusic.dispose();
        caveMusic.dispose();
        settlementMusic.dispose();
        houseMusic.dispose();
        dungeonMusic.dispose();
    }
}
