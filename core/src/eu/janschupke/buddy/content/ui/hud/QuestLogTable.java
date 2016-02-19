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
import eu.janschupke.buddy.framework.base.entity.container.Task;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

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
    private Label taskDescriptionLabel;

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
        QuestLog questLog = app.getGameState().getQuestLog();
        Array<String> activeQuests = new Array<>();
        Array<String> finishedQuests = new Array<>();

        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                Config.TaskStatus status = quest.getStatus();

                if (status == Config.TaskStatus.ACTIVE) {
                    activeQuests.add(quest.toString());
                    continue;
                }

                if (status == Config.TaskStatus.DONE) {
                    finishedQuests.add(quest.toString());
                    continue;
                }
            }
        }

        // TODO: show all done quests, even within single chain.

        activeQuestsList.setItems(activeQuests);
        finishedQuestsList.setItems(finishedQuests);

        setDefaultActiveQuest();
        updateIndicator();
    }

    /**
     * Sets the provided quest as currently active in the quest log.
     * @param quest Quest to be displayed.
     */
    private void setActiveQuest(Quest quest) {
        descriptionTitleLabel.setText(quest.getName());
        questDescriptionLabel.setText(quest.getDescription());

        // Tasks are printed out as text.
        StringBuilder taskDescriptions = new StringBuilder();
        for (Task task : quest.getTasks()) {
            taskDescriptions.append(task.getDescription() + "\n");
        }

        taskDescriptionLabel.setText(taskDescriptions.toString());
    }

    /**
     * Sets the first available quest as active,
     * so that there is not an empty content table displayed.
     */
    private void setDefaultActiveQuest() {
        QuestLog questLog = app.getGameState().getQuestLog();

        // Default state so that the description area is not empty.
        if (!questLog.isEmpty() && descriptionTitleLabel.getText().toString()
                .equals(app.getLang().get("hud.quest.label.empty"))) {
            Gdx.app.debug("QuestLogTable#setDefaultActiveItem", "Setting default selection");
            setActiveQuest(questLog.getQuestChains().get(0).getActiveQuest());
        }
    }

    /**
     * Updates the bottomLeft HUD indicator
     */
    private void updateIndicator() {
        try {
            Utility.getHud(app).getIndicatorTable().activateQuest();
        } catch (NoHudException e) {}
        catch (IndexOutOfBoundsException e) {
            Gdx.app.log("QuestLogTable#updateIndicator", "Out of bounds exception.");
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

        finishedQuestsLabel = new Label(app.getLang().get("hud.quest.list.label.finished"), app.getSkin());
        finishedQuestsList = new List(app.getSkin());

        descriptionTable = new Table();
        descriptionTable.align(Align.top);
        descriptionScrollPane = new ScrollPane(descriptionTable, app.getSkin());

        descriptionTitleLabel = new Label(app.getLang().get("hud.quest.label.empty"), app.getSkin());
        questDescriptionLabel = new Label("", app.getSkin());
        taskDescriptionLabel = new Label("", app.getSkin());

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
        descriptionTable.add(taskDescriptionLabel).pad(Config.HUD_INNER_PADDING);

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
                int index = activeQuestsList.getSelectedIndex();
                Quest quest = app.getGameState().getQuestLog().getQuestChains().get(index).getActiveQuest();
                setActiveQuest(quest);
            }
        });
    }
}
