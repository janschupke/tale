package eu.janschupke.tale.base.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import eu.janschupke.tale.base.entity.WorldObject;

/**
 * Represents a view component for rendering.
 * Provides camera and viewport management for game screens.
 */
public class View {
    private float borderTop;
    private float borderBottom;
    private float borderRight;
    private float borderLeft;
    private OrthographicCamera camera;
    private Viewport viewport;
    private OrthographicCamera sceneCamera;

    public View(float viewportWidth, float viewportHeight, float worldWidth, float worldHeight) {
        borderTop = worldHeight - viewportHeight / 2;
        borderLeft = viewportWidth / 2;
        borderRight = worldWidth - viewportWidth / 2;
        borderBottom = viewportHeight / 2;

        final float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();

        // Level rendering.
        camera = new OrthographicCamera();
        viewport = new FillViewport(viewportWidth * aspectRatio, viewportHeight);
        viewport.setCamera(camera);

        // HUD rendering.
        sceneCamera = new OrthographicCamera();
        Viewport sceneViewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sceneViewport.setCamera(sceneCamera);
    }

    /**
     * Makes the camera stay within the game world.
     */
    public void limitCamera() {
        if (camera.position.y > borderTop) {
            camera.position.y = borderTop;
        }
        if (camera.position.y < borderBottom) {
            camera.position.y = borderBottom;
        }
        if (camera.position.x > borderRight) {
            camera.position.x = borderRight;
        }
        if (camera.position.x < borderLeft) {
            camera.position.x = borderLeft;
        }
    }

    /**
     * Centers the camera on the requested object with interpolation active.
     *
     * @param o Target object.
     */
    public void updateCameraPosition(WorldObject o) {
        final float factor = 0.1f;
        Vector3 position = camera.position;
        Vector2 target = new Vector2(o.getX(), o.getY());
        position.x = position.x + (target.x - position.x) * factor;
        position.y = position.y + (target.y - position.y) * factor;

        camera.position.set(position);
    }

    /**
     * Centers the camera on the requested object without interpolating.
     *
     * @param o Target object.
     */
    public void setCameraPosition(WorldObject o) {
        Vector3 target = new Vector3(o.getX(), o.getY(), 0);
        camera.position.set(target);
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public OrthographicCamera getSceneCamera() {
        return sceneCamera;
    }
}
