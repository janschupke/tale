package eu.janschupke.buddy.framework.base.interaction;

/**
 * One decision within a set of decisions for each situation.
 * @author jan.schupke@gmail.com
 */
public class Decision {
    protected String description;
    protected boolean available;

    // TODO: metric reference

    public Decision(String description) {
        this.description = description;
        available = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
