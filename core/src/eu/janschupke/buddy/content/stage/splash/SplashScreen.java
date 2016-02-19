package eu.janschupke.buddy.content.stage.splash;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.CinematicScreen;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Splash screen class.
 * @author jan.schupke@gmail.com
 */
public class SplashScreen extends CinematicScreen {
    public SplashScreen(final App app) {
        super(app);
    }

    @Override
    public void show() {
        super.show();

        app.setScreen(app.getScreenInstance(Config.Screens.MENU));
        app.swapHuds(app.getHud(Config.Huds.MAINMENU));
    }

    @Override
    public void update(float delta) {
        //
    }
}
