package eu.janschupke.tale.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.interaction.InteractionSwitch;
import eu.janschupke.tale.framework.screen.GameScreen;
import eu.janschupke.tale.framework.ui.table.UiTable;

import java.util.Observable;
import java.util.Observer;

/**
 * Transparent table in the middle of the screen,
 * showing context hints.
 *
 * @author jan.schupke@gmail.com
 */
public class HintTable extends UiTable implements Observer {
    private Label hintLabel;
    private Table messageTable;

    public HintTable(final App app) {
        super(app);

        align(Align.center);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        messageTable = new Table();
        messageTable.setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        hintLabel = new Label("", app.getSkin());
    }

    @Override
    public void addWidgets() {
        messageTable.add(hintLabel);
    }

    @Override
    public void setListeners() {
        hintLabel.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Clicking the hint will trigger an interaction, is any is available.
                if (!hintLabel.getText().toString().isEmpty() && !((GameScreen) app.getScreen()).isPaused()) {
                    if (InteractionSwitch.isInteractionPossible()) {
                        InteractionSwitch.getInteractionEvent().trigger();
                    }
                }
            }
        });
    }


    @Override
    public void update(Observable o, Object arg) {
        String hint = app.getGameState().getGlobalLevelState().getCurrentHint();

        if (hint == null || hint.isEmpty()) {
            hintLabel.setText("");
            removeActor(messageTable);
            return;
        }

        hintLabel.setText(hint);
        add(messageTable);
    }

    public String getHint() {
        return hintLabel.getText().toString();
    }
}
