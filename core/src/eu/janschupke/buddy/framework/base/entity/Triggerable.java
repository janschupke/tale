package eu.janschupke.buddy.framework.base.entity;

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

    /**
     * Returns a hint that is displayed to the player.
     * @return Text interaction hint, if available. Null otherwise.
     */
    String getInteractionHint();
}
