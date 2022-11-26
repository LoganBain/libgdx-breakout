package com.loganbain.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x, y;
    int width, height;
    int leftLimit, rightLimit, upperLimit, lowerLimit;

    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {
        this.x = Gdx.input.getX() - 50;
//        this.y = Gdx.graphics.getHeight() - Gdx.input.getY();
        this.y = 20;

        leftLimit = x;
        rightLimit = x + width;
        upperLimit = y + height;
        lowerLimit = y;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
