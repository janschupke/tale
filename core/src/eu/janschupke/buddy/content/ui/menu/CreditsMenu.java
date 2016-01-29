package eu.janschupke.buddy.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.UITable;

/**
 * Credits table UI.
 */
public class CreditsMenu extends UITable {
    private Label titleLabel;
    private Label creditsLabel;
    private TextButton backButton;

    public CreditsMenu(final App app) {
        super(app);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("menu.credits.label.title"), app.getSkin());
        creditsLabel = new Label(app.getLang().get("menu.credits.label.credits"), app.getSkin());
        backButton = new TextButton(app.getLang().get("menu.global.button.back"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).padBottom(separatorSpace).row();
        add(creditsLabel).padBottom(menuItemPadding).row();
        add(backButton).width(buttonWidth).padBottom(menuItemPadding).row();
    }

    @Override
    public void setListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceHandler().playSound(app.getResourceHandler().getMenuButtonSound());
                app.getEventHandler().showMainMenu();
            }
        });
    }
}
