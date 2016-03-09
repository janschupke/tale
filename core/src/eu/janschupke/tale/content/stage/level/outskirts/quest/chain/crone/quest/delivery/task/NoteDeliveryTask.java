package eu.janschupke.tale.content.stage.level.outskirts.quest.chain.crone.quest.delivery.task;

import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.container.quest.Task;

/**
 * Varpunen note delivery task.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteDeliveryTask extends Task {
    public NoteDeliveryTask(final App app) {
        super(app, app.getLang().get("level.outskirts.quest.crone.note.task.delivery"));
    }
}
