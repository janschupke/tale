package eu.janschupke.tale.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;
import eu.janschupke.tale.framework.container.quest.QuestChain;
import eu.janschupke.tale.framework.container.quest.QuestLog;
import eu.janschupke.tale.framework.container.quest.Task;
import eu.janschupke.tale.framework.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.ui.table.UiTable;

import java.util.Observable;
import java.util.Observer;

/**
 * GUI table structure for the quest log.
 *
 * @author jan.schupke@gmail.com
 */
public class QuestLogTable extends UiTable implements Observer {
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
    private Label taskTitleLabel;
    private Label taskDescriptionLabel;

    private TextButton closeButton;

    private float width = Gdx.graphics.getWidth() * 0.5f;
    private float height = Gdx.graphics.getHeight() * 0.5f;

    // TODO: use
    private Quest selectedQuest;

    public QuestLogTable(final App app) {
        super(app);
        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
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
    @Override
    public void update(Observable o, Object arg) {
        Gdx.app.debug("QuestLogTable#update", "Updating quest log UI");
        QuestLog questLog = app.getGameState().getQuestLog();
        Array<String> activeQuests = new Array<>();
        Array<String> finishedQuests = new Array<>();

        // Quest list updating.
        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                TaskStatus status = quest.getStatus();

                // The one active quest from the chain goes to the list of active quests.
                if (status == TaskStatus.ACTIVE) {
                    activeQuests.add(quest.toString());
                    continue;
                }

                // All finished quests go to the finished list.
                if (status == TaskStatus.DONE) {
                    finishedQuests.add(quest.toString());
                }
            }
        }

        activeQuestsList.setItems(activeQuests);
        finishedQuestsList.setItems(finishedQuests);

        app.getGameState().getGlobalLevelState().setNewQuest(true);
        refreshActiveQuest();
    }

    /**
     * Sets the provided quest as currently active in the quest log.
     *
     * @param quest Quest to be displayed.
     */
    private void setActiveQuest(Quest quest) {
        descriptionTitleLabel.setText(quest.getName());
        if (quest.getStatus().equals(TaskStatus.DONE)) {
            descriptionTitleLabel.setText(descriptionTitleLabel.getText() + " " + app.getLang().get("hud.quest.status.done"));
        }

        questDescriptionLabel.setText(quest.getDescription());
        taskTitleLabel.setText(app.getLang().get("hud.quest.description.label.tasks"));

        // Tasks are printed out as text.
        StringBuilder taskDescriptions = new StringBuilder();
        for (Task task : quest.getTasks()) {
            if (task.getStatus().equals(TaskStatus.DONE)) {
                Gdx.app.debug("QuestLogTable#setActiveQuest", "Is done");
                taskDescriptions.append(app.getLang().get("hud.quest.status.done"));
                taskDescriptions.append(" ");
            }

            taskDescriptions.append(task.getDescription());
            taskDescriptions.append("\n");
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
     * TODO
     */
    private void clearActiveQuest() {
        descriptionTitleLabel.setText(app.getLang().get("hud.quest.label.empty"));
        questDescriptionLabel.setText("");
        taskTitleLabel.setText("");
    }

    /**
     * TODO
     */
    private void refreshActiveQuest() {
        clearActiveQuest();
        setDefaultActiveQuest();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.quest.label.title"), app.getSkin());

        questListTable = new Table();
        questListTable.align(Align.top);
        questScrollPane = new ScrollPane(questListTable, app.getSkin());

        activeQuestsLabel = new Label("", app.getSkin());
        activeQuestsList = new List(app.getSkin());

        finishedQuestsLabel = new Label("", app.getSkin());
        finishedQuestsList = new List(app.getSkin());

        descriptionTable = new Table();
        descriptionTable.align(Align.top);
        descriptionScrollPane = new ScrollPane(descriptionTable, app.getSkin());
        descriptionScrollPane.setScrollingDisabled(true, false);

        descriptionTitleLabel = new Label(app.getLang().get("hud.quest.label.empty"), app.getSkin());

        questDescriptionLabel = new Label("", app.getSkin());
        questDescriptionLabel.setWrap(true);
        questDescriptionLabel.setWidth(width - Config.HUD_INNER_PADDING * 2);

        taskTitleLabel = new Label("", app.getSkin());

        taskDescriptionLabel = new Label("", app.getSkin());
        taskDescriptionLabel.setWrap(true);
        taskDescriptionLabel.setWidth(width - Config.HUD_INNER_PADDING * 2);

        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        questListTable.add(activeQuestsLabel).left().pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(activeQuestsList).left().pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(finishedQuestsLabel).left().pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(finishedQuestsList).left().pad(Config.HUD_INNER_PADDING).row();

        descriptionTable.add(descriptionTitleLabel).left().pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(questDescriptionLabel).width(width - Config.HUD_INNER_PADDING * 2)
                .pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(taskTitleLabel).left().pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(taskDescriptionLabel).width(width - Config.HUD_INNER_PADDING * 2)
                .pad(Config.HUD_INNER_PADDING);

        add(titleLabel).colspan(2).row();
        add(questScrollPane).height(height).fill().pad(Config.HUD_INNER_PADDING);
        add(descriptionScrollPane).width(width)
                .height(height).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).width(Config.HUD_LOG_BUTTON_WIDTH).colspan(2);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    app.getHud().toggleQuestLog();
                } catch (NoHudException e) {
                    Gdx.app.debug("QuestLogTable#closeButton#clicked", "Could not get HUD instance");
                }
            }
        });

        activeQuestsList.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.debug("QuestLogTable#activeQuestsList#changed", "List changed");

                // Title should not be displayed if no relevant quests exist.
                if (activeQuestsList.getItems().size == 0) {
                    activeQuestsLabel.setText("");
                } else {
                    activeQuestsLabel.setText(app.getLang().get("hud.quest.list.label.active"));
                }

                // TODO: updating
            }
        });

        finishedQuestsList.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.debug("QuestLogTable#finishedQuestsList#changed", "List changed");

                // Title should not be displayed if no relevant quests exist.
                if (finishedQuestsList.getItems().size == 0) {
                    finishedQuestsLabel.setText("");
                } else {
                    finishedQuestsLabel.setText(app.getLang().get("hud.quest.list.label.finished"));
                }

                // TODO: updating
            }
        });
    }
}
