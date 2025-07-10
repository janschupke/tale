package io.schupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate.task.FindOutTask;

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
