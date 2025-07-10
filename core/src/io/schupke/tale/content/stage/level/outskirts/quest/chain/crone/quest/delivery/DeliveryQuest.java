package io.schupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.task.NoteDeliveryTask;

/**
 * Varpunen note delivery quest.
 *
 * @author jan.schupke@gmail.com
 */
public class DeliveryQuest extends Quest {
    public DeliveryQuest(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.crone.delivery.name"),
                app.getLang().get("level.outskirts.quest.crone.delivery.description"));
        tasks.add(new NoteDeliveryTask(app));
    }
}
