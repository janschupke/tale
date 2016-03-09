package eu.janschupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate;

import eu.janschupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate.task.FindOutTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

/**
 * Corpsec investigation quest.
 *
 * @author jan.schupke@gmail.com
 */
public class InvestigateQuest extends Quest {
    public InvestigateQuest(final App app) {
        super(app, app.getLang().get("level.cave.quest.corpsec.investigate.name"),
                app.getLang().get("level.cave.quest.corpsec.investigate.description"));
        tasks.add(new FindOutTask(app));
    }
}
