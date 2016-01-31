package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.physics.box2d.*;
import eu.janschupke.buddy.content.entity.creature.Player;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.Interactible;

/**
 * Base contact listener for Box2D bodies.
 */
public abstract class BodyContactListener implements ContactListener {
    protected final App app;

    public BodyContactListener(final App app) {
        this.app = app;
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}

    /**
     * Returns information about whether the fixture belongs to the player body.
     * @param f Provided fixture.
     * @return True if player, false otherwise.
     */
    protected boolean isPlayerBody(Fixture f) {
        return (f.getBody().getUserData() instanceof Player);
    }

    /**
     * Retrieves the Interactible to which the provided fixture is attached to.
     * @param f Provided fixture.
     * @return Attached Interactible object.
     */
    protected Interactible getEntity(Fixture f) {
        return (Interactible) (f.getBody().getUserData());
    }
}
