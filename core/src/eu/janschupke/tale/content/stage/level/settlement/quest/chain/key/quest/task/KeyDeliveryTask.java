package eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.quest.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Settlement key delivery task.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyDeliveryTask extends Task {
    public KeyDeliveryTask(final App app) {
        super(app, app.getLang().get("level.settlement.quest.key.task.delivery"));
    }
}
