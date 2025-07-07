package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Lumber pickup task.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberPickupTask extends Task {
    public LumberPickupTask(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.jack.lumber.task.pickup"));
    }
}
