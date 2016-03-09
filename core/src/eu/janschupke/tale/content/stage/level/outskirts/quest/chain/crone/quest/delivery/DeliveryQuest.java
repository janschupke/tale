package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery;

import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.task.NoteDeliveryTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

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
