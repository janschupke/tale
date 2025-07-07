package eu.janschupke.tale.base.screen;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.content.config.enumeration.Screens;

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

