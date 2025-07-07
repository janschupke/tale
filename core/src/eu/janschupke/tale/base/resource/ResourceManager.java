package eu.janschupke.tale.base.resource;

import eu.janschupke.tale.base.App;

/**
 * Resource manager that provides access to all resource handlers.
 *
 * @author jan.schupke@gmail.com
 */
public class ResourceManager extends BaseResourceContainer {
    private MusicHandler musicHandler;
    private SoundHandler soundHandler;
    private TextureHandler textureHandler;

    public ResourceManager(final App app) {
        super(app);
        musicHandler = new MusicHandler(app);
        soundHandler = new SoundHandler(app);
        textureHandler = new TextureHandler(app);
    }

    public MusicHandler getMusicHandler() {
        return musicHandler;
    }

    public SoundHandler getSoundHandler() {
        return soundHandler;
    }

    public TextureHandler getTextureHandler() {
        return textureHandler;
    }

    @Override
    public void dispose() {
        musicHandler.dispose();
        soundHandler.dispose();
        textureHandler.dispose();
    }
}
