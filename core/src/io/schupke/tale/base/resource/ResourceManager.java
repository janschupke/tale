package io.schupke.tale.base.resource;

import io.schupke.tale.base.App;

/**
 * Manages game resources including textures, sounds, and other assets.
 * Provides centralized resource loading and management.
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
