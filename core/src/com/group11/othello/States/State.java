package com.group11.othello.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.group11.othello.AI.Testing;
import com.group11.othello.Logic.Player;
import com.group11.othello.Logic.Player1;
import com.group11.othello.Logic.Player2;

import java.io.IOException;

public abstract class State {
    private OrthographicCamera camera;
    private Vector3 mouse;
    private GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();

    }

    public State(GameStateManager gsm, Player1 player1) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    public State(GameStateManager gsm, Player1 player1, Player2 player2) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected State() {
    }


    public abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);


    public OrthographicCamera getCamera() {
        return camera;
    }

    public Vector3 getMouse()
    {
        return mouse;
    }

    public GameStateManager getGsm()
    {
        return gsm;
    }
}
