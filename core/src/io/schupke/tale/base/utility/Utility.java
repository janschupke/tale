package io.schupke.tale.base.utility;

import io.schupke.tale.base.App;
import io.schupke.tale.base.entity.Unit;
import io.schupke.tale.base.screen.BaseScreen;
import io.schupke.tale.base.screen.GameScreen;
import io.schupke.tale.base.ui.table.RootTable;
import io.schupke.tale.content.config.enumeration.Screens;

/**
 * Utility class providing common helper methods.
 * Contains static utility functions for various operations.
 */
public class Utility {
    /**
     * Transitions to a new screen and a new HUD.
     *
     * @param app       Application reference.
     * @param newScreen New screen reference.
     * @param newHud    New hud reference.
     */
    public static void transitionScreens(final App app, final BaseScreen newScreen, final RootTable newHud) {
        app.setScreen(newScreen);
        app.swapHuds(newHud);
    }

    /**
     * Preserves player unit movement flags during screen transitions.
     * @param app Application instance.
     * @param newScreen New screen tag.
     */
    public static void preservePlayerMovement(final App app, Screens newScreen) {
        Unit previousScreenUnit = app.getGameState().getCurrentLevel().getWorld().getPlayerUnit();
        Unit nextScreenUnit = ((GameScreen)app.getScreenInstance(newScreen)).getWorld().getPlayerUnit();

        nextScreenUnit.preserveMovement(previousScreenUnit);
    }

    /**
     * Transitions to a new HUD.
     *
     * @param app    Application reference.
     * @param newHud New hud reference.
     */
    public static void transitionHuds(final App app, final RootTable newHud) {
        app.swapHuds(newHud);
    }
}
