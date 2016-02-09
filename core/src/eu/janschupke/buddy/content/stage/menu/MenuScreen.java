package eu.janschupke.buddy.content.stage.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.UIScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Main menu screen.
 */
public class MenuScreen extends UIScreen {
    private GlyphLayout titleLayout;

    public MenuScreen(final App app) {
        super(app);
        Gdx.app.debug("MenuScreen", "Constructing");

        backgroundMusic = app.getResourceHandler().getMenuMusic();
        titleLayout = new GlyphLayout(app.getFont(), Config.GAME_TITLE);
        backgroundTexture = new Texture(Gdx.files.internal("textures/gui/menu-screen-background.png"));
    }

    @Override
    public void update(float delta) {}

    @Override
    public void render(float delta) {
        super.render(delta);

        app.getBatch().begin();
        app.getBatch().draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        app.getFont().draw(app.getBatch(), titleLayout,
                app.getUi().getWidth() / 2 - titleLayout.width / 2,
                app.getUi().getHeight() - 10);
        app.getBatch().end();

        renderStage();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
