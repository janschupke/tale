package eu.janschupke.buddy.framework.base.event;

import eu.janschupke.buddy.content.ui.hud.HintTable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;

/**
 * A switch class that toggles possible interaction based on Triggerable contact.
 * @author jan.schupke@gmail.com
 */
public class InteractionSwitch {
    private static Triggerable triggerable;
    private static BaseEvent interactionEvent;

    /**
     * Enables triggerable interaction.
     * @param triggerable Object that can be triggered.
     * @param interactionEvent Event that should take place after that object is triggered.
     * @param app Application instance
     */
    public static void enable(Triggerable triggerable, BaseEvent interactionEvent, App app) {
        InteractionSwitch.triggerable = triggerable;
        InteractionSwitch.interactionEvent = interactionEvent;
        app.getGameState().getGlobalLevelState().setCurrentHint(triggerable.getInteractionHint());
    }

    /**
     * Disables triggerable interaction.
     * @param hintTable GUI table that shows hints.
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
