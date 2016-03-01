package eu.janschupke.buddy.framework.base.screen;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.enumeration.Screens;

/**
 * Base class for top-down screens (levels).
 * Has no gravity. Units can move to all 4/8 directions, no jumping.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class TopDownScreen extends GameScreen {
    public TopDownScreen(final App app, final Screens tag) {
        super(app, tag);
    }
}
