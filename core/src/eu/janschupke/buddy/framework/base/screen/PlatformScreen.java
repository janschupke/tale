package eu.janschupke.buddy.framework.base.screen;

import eu.janschupke.buddy.framework.App;

/**
 * Base class for platform style screens (levels),
 * with gravity, left/right movement and jumps.
 */
public abstract class PlatformScreen extends GameScreen {
    public PlatformScreen(final App app) {
        super(app);
    }
}

