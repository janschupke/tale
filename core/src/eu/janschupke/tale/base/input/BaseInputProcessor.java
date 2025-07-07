package eu.janschupke.tale.base.input;

import com.badlogic.gdx.InputAdapter;
import eu.janschupke.tale.base.App;

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
