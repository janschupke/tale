package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.content.ui.hud.HintTable;
import eu.janschupke.buddy.framework.base.entity.Interactible;

/**
 * A switch class that toggles possible interaction based on Interactible contact.
 */
public class InteractionSwitch {
    private static Interactible interactible;
    private static BaseEvent interactionEvent;

    public static void enable(Interactible interactible, BaseEvent interactionEvent, HintTable hintTable) {
        InteractionSwitch.interactible = interactible;
        InteractionSwitch.interactionEvent = interactionEvent;
        hintTable.update(interactible.getInteractionHint());
    }

    public static void disable(HintTable hintTable) {
        interactible = null;
        interactionEvent = null;
        hintTable.clear();
    }

    public static boolean isInteractionPossible() {
        return (interactible != null);
    }

    public static Interactible getInteractible() {
        return interactible;
    }

    public static BaseEvent getInteractionEvent() {
        return interactionEvent;
    }
}
