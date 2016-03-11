package eu.janschupke.tale.content.ui.hud;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.ui.table.RootTable;
import eu.janschupke.tale.content.config.Config;

/**
 * Outro text and exit button.
 *
 * @author jan.schupke@gmail.com
 */
public class OutroHud extends RootTable {
    private Table outroTable;
    private Label outroLabel;
    private TextButton outroButton;

    public OutroHud(App app) {
        super(app);
        align(Align.top);
        padTop(Config.UI_INDENT_TOP);
        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        outroTable = new Table();
        outroTable.align(Align.top | Align.center);
        outroLabel = new Label(app.getLang().get("level.outro.text"), app.getSkin());
        outroButton = new TextButton(app.getLang().get("level.outro.exit"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        outroTable.add(outroLabel).pad(Config.HUD_INNER_PADDING).row();
        outroTable.add(outroButton).width(Config.HUD_LOG_BUTTON_WIDTH);
        add(outroTable).top().center();
    }

    @Override
    public void setListeners() {
        outroButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.getEventHandler().endGame();
            }
        });
    }
}
