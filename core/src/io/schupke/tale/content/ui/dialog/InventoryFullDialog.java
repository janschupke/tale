package io.schupke.tale.content.ui.dialog;

import io.schupke.tale.base.App;
import io.schupke.tale.base.ui.dialog.InfoDialog;

/**
 * Dialog that informs the player that an item cannot be picked up,
 * due to the inventory capacity.
 *
 * @author jan.schupke@gmail.com
 */
public class InventoryFullDialog extends InfoDialog {
    public InventoryFullDialog(final App app) {
        super(app, app.getLang().get("level.dialog.inventory.full.title"));
        label.setText(app.getLang().get("level.dialog.inventory.full.text"));
    }
}
