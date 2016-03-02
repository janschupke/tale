package eu.janschupke.buddy.framework.base.entity.state;

/**
 * State that applies for all levels in general.
 */
public class GlobalLevelState extends LevelState {
    protected String currentHint;
    protected String hintCache;

    protected boolean interactionActive;

    protected boolean newEvent;
    protected boolean newQuest;
    protected boolean newItem;

    public String getCurrentHint() {
        return currentHint;
    }

    public void setCurrentHint(String currentHint) {
        this.currentHint = currentHint;
        setChanged();
        notifyObservers();
    }

    public void clearCurrentHint() {
        currentHint = "";
        setChanged();
        notifyObservers();
    }

    public String getHintCache() {
        return hintCache;
    }

    public void cacheCurrentHint() {
        hintCache = currentHint;
    }

    public void activateCachedHint() {
        currentHint = hintCache;
        hintCache = "";
        setChanged();
        notifyObservers();
    }

    public boolean isInteractionActive() {
        return interactionActive;
    }

    public void setInteractionActive(boolean interactionActive) {
        this.interactionActive = interactionActive;
    }

    public boolean isNewEvent() {
        return newEvent;
    }

    public void setNewEvent(boolean newEvent) {
        this.newEvent = newEvent;
        setChanged();
        notifyObservers();
    }

    public boolean isNewQuest() {
        return newQuest;
    }

    public void setNewQuest(boolean newQuest) {
        this.newQuest = newQuest;
        setChanged();
        notifyObservers();
    }

    public boolean isNewItem() {
        return newItem;
    }

    public void setNewItem(boolean newItem) {
        this.newItem = newItem;
        setChanged();
        notifyObservers();
    }

    public boolean isIndicatorEmpty() {
        return (!newEvent && !newQuest && !newItem);
    }
}
