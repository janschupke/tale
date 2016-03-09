package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber;

import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task.LumberDeliveryTask;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.lumber.task.LumberPickupTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

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
