package com.loganbain.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x, y;
    int radius;
    int xSpeed, ySpeed;
    int leftLimit, rightLimit, upperLimit, lowerLimit;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.radius = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radius);
    }

    public void update() {
        if (leftLimit < 0 || rightLimit > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        updateX();

        if (lowerLimit < 0 || upperLimit > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
        updateY();
    }

    private void updateX() {
        x += xSpeed;
        leftLimit = x - radius;
        rightLimit = x + radius;
    }

    private void updateY() {
        y += ySpeed;
        upperLimit = y + radius;
        lowerLimit = y - radius;
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        if (this.leftLimit <= paddle.getRightLimit()
                && paddle.getRightLimit() <= this.rightLimit + paddle.getWidth()
                && this.upperLimit >= paddle.getLowerLimit()
                && paddle.getLowerLimit() >= this.lowerLimit - paddle.getHeight()) {
            return true;
        }
        return false;
    }
}
