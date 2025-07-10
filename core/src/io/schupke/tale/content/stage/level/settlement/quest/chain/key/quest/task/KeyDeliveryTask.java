package io.schupke.tale.content.stage.level.settlement.quest.chain.key.quest.task;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Task;

/**
 * Settlement key delivery task.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyDeliveryTask extends Task {
    public KeyDeliveryTask(final App app) {
        super(app, app.getLang().get("level.settlement.quest.key.task.delivery"));
    }
}
