package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.content.ui.hud.HintTable;
import eu.janschupke.buddy.framework.base.entity.Triggerable;

/**
 * A switch class that toggles possible interaction based on Interactible contact.
 */
public class InteractionSwitch {
    private static Triggerable triggerable;
    private static BaseEvent interactionEvent;

    public static void enable(Triggerable triggerable, BaseEvent interactionEvent, HintTable hintTable) {
        InteractionSwitch.triggerable = triggerable;
        InteractionSwitch.interactionEvent = interactionEvent;
        hintTable.update(triggerable.getInteractionHint());
    }

    /**
     * TODO: documentation
     * @param hintTable
     */
    public static void disable(HintTable hintTable) {
        triggerable = null;
        interactionEvent = null;
        hintTable.clear();
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
