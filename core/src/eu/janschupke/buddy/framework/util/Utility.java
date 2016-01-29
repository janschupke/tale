package eu.janschupke.buddy.framework.util;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * General utility class.
 */
public class Utility {
    /**
     * Transitions to a new screen and a new HUD.
     * @param app Application reference.
     * @param newScreen New screen reference.
     * @param newHud New hud reference.
     */
    public static void transitionScreens(final App app, final BaseScreen newScreen, final UITable newHud) {
//        final float duration = Config.SCREEN_TRANSITION_DURATION;
//        app.getUi().getRoot().getColor().a = 1;
//        SequenceAction sequenceAction = new SequenceAction();
//        sequenceAction.addAction(Actions.fadeOut(duration));
//        sequenceAction.addAction(Actions.run(new Runnable() {
//            @Override
//            public void run() {
//                app.setScreen(newScreen);
//                app.swapHuds(newHud);
//                app.getUi().getRoot().addAction(Actions.fadeIn(duration));
//            }
//        }));
//        app.getUi().getRoot().addAction(sequenceAction);

        // TODO: asynchronous transition causes current screen to still be previous screen
        // TODO: when accessed after this method call.
        app.setScreen(newScreen);
        app.swapHuds(newHud);
    }

    /**
     * Transitions to a new HUD.
     * @param app Application reference.
     * @param newHud New hud reference.
     */
    public static void transitionHuds(final App app, final UITable newHud) {
        final float duration = Config.SCREEN_TRANSITION_DURATION;

        app.getUi().getRoot().getColor().a = 1;
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(Actions.fadeOut(duration));
        sequenceAction.addAction(Actions.run(new Runnable() {
            @Override
            public void run() {
                app.swapHuds(newHud);
                app.getUi().getRoot().addAction(Actions.fadeIn(duration));
            }
        }));
        app.getUi().getRoot().addAction(sequenceAction);
    }
}
