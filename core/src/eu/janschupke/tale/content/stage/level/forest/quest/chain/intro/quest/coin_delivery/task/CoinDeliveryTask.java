package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Task;

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
