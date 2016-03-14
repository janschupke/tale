package eu.janschupke.tale.content.stage.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.UiScreen;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.content.config.enumeration.Screens;

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
        renderStage();

        app.getBatch().begin();
        app.getFont().draw(app.getBatch(), titleLayout,
                app.getUi().getWidth() / 2 - titleLayout.width / 2,
                app.getUi().getHeight() - Config.UI_INDENT_TITLE);
        app.getBatch().end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
