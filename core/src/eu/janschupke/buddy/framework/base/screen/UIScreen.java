package eu.janschupke.buddy.framework.base.screen;

import com.badlogic.gdx.graphics.Texture;
import eu.janschupke.buddy.framework.App;

/**
 * Base class for all pure UI screens.
 * These screens do not feature any game logic
 * and only display menus.
 */
public abstract class UIScreen extends BaseScreen {
    protected Texture backgroundTexture;

    public UIScreen(final App app) {
        super(app);
    }

    @Override
    public void dispose() {
        super.dispose();
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
