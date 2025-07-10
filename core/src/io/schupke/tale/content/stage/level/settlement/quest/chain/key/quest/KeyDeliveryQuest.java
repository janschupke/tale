package io.schupke.tale.content.stage.level.settlement.quest.chain.key.quest;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.settlement.quest.chain.key.quest.task.KeyDeliveryTask;

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
