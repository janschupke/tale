package io.schupke.tale.base.input;

import com.badlogic.gdx.InputAdapter;

import io.schupke.tale.base.App;

/**
 * Base class for all input processors.
 */
public abstract class BaseInputProcessor extends InputAdapter {
    protected App app;

    public BaseInputProcessor(final App app) {
        this.app = app;
    }
}
