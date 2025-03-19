package com.nicolas.mariobros.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.nicolas.mariobros.MarioBros;

public class B2WorldCreator {

    public B2WorldCreator(World world, TiledMap map){

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        // create ground bodies and fixtures
        for (MapObject object : map.getLayers().get(2)
            .getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM,
                (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / MarioBros.PPM,
                rect.getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        // create pipe bodies and fixtures
        for (MapObject object : map.getLayers().get(3)
            .getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM,
                (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()  / 2 / MarioBros.PPM,
                rect.getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        // create Bricks bodies and fixtures
        for (MapObject object : map.getLayers().get(5)
            .getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM,
                (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body =world.createBody(bdef);

            shape.setAsBox(rect.getWidth()  / 2 / MarioBros.PPM,
                rect.getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        // create coins bodies and fixtures
        for (MapObject object : map.getLayers().get(4)
            .getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject)object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM,
                (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()  / 2 / MarioBros.PPM,
                rect.getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
    }
}
