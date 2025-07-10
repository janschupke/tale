package io.schupke.tale.content.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.table.MenuTable;
import io.schupke.tale.content.config.Config;

/**
 * Credits table UI.
 *
 * @author jan.schupke@gmail.com
 */
public class CreditsMenu extends MenuTable {
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
        add(titleLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(creditsLabel).padBottom(Config.UI_SEPARATOR_SPACE).row();
        add(backButton).width(Config.UI_BUTTON_WIDTH).padBottom(Config.UI_MENU_ITEM_PADDING).row();
    }

    @Override
    public void setListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                app.getEventHandler().showMainMenu();
            }
        });
    }
}
