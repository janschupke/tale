package eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery;

import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task.CoinDeliveryTask;
import eu.janschupke.tale.content.stage.level.forest.quest.chain.intro.quest.delivery.task.CoinPickupTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

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
