package eu.janschupke.tale.framework.utility;

import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.Unit;
import eu.janschupke.tale.framework.screen.BaseScreen;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.ui.table.RootTable;

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
        // TODO
//        final float duration = Config.SCREEN_TRANSITION_DURATION;
//
//        app.getUi().getRoot().getColor().a = 1;
//        SequenceAction sequenceAction = new SequenceAction();
//        sequenceAction.addAction(Actions.fadeOut(duration));
//        sequenceAction.addAction(Actions.run(() -> {
//            app.swapHuds(newHud);
//            app.getUi().getRoot().addAction(Actions.fadeIn(duration));
//        }));
//        app.getUi().getRoot().addAction(sequenceAction);

        app.swapHuds(newHud);
    }
}
