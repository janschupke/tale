package io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Task;

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
