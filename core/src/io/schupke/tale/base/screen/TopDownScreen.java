package io.schupke.tale.base.screen;

import io.schupke.tale.base.App;
import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Base class for top-down screens (levels).
 * Has no gravity. Units can move to all 4/8 directions, no jumping.
 */
public abstract class TopDownScreen extends GameScreen {
    public TopDownScreen(final App app, final Screens tag) {
        super(app, tag);
    }
}
