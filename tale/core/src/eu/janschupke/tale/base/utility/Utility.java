package eu.janschupke.tale.base.utility;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Unit;
import eu.janschupke.tale.base.screen.BaseScreen;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.ui.table.RootTable;
import eu.janschupke.tale.content.config.enumeration.Screens;

/**
 * General utility class.
 *
 * @author jan.schupke@gmail.com
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
