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
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.quest.enumeration.TaskStatus;
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
    private Label taskDescriptionLabel;

    private TextButton closeButton;

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
        QuestLog questLog = app.getGameState().getQuestLog();
        Array<String> activeQuests = new Array<>();
        Array<String> finishedQuests = new Array<>();

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
        setDefaultActiveQuest();
    }

    /**
     * Sets the provided quest as currently active in the quest log.
     *
     * @param quest Quest to be displayed.
     */
    private void setActiveQuest(Quest quest) {
        descriptionTitleLabel.setText(quest.getName());
        questDescriptionLabel.setText(quest.getDescription());

        // Tasks are printed out as text.
        StringBuilder taskDescriptions = new StringBuilder();
        for (Task task : quest.getTasks()) {
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
        add(descriptionScrollPane).width(Config.HUD_LOG_DIMINISHED_WIDTH)
                .height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).colspan(2);
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
                Gdx.app.debug("QuestLogTable#changed", "List changed");
                int index = activeQuestsList.getSelectedIndex();
                Quest quest = app.getGameState().getQuestLog().getQuestChains().get(index).getActiveQuest();
                setActiveQuest(quest);
            }
        });
    }
}
