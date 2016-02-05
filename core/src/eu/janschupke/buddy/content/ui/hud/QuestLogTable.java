package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Quest;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.entity.container.QuestLog;
import eu.janschupke.buddy.framework.base.entity.container.Task;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;

/**
 * GUI table structure for the quest log.
 */
public class QuestLogTable extends UITable {
    private Label titleLabel;
    private TextArea questArea;
    private ScrollPane questScrollPane;

    public QuestLogTable(final App app) {
        super(app);

        Texture texture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));
        TextureRegion region = new TextureRegion(texture);
        Drawable drawable = new TextureRegionDrawable(region);

        setBackground(drawable);
        align(Align.top);
        pad(Config.HUD_INNER_PADDING);

        initWidgets();
        addWidgets();
        setListeners();
    }

    /**
     * Redraws quest entries in the table
     * according to the current model state.
     */
    public void update() {
        // TODO
        StringBuilder result = new StringBuilder();
        QuestLog questLog = app.getCharacter().getQuestLog();

        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                result.append(quest.toString());
                result.append(System.getProperty("line.separator"));

                for (Task task : quest.getTasks()) {
                    result.append(task.toString());
                    result.append(System.getProperty("line.separator"));
                }
            }
        }

        questArea.setText(result.toString());
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.quest.label.title"), app.getSkin());
        questArea = new TextArea("", app.getSkin());
        questArea.setDisabled(true);
        questScrollPane = new ScrollPane(questArea, app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        add(questScrollPane).height(Config.HUD_BOTTOM_PANE_HEIGHT).expand().fill().pad(Config.HUD_INNER_PADDING);
    }

    @Override
    public void setListeners() {

    }
}
