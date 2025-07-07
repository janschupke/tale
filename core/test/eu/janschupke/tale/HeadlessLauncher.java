package eu.janschupke.tale;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

/**
 * Application initializer for testing.
 *
 * @author jan.schupke@gmail.com
 */
public class HeadlessLauncher {
    private static Tale tale;
    private static HeadlessApplication app;

    static {
        final HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        config.renderInterval = 1f / 60;
        tale = new Tale();
        app = new HeadlessApplication(tale, config);
    }

    public static Tale getTale() {
        return tale;
    }

    public static HeadlessApplication getApp() {
        return app;
    }
}
