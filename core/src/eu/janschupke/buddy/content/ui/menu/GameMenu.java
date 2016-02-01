package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.MenuTable;

/**
 * Adjusted menu, accessible from within any level.
 */
public class GameMenu extends MenuTable {
    private Label titleLabel;;
    private TextButton resumeButton;
    private TextButton settingsButton;
    private TextButton hotkeysButton;
    private TextButton exitButton;

    public GameMenu(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.game.label.title"), app.getSkin());
        resumeButton = new TextButton(app.getLang().get("menu.game.button.resume"), app.getSkin());
        settingsButton = new TextButton(app.getLang().get("menu.game.button.settings"), app.getSkin());
        hotkeysButton = new TextButton(app.getLang().get("menu.game.button.hotkeys"), app.getSkin());
        exitButton = new TextButton(app.getLang().get("menu.game.button.exit"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(separatorSpace).row();
        add(resumeButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(settingsButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(hotkeysButton).width(buttonWidth).padBottom(menuItemPadding).row();
        add(exitButton).width(buttonWidth).padBottom(menuItemPadding).row();
    }

    @Override
    public void setListeners() {
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                ((GameScreen)app.getScreen()).toggleMenu();
            }
        });

        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showSettings();
            }
        });

        hotkeysButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showHotkeys();
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().leaveLevel();
            }
        });
    }
}
