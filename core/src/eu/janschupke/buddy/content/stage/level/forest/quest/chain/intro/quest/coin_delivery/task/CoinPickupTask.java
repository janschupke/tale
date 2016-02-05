package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Task;

/**
 * Part of the coin delivary quest.
 */
public class CoinPickupTask extends Task {
    public CoinPickupTask(final App app) {
        super(app, app.getLang().get("level.forest.quest.coin-delivery.task.pickup"));
    }
}
