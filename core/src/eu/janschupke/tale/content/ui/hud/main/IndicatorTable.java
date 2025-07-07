package eu.janschupke.tale.content.ui.hud.main;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.state.GlobalLevelState;
import eu.janschupke.tale.base.ui.table.UiTable;
import eu.janschupke.tale.content.config.Config;

import java.util.Observable;
import java.util.Observer;

/**
 * Part of the standard HUD that displays indicators
 * about new events/quests/inventory items.
 *
 * @author jan.schupke@gmail.com
 */
public class IndicatorTable extends UiTable implements Observer {
    private TextButton mewMessageButton;
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
        mewMessageButton = new TextButton(app.getLang().get("hud.indicator.message"), app.getSkin());
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
            contentTable.add(mewMessageButton).pad(Config.HUD_BUTTON_PADDING)
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
        mewMessageButton.addListener(new ClickListener() {
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
