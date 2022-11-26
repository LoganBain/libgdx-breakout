package com.loganbain.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;

    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 25, 8, 3);
        paddle = new Paddle(10, 20, 100, 8);
    }

    public void render() {
        // Clears the screen (avoids a "trail" from drawing the circle)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        paddle.update();
        paddle.draw(shape);
        ball.update();
        ball.draw(shape);
        ball.checkCollision(paddle);
        shape.end();
    }
}
