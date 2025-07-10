package io.schupke.tale.base.entity;

import com.badlogic.gdx.Gdx;

import io.schupke.tale.base.App;
import io.schupke.tale.base.exception.NoHudException;
import io.schupke.tale.base.interaction.Interaction;
import io.schupke.tale.base.interaction.InteractionSwitch;

/**
 * Interface for objects that can be triggered by player interaction.
 * Defines the contract for interactive game objects.
 */
public interface Triggerable {
    /**
     * Called when the object is engaged (player enters trigger area).
     */
    void engage();

    /**
     * Called when the object is disengaged (player leaves trigger area).
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
