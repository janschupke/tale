package eu.janschupke.buddy.framework.base.world;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Base contact listener for Box2D bodies.
 */
public class BodyContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        // TODO
    }

    @Override
    public void endContact(Contact contact) {
        // TODO
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {}

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {}
}
