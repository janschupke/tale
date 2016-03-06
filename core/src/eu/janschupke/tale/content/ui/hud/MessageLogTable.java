package eu.janschupke.tale.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.content.config.Config;
import eu.janschupke.tale.framework.App;
import eu.janschupke.tale.framework.exception.NoHudException;
import eu.janschupke.tale.framework.ui.table.UiTable;

import java.util.Observable;
import java.util.Observer;

/**
 * GUI table structure for message log.
 *
 * @author jan.schupke@gmail.com
 */
public class MessageLogTable extends UiTable implements Observer {
    private Label titleLabel;
    private Table messageTable;
    private Label messageArea;
    private ScrollPane messageScrollPane;
    private TextButton closeButton;

    public MessageLogTable(final App app) {
        super(app);
        setBackground(app.getResourceManager().getTextureHandler().getHudBackgroundDrawable());
        align(Align.top);
        pad(Config.HUD_INNER_PADDING);

        initWidgets();
        addWidgets();
        setListeners();
    }

    @Override
    public void initWidgets() {
        titleLabel = new Label(app.getLang().get("hud.message.label.title"), app.getSkin());
        messageTable = new Table();
        messageTable.align(Align.topLeft);
        messageArea = new Label("", app.getSkin());
        messageScrollPane = new ScrollPane(messageTable, app.getSkin());
        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        messageTable.add(messageArea);
        add(messageScrollPane).width(Config.HUD_LOG_WIDTH).height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    app.getHud().toggleEventLog();
                } catch (NoHudException e) {
                    Gdx.app.debug("MessageLogTable#setListeners", "Could not get HUD instance");
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        String log = o.toString();
        messageArea.setText(log);
        messageScrollPane.layout();

        // If dialogs are disabled, indicator about the new event is displayed on the screen.
        if (!app.getSettingsManager().getConfig().isEnableDialogs()) {
            app.getGameState().getGlobalLevelState().setNewEvent(true);
        }
    }
}
