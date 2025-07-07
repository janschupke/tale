package eu.janschupke.tale.content.ui.hud.tab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Quest;
import eu.janschupke.tale.base.container.quest.QuestChain;
import eu.janschupke.tale.base.container.quest.QuestLog;
import eu.janschupke.tale.base.container.quest.Task;
import eu.janschupke.tale.base.container.quest.enumeration.TaskStatus;
import eu.janschupke.tale.base.exception.NoHudException;
import eu.janschupke.tale.base.ui.table.UiTable;
import eu.janschupke.tale.content.config.Config;

import java.util.ArrayList;
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
    private Label questsLabel;
    private List questsList;

    private ScrollPane descriptionScrollPane;
    private Table descriptionTable;
    private Label descriptionTitleLabel;
    private Label questDescriptionLabel;
    private Label taskTitleLabel;
    private Label taskDescriptionLabel;

    private TextButton closeButton;

    private float width = Gdx.graphics.getWidth() * 0.5f;
    private float height = Gdx.graphics.getHeight() * 0.5f;

    private java.util.List<Quest> questReferences;

    public QuestLogTable(final App app) {
        super(app);
        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        align(Align.top);
        pad(Config.HUD_INNER_PADDING);

        questReferences = new ArrayList<>();

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
        Array<String> quests = new Array<>();

        questReferences.clear();

        // Quest list updating - active quests first.
        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                TaskStatus status = quest.getStatus();

                if (status == TaskStatus.ACTIVE) {
                    quests.add(quest.toString());
                    questReferences.add(quest);
                }
            }
        }

        // Quest list updating - finished quests after.
        for (QuestChain chain : questLog.getQuestChains()) {
            for (Quest quest : chain.getQuests()) {
                TaskStatus status = quest.getStatus();

                if (status == TaskStatus.DONE) {
                    String questLabel = app.getLang().get("hud.quest.status.done");
                    questLabel += " " + quest.toString();
                    quests.add(questLabel);
                    questReferences.add(quest);
                }
            }
        }

        questsList.setItems(quests);

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
     * Clears the information strings about the active quest.
     */
    private void clearActiveQuest() {
        descriptionTitleLabel.setText(app.getLang().get("hud.quest.label.empty"));
        questDescriptionLabel.setText("");
        taskTitleLabel.setText("");
    }

    /**
     * Refreshes active quest according to the selected list item.
     */
    private void refreshActiveQuest() {
        if (questsList.getSelectedIndex() == -1) {
            clearActiveQuest();
            setDefaultActiveQuest();
        } else {
            clearActiveQuest();
            int index = questsList.getSelectedIndex();
            setActiveQuest(questReferences.get(index));
        }
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.quest.label.title"), app.getSkin());

        questListTable = new Table();
        questListTable.align(Align.top);
        questScrollPane = new ScrollPane(questListTable, app.getSkin());

        questsLabel = new Label(app.getLang().get("hud.quest.list.label"), app.getSkin());
        questsList = new List(app.getSkin());

        descriptionTable = new Table();
        descriptionTable.align(Align.top);
        descriptionScrollPane = new ScrollPane(descriptionTable, app.getSkin());
        descriptionScrollPane.setScrollingDisabled(true, false);
        descriptionScrollPane.setFadeScrollBars(false);

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
        questListTable.add(questsLabel).left().pad(Config.HUD_INNER_PADDING).row();
        questListTable.add(questsList).left().pad(Config.HUD_INNER_PADDING).row();

        descriptionTable.add(descriptionTitleLabel).left().pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(questDescriptionLabel).width(width - Config.HUD_INNER_PADDING * 2)
                .pad(Config.HUD_INNER_PADDING).row();
        descriptionTable.add(taskTitleLabel).left().pad(Config.HUD_INNER_PADDING).padBottom(0).row();
        descriptionTable.add(taskDescriptionLabel).width(width - Config.HUD_INNER_PADDING * 2)
                .pad(Config.HUD_INNER_PADDING).padTop(0);

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
                    app.getResourceManager().getSoundHandler()
                            .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
                } catch (NoHudException e) {
                    Gdx.app.debug("QuestLogTable#closeButton#clicked", "Could not get HUD instance");
                }
            }
        });

        questsList.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.debug("QuestLogTable#questsList#changed", "List changed");

                Quest quest = questReferences.get(questsList.getSelectedIndex());
                setActiveQuest(quest);
                app.getResourceManager().getSoundHandler()
                        .playSound(app.getResourceManager().getSoundHandler().getLightButtonSound());
            }
        });
    }
}
