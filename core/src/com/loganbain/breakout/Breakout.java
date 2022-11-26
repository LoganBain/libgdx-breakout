package com.loganbain.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;

    int x = 50;
    int xSpeed = 5;
    int y = 50;

    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 70, 12, 5);
    }

    public void render() {
        // Clears the screen (avoids a "trail" from drawing the circle)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ball.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();
    }
}
