package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute;

import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.BookAcquirementTask;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.BookRetrievalTask;
import eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task.CaveDiscoveryTask;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Quest;

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
