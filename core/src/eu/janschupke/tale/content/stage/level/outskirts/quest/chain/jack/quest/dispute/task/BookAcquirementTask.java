package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Jack's dispute book acquirement task.
 *
 * @author jan.schupke@gmail.com
 */
public class BookAcquirementTask extends Task {
    public BookAcquirementTask(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.jack.dispute.task.acquire"));
    }
}
