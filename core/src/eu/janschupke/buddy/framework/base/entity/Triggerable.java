package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.util.Utility;

/**
 * Interface for all world entities that trigger an event upon contact.
 */
public interface Triggerable {
    /**
     * Called when the body contact begins.
     */
    void engage();

    /**
     * Called when the body contact ends.
     */
    void disengage();

    default void startInteraction(App app) {
        try {
            ((GameScreen) app.getScreen()).getLevelState().setHintCache(Utility.getHud(app).getHintTable().getHint());
            Utility.getHud(app).getHintTable().clear();
            Utility.getHud(app).getInteractionTable().update(InteractionSwitch.getTriggerable().getInteraction());
        } catch (NoHudException e) {
            // TODO
        }
    }

    /**
     * TODO: describe
     */
    default void endInteraction(App app) {
        try {
            InteractionSwitch.getTriggerable().getInteraction().fallback();
            Utility.getHud(app).getInteractionTable().free();
            Utility.getHud(app).getHintTable().update(((GameScreen) app.getScreen()).getLevelState().getHintCache());
        } catch (NoHudException e) {
            Gdx.app.log("GoldCoinItem#disengage", "No HUD problem.");
        }
    }

    /**
     * Returns a hint that is displayed to the player.
     * @return Text interaction hint, if available. Null otherwise.
     */
    String getInteractionHint();

    /**
     * Retrieves entity's interaction object.
     * @return Specific interaction object.
     */
    Interaction getInteraction();
}
