package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Quest;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.task.NoteDeliveryTask;

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
