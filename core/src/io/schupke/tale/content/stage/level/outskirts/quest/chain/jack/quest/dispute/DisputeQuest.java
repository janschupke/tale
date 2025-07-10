package io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Quest;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.BookAcquirementTask;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.BookRetrievalTask;
import io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.CaveDiscoveryTask;

/**
 * Jack's dispute quest.
 *
 * @author jan.schupke@gmail.com
 */
public class DisputeQuest extends Quest {
    public DisputeQuest(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.jack.dispute.name"),
                app.getLang().get("level.outskirts.quest.jack.dispute.description"));
        tasks.add(new CaveDiscoveryTask(app));
        tasks.add(new BookAcquirementTask(app));
        tasks.add(new BookRetrievalTask(app));
    }
}
