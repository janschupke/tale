package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Part of the standard HUD that displays indicators
 * about new events/quests/inventory items.
 * @author jan.schupke@gmail.com
 */
public class IndicatorTable extends UITable {
    private TextButton newEventButton;
    private TextButton newQuestButton;
    private TextButton newItemButton;

    private Table contentTable;

    private boolean newEvent;
    private boolean newQuest;
    private boolean newItem;
    private boolean indicating;

    public IndicatorTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        contentTable = new Table();
        contentTable.setBackground(drawable);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        newEventButton = new TextButton(app.getLang().get("hud.indicator.event"), app.getSkin());
        newQuestButton = new TextButton(app.getLang().get("hud.indicator.quest"), app.getSkin());
        newItemButton = new TextButton(app.getLang().get("hud.indicator.item"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        // Nothing by default.
    }

    /**
     * Returns information about the empty state of the indicator table.
     * @return True if no new quests, events or items are available. False otherwise.
     */
    private boolean isEmpty() {
        return (!newEvent && !newQuest && !newItem);
    }

    /**
     * Sets the indicator to the requested state. Add widgets if indication is requested,
     * removes widgets if indication is not requested.
     * @param state Requested new indicator state.
     */
    private void indicate(boolean state) {
        if (state && indicating) return;
        if (!state && !indicating) return;

        if (state) {
            add(contentTable);
            indicating = true;
        } else if (isEmpty()) {
            contentTable.clear();
            contentTable.remove();
            indicating = false;
        }
    }

    /**
     * Activates indication of a new event.
     */
    public void activateEvent() {
        contentTable.add(newEventButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_INDICATOR_WIDTH).row();
        newEvent = true;
        indicate(true);
    }

    /**
     * Deactivates indication of a new event.
     */
    public void deactivateEvent() {
        contentTable.removeActor(newEventButton);
        newEvent = false;
        indicate(false);
    }

    /**
     * Activates indication of a new quest.
     */
    public void activateQuest() {
        contentTable.add(newQuestButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_INDICATOR_WIDTH).row();
        newQuest = true;
        indicate(true);
    }

    /**
     * Deactivates indication of a new quest.
     */
    public void deactivateQuest() {
        contentTable.removeActor(newQuestButton);
        newQuest = false;
        indicate(false);
    }

    /**
     * Activates indication of a new inventory item.
     */
    public void activateItem() {
        contentTable.add(newItemButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_INDICATOR_WIDTH).row();
        newItem = true;
        indicate(true);
    }

    /**
     * Deactivates indication of a new inventory item.
     */
    public void deactivateItem() {
        contentTable.removeActor(newItemButton);
        newItem = false;
        indicate(false);
    }

    @Override
    public void setListeners() {
        newEventButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleEventLog();
            }
        });
        newQuestButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleQuestLog();
            }
        });
        newItemButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleInventory();
            }
        });
    }
}
