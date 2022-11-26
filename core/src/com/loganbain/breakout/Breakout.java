package com.loganbain.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer shape;
    ArrayList<Ball> balls;

    int x = 50;
    int xSpeed = 5;
    int y = 50;

    public void create() {
        shape = new ShapeRenderer();
        balls = new ArrayList<>();
        Random r = new Random();

        // create 10 randomly sized and located balls
        for (int i = 0; i < 10; i++) {
            balls.add(new Ball(
                    r.nextInt(Gdx.graphics.getWidth()), // random x location up to application width
                    r.nextInt(Gdx.graphics.getHeight()), // random y location up to application height
                    r.nextInt(100), // random circle radius up to 100
                    r.nextInt(15), // random xSpeed up to 15
                    r.nextInt(15))); // random ySpeed up to 15
        }

        // ball = new Ball(150, 200, 70, 12, 5);
    }

    public void render() {
        // Clears the screen (avoids a "trail" from drawing the circle)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (Ball ball : this.balls) {
            ball.update();
            ball.draw(shape);
        }
        shape.end();
    }
}
