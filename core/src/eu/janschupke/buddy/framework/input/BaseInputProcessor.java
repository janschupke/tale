package eu.janschupke.buddy.framework.input;

import com.badlogic.gdx.InputAdapter;
import eu.janschupke.buddy.framework.App;

/**
 * Base class for all input processors.
 *
 * @author jan.schupke@gmail.com
 */
public abstract class BaseInputProcessor extends InputAdapter {
    protected App app;

    public BaseInputProcessor(final App app) {
        this.app = app;
    }
}
