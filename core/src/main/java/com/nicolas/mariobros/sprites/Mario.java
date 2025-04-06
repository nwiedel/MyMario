package com.nicolas.mariobros.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.nicolas.mariobros.MarioBros;
import com.nicolas.mariobros.Screens.PlayScreen;

public class Mario extends Sprite {

    public enum State{
        FALLING, JUMPING, STANDING, RUNNING
    }

    public State currentState;
    public State previousState;

    private World world;
    public Body b2body;
    private TextureRegion marioStand;

    private Animation<TextureRegion> marioRun;
    private Animation<TextureRegion> marioJump;

    private float stateTimer;

    private boolean runningRight;

    public Mario(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;

        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<>();
        for (int i = 1; i < 4; i++){
            frames.add(new TextureRegion(getTexture(), i * 16, 11, 16, 16));
        }
        marioRun = new Animation<>(0.1f, frames);
        frames.clear();
        for (int i = 4; i < 6; i++){
            frames.add(new TextureRegion(getTexture(), i * 16, 11, 16, 16));
        }
        marioJump = new Animation<>(0.1f, frames);
        frames.clear();

        defineMario();
        marioStand = new TextureRegion(getTexture(), 1, 11, 16, 16);
        setBounds(0, 0, 16 / MarioBros.PPM, 16 / MarioBros.PPM);
        setRegion(marioStand);
    }

    public void update(float delta){
        setPosition(b2body.getPosition().x - getWidth() / 2,
            b2body.getPosition().y - getHeight() / 2);

        setRegion(getFrame(delta));
    }

    public TextureRegion getFrame(float delta){
        //TODO
        return null;
    }

    private void defineMario(){
        BodyDef bdef =new BodyDef();
        bdef.position.set(32 / MarioBros.PPM, 32 / MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / MarioBros.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
