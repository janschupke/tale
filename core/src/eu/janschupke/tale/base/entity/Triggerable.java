package eu.janschupke.tale.base.entity;

import com.badlogic.gdx.Gdx;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.exception.NoHudException;
import eu.janschupke.tale.base.interaction.Interaction;
import eu.janschupke.tale.base.interaction.InteractionSwitch;

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
    default void startInteraction(final App app) {
        try {
            app.getHud().getInteractionTable().update(InteractionSwitch.getTriggerable().getInteraction());
            app.getGameState().getGlobalLevelState().setInteractionActive(true);
            app.getEventHandler().handleHintMessage();
        } catch (NoHudException e) {
            Gdx.app.log("Triggerable#startInteraction", "Could not get HUD instance");
        }
    }

    /**
     * Takes care of the HUD change during the interaction end.
     *
     * @param app Current application.
     */
    default void endInteraction(final App app) {
        try {
            app.getHud().getInteractionTable().free();
            app.getGameState().getGlobalLevelState().setInteractionActive(false);
            app.getEventHandler().handleHintMessage();
            InteractionSwitch.getTriggerable().getInteraction().fallback();
        } catch (NoHudException e) {
            Gdx.app.log("Triggerable#endInteraction", "Could not get HUD instance");
        } catch (NullPointerException e) {
            // No triggerable, happens during triggered screen transitions.
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
