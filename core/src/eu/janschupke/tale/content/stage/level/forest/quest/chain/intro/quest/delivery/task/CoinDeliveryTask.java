package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Part of the coin delivery quest.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinDeliveryTask extends Task {
    public CoinDeliveryTask(final App app) {
        super(app, app.getLang().get("level.forest.quest.intro.delivery.task.delivery"));
    }
}
