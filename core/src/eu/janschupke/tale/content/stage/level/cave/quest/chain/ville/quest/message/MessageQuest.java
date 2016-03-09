package eu.janschupke.tale.content.stage.level.cave.quest.chain.ville.quest.message;

import eu.janschupke.tale.content.stage.level.cave.quest.chain.ville.quest.message.task.MessageDeliveryTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

/**
 * Quest to deliver the message from Ville.
 *
 * @author jan.schupke@gmail.com
 */
public class MessageQuest extends Quest {
    public MessageQuest(final App app) {
        super(app, app.getLang().get("level.cave.quest.ville.message.name"),
                app.getLang().get("level.cave.quest.ville.message.description"));
        tasks.add(new MessageDeliveryTask(app));
    }
}
