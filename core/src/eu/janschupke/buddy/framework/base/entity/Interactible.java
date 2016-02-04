package eu.janschupke.buddy.framework.base.entity;

/**
 * Interface for all world entities that can be interacted with upon contact.
 */
public interface Interactible {
    /**
     * Called when the body contact begins.
     */
    void engage();

    /**
     * Called when the body contact ends.
     */
    void disengage();

    /**
     * Returns a hint that is displayed to the player.
     * @return Text interaction hint.
     */
    String getInteractionHint();
}
