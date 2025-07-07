package eu.janschupke.tale.base.interaction;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.entity.Triggerable;
import eu.janschupke.tale.base.event.BaseEvent;

/**
 * A switch class that toggles possible interaction based on Triggerable contact.
 *
 * @author jan.schupke@gmail.com
 */
public class InteractionSwitch {
    private static Triggerable triggerable;
    private static BaseEvent interactionEvent;

    /**
     * Enables triggerable interaction.
     *
     * @param triggerable      Object that can be triggered.
     * @param interactionEvent Event that should take place after that object is triggered.
     * @param app              Application instance.
     */
    public static void enable(Triggerable triggerable, BaseEvent interactionEvent, App app) {
        InteractionSwitch.triggerable = triggerable;
        InteractionSwitch.interactionEvent = interactionEvent;
        app.getEventHandler().handleHintMessage();
    }

    /**
     * Disables triggerable interaction.
     *
     * @param app Application instance.
     */
    public static void disable(App app) {
        triggerable = null;
        interactionEvent = null;
        app.getEventHandler().handleHintMessage();
    }

    public static boolean isInteractionPossible() {
        return (triggerable != null);
    }

    public static Triggerable getTriggerable() {
        return triggerable;
    }

    public static BaseEvent getInteractionEvent() {
        return interactionEvent;
    }
}
