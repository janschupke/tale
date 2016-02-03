package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.ui.table.UITable;

/**
 * GUI table structure for on-screen level menu.
 */
public class HudMenuTable extends UITable {
    private ImageButton menuButton;
    private ImageButton inventoryButton;
    private ImageButton characterButton;
    private ImageButton questLogButton;
    private ImageButton eventLogButton;

    public HudMenuTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-bar.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {

        menuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                new Texture(Gdx.files.internal("textures/gui/menu.png")))));
        inventoryButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                new Texture(Gdx.files.internal("textures/gui/inventory.png")))));
        characterButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                new Texture(Gdx.files.internal("textures/gui/character.png")))));
        questLogButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                new Texture(Gdx.files.internal("textures/gui/quest.png")))));
        eventLogButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(
                new Texture(Gdx.files.internal("textures/gui/event.png")))));
    }

    @Override
    public void addWidgets() {
        add(menuButton);
        add(inventoryButton);
        add(characterButton);
        add(questLogButton);
        add(eventLogButton);
    }

    @Override
    public void setListeners() {
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleMenu();
            }
        });
        inventoryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleInventory();
            }
        });
        characterButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleCharacter();
            }
        });
        questLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen)app.getScreen()).toggleQuestLog();
            }
        });
        eventLogButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ((GameScreen) app.getScreen()).toggleEventLog();
            }
        });
    }
}
