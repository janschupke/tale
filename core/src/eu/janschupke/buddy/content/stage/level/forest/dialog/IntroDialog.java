package eu.janschupke.buddy.content.stage.level.forest.dialog;

import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.ui.dialog.InfoDialog;

/**
 * Introduction dialog.
 */
public class IntroDialog extends InfoDialog {
    public IntroDialog(final App app) {
        super(app, app.getLang().get("level.forest.dialog.intro.title"));
        label.setText(app.getLang().get("level.forest.event.intro.text"));
    }
}
