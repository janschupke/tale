package eu.janschupke.buddy.content.ui.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import eu.janschupke.buddy.framework.App;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.ui.table.UITable;
import eu.janschupke.buddy.framework.config.Config;
import eu.janschupke.buddy.framework.util.Utility;

import java.util.Observable;
import java.util.Observer;

/**
 * GUI table structure for event log.
 * @author jan.schupke@gmail.com
 */
public class EventLogTable extends UITable implements Observer {
    private Label titleLabel;
    private Table eventTable;
    private Label eventArea;
    private ScrollPane eventScrollPane;
    private TextButton closeButton;

    public EventLogTable(final App app) {
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
        titleLabel = new Label(app.getLang().get("hud.event.label.title"), app.getSkin());
        eventTable = new Table();
        eventTable.align(Align.topLeft);
        eventArea = new Label("", app.getSkin());
        eventScrollPane = new ScrollPane(eventTable, app.getSkin());
        closeButton = new TextButton(app.getLang().get("menu.global.button.close"), app.getSkin());
    }

    @Override
    public void addWidgets() {
        add(titleLabel).row();
        eventTable.add(eventArea);
        add(eventScrollPane).width(Config.HUD_LOG_WIDTH).height(Config.HUD_LOG_HEIGHT).fill().pad(Config.HUD_INNER_PADDING).row();
        add(closeButton);
    }

    @Override
    public void setListeners() {
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    Utility.getHud(app).toggleEventLog();
                } catch (NoHudException e) {
                    Gdx.app.debug("EventLogTable#setListeners", "No HUD is available");
                }
            }
        });
    }


    @Override
    public void update(Observable o, Object arg) {
        String log = o.toString();
        eventArea.setText(log);
        eventScrollPane.layout();
        updateIndicator();
    }

    private void updateIndicator() {
        try {
            // If dialogs are disabled, indicator about the new event is displayed on the screen.
            if (!app.getSettingsManager().getConfig().isEnableDialogs()) {
                Utility.getHud(app).getIndicatorTable().activateEvent();
            }
        } catch (NoHudException e) {
            Gdx.app.debug("EventLogTable#updateIndicator", "No HUD is available");
        } catch (IndexOutOfBoundsException e) {
            Gdx.app.debug("EventLogTable#updateIndicator", "Out of bounds exception");
        }
    }
}
