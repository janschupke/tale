package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for on-screen level menu.
 * @author jan.schupke@gmail.com
 */
public class HudMenuTable extends UITable {
    private TextButton menuButton;
    private TextButton eventLogButton;
    private TextButton questLogButton;
    private TextButton inventoryButton;

    public HudMenuTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        menuButton = new TextButton(app.getLang().get("hud.menu.menu"), app.getSkin());
        eventLogButton = new TextButton(app.getLang().get("hud.menu.events"), app.getSkin());
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
                ((GameScreen)app.getScreen()).toggleMenu();
            }
        });
        eventLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleEventLog();
            }
        });
        questLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleQuestLog();
            }
        });
        inventoryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleInventory();
            }
        });
    }
}
