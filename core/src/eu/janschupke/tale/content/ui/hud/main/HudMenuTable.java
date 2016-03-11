package eu.janschupke.tale.content.ui.hud.main;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.screen.GameScreen;
import eu.janschupke.tale.base.ui.table.UiTable;
import eu.janschupke.tale.content.config.Config;

/**
 * GUI table structure for on-screen level menu.
 *
 * @author jan.schupke@gmail.com
 */
public class HudMenuTable extends UiTable {
    private TextButton menuButton;
    private TextButton eventLogButton;
    private TextButton questLogButton;
    private TextButton inventoryButton;

    public HudMenuTable(final App app) {
        super(app);
        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        menuButton = new TextButton(app.getLang().get("hud.menu.menu"), app.getSkin());
        eventLogButton = new TextButton(app.getLang().get("hud.menu.messages"), app.getSkin());
        questLogButton = new TextButton(app.getLang().get("hud.menu.quests"), app.getSkin());
        inventoryButton = new TextButton(app.getLang().get("hud.menu.inventory"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(menuButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_TOP_BUTTON_WIDTH);
        add(eventLogButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_TOP_BUTTON_WIDTH);
        add(questLogButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_TOP_BUTTON_WIDTH);
        add(inventoryButton).pad(Config.HUD_BUTTON_PADDING).width(Config.HUD_TOP_BUTTON_WIDTH);
    }

    @Override
    public void setListeners() {
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleMenu();
            }
        });
        eventLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleEventLog();
            }
        });
        questLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleQuestLog();
            }
        });
        inventoryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleInventory();
            }
        });
    }
}
