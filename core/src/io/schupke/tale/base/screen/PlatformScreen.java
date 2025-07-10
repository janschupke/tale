package io.schupke.tale.base.screen;

import io.schupke.tale.base.App;
import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Base class for platform style screens (levels),
 * with gravity, left/right movement and jumps.
 */
public abstract class PlatformScreen extends GameScreen {
    public PlatformScreen(final App app, final Screens tag) {
        super(app, tag);
    }
}
