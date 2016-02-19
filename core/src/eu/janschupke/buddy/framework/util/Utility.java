package eu.janschupke.buddy.framework.util;

import com.badlogic.gdx.scenes.scene2d.Actor;
import eu.janschupke.buddy.content.ui.hud.StandardHud;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.screen.BaseScreen;
import eu.janschupke.buddy.framework.base.ui.table.RootTable;

/**
 * General utility class.
 * @author jan.schupke@gmail.com
 */
public class Utility {
    /**
     * Transitions to a new screen and a new HUD.
     * @param app Application reference.
     * @param newScreen New screen reference.
     * @param newHud New hud reference.
     */
    public static void transitionScreens(final App app, final BaseScreen newScreen, final RootTable newHud) {
        app.setScreen(newScreen);
        app.swapHuds(newHud);
    }

    /**
     * Transitions to a new HUD.
     * @param app Application reference.
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

    /**
     * Retrieves the in-game hud instance.
     * @param app Current app.
     * @return In-game hud instance.
     */
    public static StandardHud getHud(final App app) throws NoHudException {
        Actor actor = app.getUi().getActors().get(0);
        if (!(actor instanceof StandardHud)) {
            throw new NoHudException();
        }
        return ((StandardHud)app.getUi().getActors().get(0));
    }
}
