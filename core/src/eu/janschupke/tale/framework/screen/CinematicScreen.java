package eu.janschupke.tale.framework.screen;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;

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