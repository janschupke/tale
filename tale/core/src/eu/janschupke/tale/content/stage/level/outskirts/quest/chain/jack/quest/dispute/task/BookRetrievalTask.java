package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.jack.quest.dispute.task;

import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.container.quest.Task;

/**
 * Jack's dispute book retrieval task.
 *
 * @author jan.schupke@gmail.com
 */
public class BookRetrievalTask extends Task {
    public BookRetrievalTask(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.jack.dispute.task.retrieval"));
    }
}
