package eu.janschupke.buddy.framework.base.entity;

import com.badlogic.gdx.Gdx;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Interaction;

/**
 * Interface for all world entities that trigger an event upon contact.
 *
 * @author jan.schupke@gmail.com
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

    /**
     * Takes care of the HUD change during the interaction start.
     *
     * @param app Current application.
     */
    default void startInteraction(App app) {
        try {
            app.getGameState().getGlobalLevelState().cacheCurrentHint();
            app.getGameState().getGlobalLevelState().setCurrentHint("");
            app.getHud().getInteractionTable().update(InteractionSwitch.getTriggerable().getInteraction());
            app.getGameState().getGlobalLevelState().setInteractionActive(true);
        } catch (NoHudException e) {
            Gdx.app.log("Triggerable#startInteraction", "Could not get HUD instance");
        }
    }

    /**
     * Takes care of the HUD change during the interaction end.
     *
     * @param app Current application.
     */
    default void endInteraction(App app) {
        try {
            InteractionSwitch.getTriggerable().getInteraction().fallback();
            app.getHud().getInteractionTable().free();
            app.getGameState().getGlobalLevelState().activateCachedHint();
            app.getGameState().getGlobalLevelState().setInteractionActive(false);
        } catch (NoHudException e) {
            Gdx.app.log("Triggerable#endInteraction", "Could not get HUD instance");
        }
    }

    /**
     * Returns a hint that is displayed to the player.
     *
     * @return Text interaction hint, if available. Null otherwise.
     */
    String getInteractionHint();

    /**
     * Retrieves entity's interaction object.
     *
     * @return Specific interaction object.
     */
    Interaction getInteraction();
}
