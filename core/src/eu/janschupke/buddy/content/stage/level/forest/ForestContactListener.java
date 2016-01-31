package eu.janschupke.buddy.content.stage.level.forest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import eu.janschupke.buddy.framework.base.world.BodyContactListener;

/**
 * Contact listener for the forest level.
 */
public class ForestContactListener extends BodyContactListener {
    @Override
    public void beginContact(Contact contact) {
        Gdx.app.debug("ForestContactListener#beginContact", "Contacting");
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa == null || fb == null) return;
        if (fa.getBody().getUserData() == null || fb.getBody().getUserData() == null) return;
        Gdx.app.debug("ForestContactListener#beginContact", "Null check passed");

        if (isPlayerBody(fa)) {
            Gdx.app.debug("ForestContactListener#beginContact", "Engaging fa");
            getEntity(fa).engage();
        } else {
            Gdx.app.debug("ForestContactListener#beginContact", "Engaging fb");
            getEntity(fb).engage();
        }
    }

    @Override
    public void endContact(Contact contact) {
        // TODO
    }
}
