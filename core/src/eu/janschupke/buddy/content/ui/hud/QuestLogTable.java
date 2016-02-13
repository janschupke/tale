package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Quest;
import eu.janschupke.buddy.framework.base.entity.container.QuestChain;
import eu.janschupke.buddy.framework.base.entity.container.QuestLog;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

import java.util.ArrayList;

/**
 * GUI table structure for the quest log.
 */
public class QuestLogTable extends UITable {
    private Label titleLabel;

    private ScrollPane questScrollPane;
    private Table questListTable;
    private Label activeQuestsLabel;
    private List activeQuestsList;
    private Label finishedQuestsLabel;
    private List finishedQuestsList;

    private ScrollPane descriptionScrollPane;
    private Table descriptionTable;
    private Label descriptionTitleLabel;
    private Label questDescriptionLabel;
    private java.util.List<Label> taskDescriptionLabels;

    private TextButton closeButton;

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
        // TODO: status values
        // TODO: quest titles
        QuestLog questLog = app.getGameState().getQuestLog();
        Array<String> activeQuests = new Array<>();
        Array<String> finishedQuests = new Array<>();

        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                Config.TaskStatus status = quest.getStatus();
                if (status == Config.TaskStatus.DONE) {
                    finishedQuests.add(quest.toString());
                    continue;
                }

                if (status == Config.TaskStatus.NEW) {
                    activeQuests.add(quest.toString());
                    continue;
                }
            }
        }

        activeQuestsList.setItems(activeQuests);
        finishedQuestsList.setItems(finishedQuests);

        setDefaultActiveQuest();
        updateIndicator();
    }

    private void setActiveQuest(Quest quest) {
        //
    }

    private void setDefaultActiveQuest() {
        //
    }

    private void updateIndicator() {
        try {
            Utility.getHud(app).getIndicatorTable().activateQuest();
        } catch (NoHudException e) {}
        catch (IndexOutOfBoundsException e) {
            // TODO
        }
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.quest.label.title"), app.getSkin());

        questListTable = new Table();
        questListTable.align(Align.top);
        questScrollPane = new ScrollPane(questListTable, app.getSkin());

        activeQuestsLabel = new Label(app.getLang().get("hud.quest.list.label.active"), app.getSkin());
        activeQuestsList = new List(app.getSkin());

        Array tmp = new Array();
        tmp.add("czx");
        tmp.add("czxvxc");
        activeQuestsList.setItems(tmp);

        finishedQuestsLabel = new Label(app.getLang().get("hud.quest.list.label.finished"), app.getSkin());
        finishedQuestsList = new List(app.getSkin());

        descriptionTable = new Table();
        descriptionTable.align(Align.top);
        descriptionScrollPane = new ScrollPane(descriptionTable, app.getSkin());

        descriptionTitleLabel = new Label("", app.getSkin());
        questDescriptionLabel = new Label("", app.getSkin());
        taskDescriptionLabels = new ArrayList<>();

        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        questListTable.add(activeQuestsLabel).pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(activeQuestsList).pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(finishedQuestsLabel).pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(finishedQuestsList).pad(Config.HUD_INNER_PADDING).row();

        descriptionTable.add(descriptionTitleLabel).pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(questDescriptionLabel).pad(Config.HUD_INNER_PADDING).row();
        for (Label l : taskDescriptionLabels) {
            descriptionTable.add(l).row();
        }

        add(titleLabel).row();
        add(questScrollPane).height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING);
        add(descriptionScrollPane).width(Config.HUD_LOG_DIMINISHED_WIDTH).height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).colspan(2);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    Utility.getHud(app).toggleQuestLog();
                } catch (NoHudException e) {
                }
            }
        });
        activeQuestsList.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.debug("QuestLogTable#changed", "List changed");
                // TODO
//                int index = activeQuestsList.getSelectedIndex();
//                Quest quest = app.getGameState().getQuestLog().getQuestChains().get(index).getActiveQuest();
//                setActiveQuest(quest);
            }
        });
    }
}
