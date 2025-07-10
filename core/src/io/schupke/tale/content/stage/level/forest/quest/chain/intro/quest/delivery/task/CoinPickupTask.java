package io.schupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Task;

/**
 * Part of the coin delivary quest.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinPickupTask extends Task {
    public CoinPickupTask(final App app) {
        super(app, app.getLang().get("level.forest.quest.intro.delivery.task.pickup"));
    }
}
