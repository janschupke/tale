package eu.janschupke.tale.content.stage.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.screen.UiScreen;

/**
 * Main menu screen.
 *
 * @author jan.schupke@gmail.com
 */
public class MenuScreen extends UiScreen {
    private GlyphLayout titleLayout;

    public MenuScreen(final App app) {
        super(app, Screens.MENU);
        Gdx.app.debug("MenuScreen", "Constructing");
        backgroundMusic = app.getResourceManager().getMusicHandler().getMenuMusic();
        titleLayout = new GlyphLayout(app.getFont(), Config.GAME_TITLE);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        app.getBatch().begin();
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
