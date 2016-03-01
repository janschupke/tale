package eu.janschupke.buddy.framework.base.screen;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.enumeration.Screens;

/**
 * Base class for platform style screens (levels),
 * with gravity, left/right movement and jumps.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class PlatformScreen extends GameScreen {
    public PlatformScreen(final App app, final Screens tag) {
        super(app, tag);
    }
}

