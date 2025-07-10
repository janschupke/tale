package io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task.LumberDeliveryTask;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task.LumberPickupTask;

/**
 * Jack's lumber retrieval quest.
 *
 * @author jan.schupke@gmail.com
 */
public class LumberQuest extends Quest {
    public LumberQuest(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.jack.lumber.name"),
                app.getLang().get("level.outskirts.quest.jack.lumber.description"));
        tasks.add(new LumberPickupTask(app));
        tasks.add(new LumberDeliveryTask(app));
    }
}
