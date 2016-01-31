package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import eu.janschupke.buddy.content.entity.creature.Player;
import eu.janschupke.buddy.framework.base.entity.Interactible;

/**
 * Base contact listener for Box2D bodies.
 */
public class BodyContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Gdx.app.debug("BodyContactListener#beginContact", "Contacting");
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (!isViableContact(fa, fb)) {
            return;
        }

        Gdx.app.debug("BodyContactListener#beginContact", "Is viable");

        if (!isPlayerBody(fa)) {
            getEntity(fa).engage();
        } else {
            getEntity(fb).engage();
        }
    }

    @Override
    public void endContact(Contact contact) {
        Gdx.app.debug("BodyContactListener#endContact", "Ending");
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (!isViableContact(fa, fb)) {
            return;
        }

        if (!isPlayerBody(fa)) {
            getEntity(fa).disengage();
        } else {
            getEntity(fb).disengage();
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}

    /**
     * Verifies that a viable contact logic can occur between these two provided fixtures.
     * @param fa First fixture.
     * @param fb Second fixture.
     * @return True if both fixtures are not null, have user data set,
     * and at least one of them implements Interactible interface.
     */
    protected boolean isViableContact(Fixture fa, Fixture fb) {
        if (fa == null || fb == null) return false;
        if (fa.getBody().getUserData() == null || fb.getBody().getUserData() == null) return false;

        // At least one must be interactible - player is not.
        // The engage method will be called on the interactible object.
        return ((fa.getBody().getUserData() instanceof Interactible)
                || (fb.getBody().getUserData() instanceof Interactible));
    }

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
