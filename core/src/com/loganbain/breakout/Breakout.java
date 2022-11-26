package com.loganbain.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Breakout extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;
    ArrayList<Block> blocks;

    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 15, 8, 3);
        paddle = new Paddle(10, 20, 100, 8);
        blocks = new ArrayList<>();

        int blockWidth = 63;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    public void render() {
        // Clears the screen (avoids a "trail" from drawing the circle)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shape.begin(ShapeRenderer.ShapeType.Filled);

        paddle.update();
        paddle.draw(shape);

        ball.update();
        ball.draw(shape);

        for (Block block : this.blocks) {
            block.draw(shape);
            ball.checkCollision(block);
        }
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.destroyed) {
                blocks.remove(i);
                // must decrement i when a ball is removed, else we will skip a ball
                i--;
            }
        }

        ball.checkCollision(paddle);
        shape.end();
    }
}
