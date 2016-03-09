package eu.janschupke.tale.framework.screen;

import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;

/**
 * Base class for all pure UI screens.
 * These screens do not feature any game logic
 * and only display menus.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class UiScreen extends BaseScreen {
    protected Texture backgroundTexture;

    public UiScreen(final App app, final Screens tag) {
        super(app, tag);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}