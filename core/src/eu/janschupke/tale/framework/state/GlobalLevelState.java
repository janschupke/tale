package eu.janschupke.tale.framework.state;

/**
 * State that applies for all levels in general.
 */
public class GlobalLevelState extends LevelState {
    protected String currentHint;

    protected boolean interactionActive;

    protected boolean newEvent;
    protected boolean newQuest;
    protected boolean newItem;

    private boolean lumberPicked;
    private boolean lumberQuestAccepted;
    private boolean bookPicked;
    private boolean caveExplored;
    private boolean disputeAccepted;

    private boolean journalPicked;
    private boolean settlementKeyAcquired;

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

    public boolean isLumberPicked() {
        return lumberPicked;
    }

    public void setLumberPicked(boolean lumberPicked) {
        this.lumberPicked = lumberPicked;
    }

    public boolean isLumberQuestAccepted() {
        return lumberQuestAccepted;
    }

    public void setLumberQuestAccepted(boolean lumberQuestAccepted) {
        this.lumberQuestAccepted = lumberQuestAccepted;
    }

    public boolean isBookPicked() {
        return bookPicked;
    }

    // TODO: test, debug, remove, prolly not needed to keep here
    public void setBookPicked(boolean bookPicked) {
        this.bookPicked = bookPicked;
    }

    public boolean isCaveExplored() {
        return caveExplored;
    }

    public void setCaveExplored(boolean caveExplored) {
        this.caveExplored = caveExplored;
    }

    public boolean isDisputeAccepted() {
        return disputeAccepted;
    }

    public void setDisputeAccepted(boolean disputeAccepted) {
        this.disputeAccepted = disputeAccepted;
    }

    public boolean isJournalPicked() {
        return journalPicked;
    }

    public void setJournalPicked(boolean journalPicked) {
        this.journalPicked = journalPicked;
    }

    public boolean isSettlementKeyAcquired() {
        return settlementKeyAcquired;
    }

    public void setSettlementKeyAcquired(boolean settlementKeyAcquired) {
        this.settlementKeyAcquired = settlementKeyAcquired;
    }
}
