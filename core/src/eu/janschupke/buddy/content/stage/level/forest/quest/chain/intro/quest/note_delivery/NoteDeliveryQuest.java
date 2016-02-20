package eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.note_delivery;

import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.note_delivery.task.NoteDeliveryTask;
import eu.janschupke.buddy.content.stage.level.forest.quest.chain.intro.quest.note_delivery.task.NotePickupTask;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.entity.container.Quest;

/**
 * Part of the intro quest chain.
 *
 * @author jan.schupke@gmail.com
 */
public class NoteDeliveryQuest extends Quest {
    public NoteDeliveryQuest(final App app) {
        super(app, app.getLang().get("level.forest.quest.note-delivery.name"),
                app.getLang().get("level.forest.quest.note-delivery.description"));
        tasks.add(new NotePickupTask(app));
        tasks.add(new NoteDeliveryTask(app));
    }
}
