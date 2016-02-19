package eu.janschupke.buddy.framework.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;

/**
 * Resource handler for all texture.
 * @author jan.schupke@gmail.com
 */
public class TextureHandler extends BaseResourceContainer {
    private Texture menuBackgroundTexture;
    private Texture hudBackgroundTexture;

    public TextureHandler(final App app) {
        super(app);
        menuBackgroundTexture = new Texture(Gdx.files.internal("textures/gui/menu-background.png"));
        hudBackgroundTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
    }

    public Texture getMenuBackgroundTexture() {
        return menuBackgroundTexture;
    }

    public Drawable getMenuBackgroundDrawable() {
        TextureRegion backgroundRegion = new TextureRegion(menuBackgroundTexture);
        return new TextureRegionDrawable(backgroundRegion);
    }

    public Texture getHudBackgroundTexture() {
        return hudBackgroundTexture;
    }

    public Drawable getHudBackgroundDrawable() {
        TextureRegion backgroundRegion = new TextureRegion(hudBackgroundTexture);
        return new TextureRegionDrawable(backgroundRegion);
    }

    @Override
    public void dispose() {
        menuBackgroundTexture.dispose();
        hudBackgroundTexture.dispose();
    }
}
