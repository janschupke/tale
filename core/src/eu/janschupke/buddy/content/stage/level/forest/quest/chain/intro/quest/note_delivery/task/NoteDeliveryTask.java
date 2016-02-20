package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.note_delivery.task;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Task;

/**
 * Part of the note delivery quest.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteDeliveryTask extends Task {
    public NoteDeliveryTask(final App app) {
        super(app, app.getLang().get("level.forest.quest.note-delivery.task.delivery"));
    }
}
