package eu.janschupke.buddy.framework.base.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Generic Table extension, serving as a base for all HUDs and UIs.
 */
public abstract class RootTable extends Table implements UserInterface {
    protected final App app;

    protected int percentWidth = Config.UI_PERCENT_WIDTH;
    protected int buttonWidth = Config.UI_BUTTON_WIDTH;
    protected int smallButtonWidth = Config.UI_SMALL_BUTTON_WIDTH;
    protected int menuItemPadding = Config.UI_MENU_ITEM_PADDING;
    protected int separatorSpace = Config.UI_SEPARATOR_SPACE;
    protected int indentTop = Config.UI_INDENT_TOP;

    public RootTable(final App app) {
        this.app = app;

        setFillParent(true);
        setPosition(0, 0);
        align(Align.topLeft);
        setDebug(Config.DEBUG_MODE);
    }
}
