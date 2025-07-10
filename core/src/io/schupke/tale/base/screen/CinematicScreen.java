package io.schupke.tale.base.screen;

import io.schupke.tale.base.App;
import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Base class for cinematic and splash screens.
 * Non-interactive, no UI.
 * Transitions to the next screen when the animation completes,
 * can be skipped by a button press.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class CinematicScreen extends BaseScreen {
    public CinematicScreen(final App app, final Screens tag) {
        super(app, tag);
    }
}
