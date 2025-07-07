package eu.janschupke.tale.content.ui.hud.tab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.tale.base.App;
import eu.janschupke.tale.base.exception.NoHudException;
import eu.janschupke.tale.base.ui.table.UiTable;
import eu.janschupke.tale.content.config.Config;

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

    private float width = Gdx.graphics.getWidth() * 0.6f;
    private float height = Gdx.graphics.getHeight() * 0.5f;

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
        messageArea = new Label(app.getLang().get("hud.message.label.empty"), app.getSkin());
        messageArea.setWrap(true);
        messageArea.setWidth(width - Config.HUD_INNER_PADDING * 2);
        messageScrollPane = new ScrollPane(messageTable, app.getSkin());
        messageScrollPane.setScrollingDisabled(true, false);
        messageScrollPane.setFadeScrollBars(false);
        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        messageTable.add(messageArea).width(width - Config.HUD_INNER_PADDING * 2).pad(Config.HUD_INNER_PADDING);
        add(messageScrollPane).width(width).height(height).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton).width(Config.HUD_LOG_BUTTON_WIDTH);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    app.getHud().toggleEventLog();
                    app.getResourceManager().getSoundHandler()
                            .playSound(app.getResourceManager().getSoundHandler().getHeavyButtonSound());
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
        messageScrollPane.layout();
        messageScrollPane.setScrollY(messageArea.getHeight());

        // If dialogs are disabled, indicator about the new event is displayed on the screen.
        if (!app.getSettingsManager().getConfig().isEnableDialogs()) {
            app.getGameState().getGlobalLevelState().setNewEvent(true);
        }

        app.getResourceManager().getSoundHandler()
                .playSound(app.getResourceManager().getSoundHandler().getEventSound());
    }
}
