package eu.janschupke.tale.content.stage.splash;

import eu.janschupke.tale.content.config.enumeration.Huds;
import eu.janschupke.tale.content.config.enumeration.Screens;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.base.screen.CinematicScreen;

/**
 * Splash screen class.
 *
 * @author jan.schupke@gmail.com
 */
public class SplashScreen extends CinematicScreen {
    public SplashScreen(final App app) {
        super(app, Screens.SPLASH);
    }

    @Override
    public void show() {
        super.show();
        app.setScreen(app.getScreenInstance(Screens.MENU));
        app.swapHuds(app.getHud(Huds.MAINMENU));
    }

    @Override
    public void update(float delta) {
    }
}
