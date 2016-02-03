package eu.janschupke.buddy.framework.base.ui.table;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.UserInterface;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Base class for all Scene2d tables used in the application.
 */
public abstract class UITable extends Table implements UserInterface {
    protected final App app;

    // TODO: need to be members?
    protected int percentWidth = Config.UI_PERCENT_WIDTH;
    protected int buttonWidth = Config.UI_BUTTON_WIDTH;
    protected int smallButtonWidth = Config.UI_SMALL_BUTTON_WIDTH;
    protected int menuItemPadding = Config.UI_MENU_ITEM_PADDING;
    protected int separatorSpace = Config.UI_SEPARATOR_SPACE;
    protected int indentTop = Config.UI_INDENT_TOP;

    protected int innerPadding = Config.HUD_INNER_PADDING;
    protected int buttonPadding = Config.HUD_BUTTON_PADDING;

    public UITable(final App app) {
        this.app = app;

        setDebug(Config.DEBUG_MODE);
    }
}
