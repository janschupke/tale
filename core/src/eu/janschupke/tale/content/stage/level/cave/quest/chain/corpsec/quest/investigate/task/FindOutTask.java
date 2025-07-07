package eu.janschupke.tale.content.stage.level.cave.quest.chain.corpsec.quest.investigate.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Corpsec investigation task.
 *
 * @author jan.schupke@gmail.com
 */
public class FindOutTask extends Task {
    public FindOutTask(final App app) {
        super(app, app.getLang().get("level.cave.quest.corpsec.investigate.task.find-out"));
    }
}
