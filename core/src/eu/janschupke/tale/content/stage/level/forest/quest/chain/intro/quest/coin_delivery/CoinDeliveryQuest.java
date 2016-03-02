package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery;

import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task.CoinDeliveryTask;
import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task.CoinPickupTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.entity.container.quest.Quest;

/**
 * Part of the intro quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class CoinDeliveryQuest extends Quest {
    public CoinDeliveryQuest(final App app) {
        super(app, app.getLang().get("level.forest.quest.coin-delivery.name"),
                app.getLang().get("level.forest.quest.coin-delivery.description"));
        tasks.add(new CoinPickupTask(app));
        tasks.add(new CoinDeliveryTask(app));
    }
}
