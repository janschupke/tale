package io.schupke.tale.base.screen;

import com.badlogic.gdx.graphics.Texture;

import io.schupke.tale.base.App;
import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Base class for all pure UI screens.
 * These screens do not feature any game logic
 * and only display menus.
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
