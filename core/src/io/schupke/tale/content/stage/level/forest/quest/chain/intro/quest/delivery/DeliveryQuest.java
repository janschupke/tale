package io.schupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task.CoinDeliveryTask;
import io.schupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task.CoinPickupTask;

/**
 * Part of the intro quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class DeliveryQuest extends Quest {
    public DeliveryQuest(final App app) {
        super(app, app.getLang().get("level.forest.quest.intro.delivery.name"),
                app.getLang().get("level.forest.quest.intro.delivery.description"));
        tasks.add(new CoinPickupTask(app));
        tasks.add(new CoinDeliveryTask(app));
    }
}
