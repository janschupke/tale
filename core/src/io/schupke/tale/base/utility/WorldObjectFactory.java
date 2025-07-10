package io.schupke.tale.base.utility;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import io.schupke.tale.content.config.Config;

/**
 * Factory class for creating world objects.
 * Provides methods for instantiating various game entities.
 */
public final class WorldObjectFactory {
    /**
     * Creates a box-shaped body.
     *
     * @param world         Box2D world.
     * @param size          Size of a side of the box.
     * @param position      Initial position.
     * @param bodyType      Type of the body.
     * @param fixedRotation True if fixed, false if rotating.
     * @return The body reference.
     */
    public static Body createBox(World world, Vector2 size, Vector2 position, BodyDef.BodyType bodyType, boolean fixedRotation) {
        BodyDef def = new BodyDef();

        def.type = bodyType;
        def.position.set(position.x + (size.x / 2.0f), position.y + (size.y / 2.0f));
        def.fixedRotation = fixedRotation;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x / 2.0f, size.y / 2.0f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = Config.DENSITY;
        fixtureDef.friction = Config.FRICTION;
        fixtureDef.restitution = Config.RESTITUTION;

        Body body;
        body = world.createBody(def);
        body.createFixture(fixtureDef);
        body.setLinearDamping(Config.LINEAR_DAMPING);
        body.setAngularDamping(Config.ANGULAR_DAMPING);

        shape.dispose();

        return body;
    }

    /**
     * Creates a circle-shaped body/
     *
     * @param world         Box2D world.
     * @param radius        Body radius.
     * @param position      Initial position.
     * @param bodyType      Type of the body.
     * @param fixedRotation True if fixed, false if rotating.
     * @return The body reference.
     */
    public static Body createCircle(World world, float radius, Vector2 position, BodyDef.BodyType bodyType, boolean fixedRotation) {
        Body body;
        BodyDef def = new BodyDef();

        def.type = bodyType;
        def.position.set(position.x + (radius / 2.0f), position.y + (radius / 2.0f));
        def.fixedRotation = fixedRotation;

        CircleShape shape = new CircleShape();
        shape.setRadius(radius / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = Config.DENSITY;
        fixtureDef.friction = Config.FRICTION;
        fixtureDef.restitution = Config.RESTITUTION;

        body = world.createBody(def);
        body.createFixture(fixtureDef);
        body.setLinearDamping(Config.LINEAR_DAMPING);
        body.setAngularDamping(Config.ANGULAR_DAMPING);

        shape.dispose();

        return body;
    }

    /**
     * Sets the collision category.
     *
     * @param body         The body that is being configured.
     * @param categoryBits Collision category of the body.
     * @param maskBits     What categories does it collide with.
     */
    public static void setCollisions(Body body, short categoryBits, short maskBits) {
        for (Fixture f : body.getFixtureList()) {
            f.getFilterData().categoryBits = categoryBits;
            f.getFilterData().maskBits = maskBits;
        }
    }

    /**
     * Configures the sensor flag of a body.
     *
     * @param body     The body that is being configured.
     * @param isSensor True if sensor, false otherwise.
     */
    public static void setSensor(Body body, boolean isSensor) {
        for (Fixture f : body.getFixtureList()) {
            f.setSensor(isSensor);
        }
    }

    /**
     * Sets the density of a body.
     *
     * @param body    The body that is being configured.
     * @param density New density.
     */
    public static void setDensity(Body body, float density) {
        for (Fixture f : body.getFixtureList()) {
            f.setDensity(density);
        }
    }

    /**
     * Sets the friction of a body.
     *
     * @param body     The body that is being configured.
     * @param friction New friction.
     */
    public static void setFriction(Body body, float friction) {
        for (Fixture f : body.getFixtureList()) {
            f.setFriction(friction);
        }
    }

    /**
     * Sets the restitution value for a body.
     *
     * @param body        The body that is being configured.
     * @param restitution New restitution.
     */
    public static void setRestitution(Body body, float restitution) {
        for (Fixture f : body.getFixtureList()) {
            f.setRestitution(restitution);
        }
    }

    /**
     * Parses TMX object layer objects into static Box2D bodies.
     *
     * @param world    Target world.
     * @param objects  All map objects.
     * @param tileSize Size of one tile.
     */
    public static void parseMapObjects(World world, MapObjects objects, float tileSize) {
        for (MapObject object : objects) {
            Shape shape;

            if (object instanceof PolylineMapObject) {
                shape = createPolylineObject((PolylineMapObject) object, tileSize);
            } else if (object instanceof EllipseMapObject) {
                shape = createEllipseObject((EllipseMapObject) object, tileSize);
            } else if (object instanceof PolygonMapObject) {
                shape = createPolygonObject((PolygonMapObject) object, tileSize);
            } else if (object instanceof RectangleMapObject) {
                shape = createRectangleObject((RectangleMapObject) object, tileSize);
            } else {
                continue;
            }

            Body body;
            BodyDef def = new BodyDef();
            def.type = BodyDef.BodyType.StaticBody;

            body = world.createBody(def);
            body.createFixture(shape, Config.DENSITY);
            shape.dispose();
        }
    }

    /**
     * Parses an ellipse map object into a circle Box2D body.
     *
     * @param object   Map object.
     * @param tileSize Size of one tile.
     * @return Parsed shape.
     */
    private static CircleShape createEllipseObject(EllipseMapObject object, float tileSize) {
        Ellipse ellipse = object.getEllipse();
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(ellipse.width / tileSize);
        circleShape.setPosition(new Vector2(ellipse.x / tileSize, ellipse.y / tileSize));
        return circleShape;
    }

    /**
     * Parses a chain map object into a polyline Box2D body.
     *
     * @param object   Map object.
     * @param tileSize Size of one tile.
     * @return Parsed shape.
     */
    private static ChainShape createPolylineObject(PolylineMapObject object, float tileSize) {
        float[] vertices = object.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < worldVertices.length; i++) {
            worldVertices[i] = new Vector2(vertices[i * 2] / tileSize, vertices[i * 2 + 1] / tileSize);
        }

        ChainShape chainShape = new ChainShape();
        chainShape.createChain(worldVertices);

        return chainShape;
    }

    /**
     * Parses a rectangle map object into a polygon Box2D body.
     *
     * @param object   Map object.
     * @param tileSize Size of one tile.
     * @return Parsed shape.
     */
    private static PolygonShape createRectangleObject(RectangleMapObject object, float tileSize) {
        Rectangle rectangle = object.getRectangle();
        PolygonShape polygon = new PolygonShape();
        Vector2 size = new Vector2((rectangle.x + rectangle.width * 0.5f) / tileSize,
                (rectangle.y + rectangle.height * 0.5f) / tileSize);
        polygon.setAsBox(rectangle.width * 0.5f / tileSize,
                rectangle.height * 0.5f / tileSize,
                size, 0.0f);
        return polygon;
    }

    /**
     * Parses a polygon map object into a polygon Box2D body.
     *
     * @param object   Map object.
     * @param tileSize Size of one tile.
     * @return Parsed shape.
     */
    private static PolygonShape createPolygonObject(PolygonMapObject object, float tileSize) {
        PolygonShape polygon = new PolygonShape();
        float[] vertices = object.getPolygon().getTransformedVertices();

        float[] worldVertices = new float[vertices.length];

        for (int i = 0; i < vertices.length; ++i) {
            worldVertices[i] = vertices[i] / tileSize;
        }

        polygon.set(worldVertices);
        return polygon;
    }
}
