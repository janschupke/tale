package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.quest.Task;

/**
 * Part of the coin delivery quest.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinDeliveryTask extends Task {
    public CoinDeliveryTask(final App app) {
        super(app, app.getLang().get("level.forest.quest.coin-delivery.task.delivery"));
    }
}
