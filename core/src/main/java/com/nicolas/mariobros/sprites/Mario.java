package com.nicolas.mariobros.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.nicolas.mariobros.MarioBros;

public class Mario extends Sprite {

    private World world;
    public Body b2body;

    public Mario(World world){
        this.world = world;
        defineMario();
    }

    private void defineMario(){
        BodyDef bdef =new BodyDef();
        bdef.position.set(32 / MarioBros.PPM, 32 / MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / MarioBros.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
