package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the interaction pane.
 * @author jan.schupke@gmail.com
 */
public class InteractionTable extends UITable {
    private Table contentTable;
    private Label titleLabel;
    private Label descriptionLabel;
    private Table optionTable;

    public InteractionTable(final App app) {
        super(app);
        align(Align.topLeft);
        initWidgets();
        addWidgets();
        setListeners();
    }

    /**
     * Updates the table based on the current interaction.
     * @param interaction Provided interaction object.
     */
    public void update(Interaction interaction) {
        Gdx.app.debug("InteractionTable#update", "Updating");
        free();

        titleLabel.setText(interaction.getTitle());
        descriptionLabel.setText(interaction.getDescription());

        // All available decisions get a button.
        for (Decision decision : interaction.getCurrentSituation().getDecisions()) {
            // Some decisions may be disabled due to the level/story flow.
            if (!decision.isAvailable()) {
                continue;
            }
            TextButton button = new TextButton(decision.getDescription(), app.getSkin());
            button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    interaction.handle(decision);
                }
            });

            optionTable.add(button).pad(Config.HUD_BUTTON_PADDING).row();
        }

        contentTable.add(titleLabel).row();
        contentTable.add(descriptionLabel).row();
        contentTable.add(optionTable);

        add(contentTable).expand().fill();
    }

    /**
     * Removes content of the interaction table and hides it from the HUD.
     */
    public void free() {
        Gdx.app.debug("InteractionTable#free", "Freeing");
        titleLabel.setText("");
        descriptionLabel.setText("");
        optionTable.clear();
        contentTable.clear();
        clear();
    }

    @Override
    public void initWidgets() {
        Texture hintTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(hintTexture);
        Drawable drawable = new TextureRegionDrawable(region);

        contentTable = new Table();
        contentTable.pad(Config.HUD_INNER_PADDING);
        contentTable.setBackground(drawable);
        titleLabel = new Label("", app.getSkin());
        descriptionLabel = new Label("", app.getSkin());
        optionTable = new Table();
    }

    @Override
    public void addWidgets() {}

    @Override
    public void setListeners() {}
}
