package eu.janschupke.buddy.framework.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import eu.janschupke.buddy.framework.App;

/**
 * Resource handler for all music files.
 *
 * @author jan.schupke@gmail.com
 */
public class MusicHandler extends BaseResourceContainer {
    private Music menuMusic;
    private Music forestMusic;
    private Music outskirtsMusic;

    public MusicHandler(final App app) {
        super(app);
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/menu.wav"));
        forestMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-rumbling.wav"));
        outskirtsMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/natural-001-smooth.wav"));
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

    @Override
    public void dispose() {
        menuMusic.dispose();
        forestMusic.dispose();
        outskirtsMusic.dispose();
    }
}
