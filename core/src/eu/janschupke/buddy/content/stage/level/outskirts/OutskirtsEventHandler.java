package eu.janschupke.buddy.content.stage.level.outskirts;

import eu.janschupke.buddy.content.stage.level.outskirts.event.*;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.event.LevelEventHandler;

/**
 * Event handler for the outskirts level.
 *
 * @author jan.schupke@gmail.com
 */
public class OutskirtsEventHandler extends LevelEventHandler {
    private CaveEntranceEvent caveEntranceEvent;
    private CaveInteractionEvent caveInteractionEvent;
    private CroneInteractionEvent croneInteractionEvent;
    private JackInteractionEvent jackInteractionEvent;
    private LumberInteractionEvent lumberInteractionEvent;
    private LumberPickupEvent lumberPickupEvent;
    private VarpunenInteractionEvent varpunenInteractionEvent;
    private VarpunenPickupEvent varpunenPickupEvent;

    public OutskirtsEventHandler(final App app) {
        super(app);

        caveEntranceEvent = new CaveEntranceEvent(app);
        caveInteractionEvent = new CaveInteractionEvent(app);
        croneInteractionEvent = new CroneInteractionEvent(app);
        jackInteractionEvent = new JackInteractionEvent(app);
        lumberInteractionEvent = new LumberInteractionEvent(app);
        lumberPickupEvent = new LumberPickupEvent(app);
        varpunenInteractionEvent = new VarpunenInteractionEvent(app);
        varpunenPickupEvent = new VarpunenPickupEvent(app);
    }

    public CaveEntranceEvent getCaveEntranceEvent() {
        return caveEntranceEvent;
    }

    public CaveInteractionEvent getCaveInteractionEvent() {
        return caveInteractionEvent;
    }

    public CroneInteractionEvent getCroneInteractionEvent() {
        return croneInteractionEvent;
    }

    public JackInteractionEvent getJackInteractionEvent() {
        return jackInteractionEvent;
    }

    public LumberInteractionEvent getLumberInteractionEvent() {
        return lumberInteractionEvent;
    }

    public LumberPickupEvent getLumberPickupEvent() {
        return lumberPickupEvent;
    }

    public VarpunenInteractionEvent getVarpunenInteractionEvent() {
        return varpunenInteractionEvent;
    }

    public VarpunenPickupEvent getVarpunenPickupEvent() {
        return varpunenPickupEvent;
    }
}
