package eu.janschupke.buddy.framework.base.screen;

/**
 * Container for variables describing level state.
 * @author jan.schupke@gmail.com
 */
public abstract class LevelState {
    protected String hintCache;

    public String getHintCache() {
        return hintCache;
    }

    public void setHintCache(String hintCache) {
        this.hintCache = hintCache;
    }
}