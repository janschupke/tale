package eu.janschupke.tale.content.stage.level.cave.quest.chain.ville.quest.message.task;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Task;

/**
 * Task to deliver message from Ville.
 *
 * @author jan.schupke@gmail.com
 */
public class MessageDeliveryTask extends Task {
    public MessageDeliveryTask(final App app) {
        super(app, app.getLang().get("level.cave.quest.ville.message.task.delivery"));
    }
}
