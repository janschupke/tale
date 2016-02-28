package eu.janschupke.buddy.framework.base.interaction;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains interaction logic, decisions etc.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class Interaction {
    protected App app;
    protected Triggerable triggerable;
    protected String title;
    protected List<Situation> situations;

    /**
     * The situation that is currently active,
     * and therefore visible in the interaction GUI during the interaction.
     */
    protected Situation currentSituation;

    /**
     * Configured situation that is to become current in a case of sudden interaction interruption,
     * e.g. moving away from the triggerable object.
     */
    protected Situation fallbackSituation;

    public Interaction(final App app, final Triggerable triggerable) {
        this.app = app;
        this.triggerable = triggerable;
        situations = new ArrayList<>();
        configure();
    }

    /**
     * Configures the interaction, its situations, current and fallback situations, etc.
     */
    protected abstract void configure();

    /**
     * Transitions to the provided situation.
     * @param situation New situation to be displayed.
     * @param app Application instance.
     */
    protected void transition(Situation situation, App app) {
        currentSituation = situation;
        InteractionSwitch.getTriggerable().startInteraction(app);
    }

    /**
     * All logic that happens when a decision is chosen.
     * Contains logic for each possible decision.
     *
     * @param decision Selected decision.
     */
    public abstract void handle(Decision decision);

    public void fallback() {
        currentSituation = fallbackSituation;
    }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return currentSituation.getDescription();
    }
}
