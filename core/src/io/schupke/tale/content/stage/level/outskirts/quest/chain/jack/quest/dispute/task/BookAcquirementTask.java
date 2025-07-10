package io.schupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task;

import io.schupke.tale.base.App;
import io.schupke.tale.base.container.quest.Task;

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
