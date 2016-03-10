package eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.quest;

import eu.janschupke.tale.content.stage.level.settlement.quest.chain.key.quest.task.KeyDeliveryTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

/**
 * Settlement key delivery quest.
 *
 * @author jan.schupke@gmail.com
 */
public class KeyDeliveryQuest extends Quest {
    public KeyDeliveryQuest(final App app) {
        super(app, app.getLang().get("level.settlement.quest.key.name"),
                app.getLang().get("level.settlement.quest.key.description"));
        tasks.add(new KeyDeliveryTask(app));
    }
}
