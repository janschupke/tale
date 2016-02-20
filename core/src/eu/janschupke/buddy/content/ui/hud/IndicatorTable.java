package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.screen.GlobalLevelState;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

import java.util.Observable;
import java.util.Observer;

/**
 * Part of the standard HUD that displays indicators
 * about new events/quests/inventory items.
 *
 * @author jan.schupke@gmail.com
 */
public class IndicatorTable extends UITable implements Observer {
    private TextButton newEventButton;
    private TextButton newQuestButton;
    private TextButton newItemButton;

    private Table contentTable;

    public IndicatorTable(final App app) {
        super(app);
        contentTable = new Table();
        contentTable.setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
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

    @Override
    public void update(Observable o, Object arg) {
        GlobalLevelState state = app.getGameState().getGlobalLevelState();

        // To clear all redundant padding.
        contentTable.clear();

        if (state.isIndicatorEmpty()) {
            contentTable.remove();
            return;
        }

        add(contentTable);

        if (state.isNewEvent()) {
            contentTable.add(newEventButton).pad(Config.HUD_BUTTON_PADDING)
                    .width(Config.HUD_INDICATOR_WIDTH).row();
        }
        if (state.isNewQuest()) {
            contentTable.add(newQuestButton).pad(Config.HUD_BUTTON_PADDING)
                    .width(Config.HUD_INDICATOR_WIDTH).row();
        }
        if (state.isNewItem()) {
            contentTable.add(newItemButton).pad(Config.HUD_BUTTON_PADDING)
                    .width(Config.HUD_INDICATOR_WIDTH).row();
        }
    }

    @Override
    public void setListeners() {
        newEventButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleEventLog();
            }
        });
        newQuestButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleQuestLog();
            }
        });
        newItemButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleInventory();
            }
        });
    }
}
