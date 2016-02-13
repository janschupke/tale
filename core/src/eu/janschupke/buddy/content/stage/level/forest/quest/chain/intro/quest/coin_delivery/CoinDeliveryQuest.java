package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery;

import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task.CoinDeliveryTask;
import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.coin_delivery.task.CoinPickupTask;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Quest;

/**
 * Part of the intro quest chain.
 */
public class CoinDeliveryQuest extends Quest {
    public CoinDeliveryQuest(final App app) {
        super(app, app.getLang().get("level.forest.quest.coin-delivery.name"),
                app.getLang().get("level.forest.quest.coin-delivery.description"));
        tasks.add(new CoinPickupTask(app));
        tasks.add(new CoinDeliveryTask(app));
    }
}
