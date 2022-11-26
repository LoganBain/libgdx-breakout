package com.loganbain.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
    int x, y;
    int width, height;
    int leftLimit, rightLimit, lowerLimit, upperLimit;
    boolean destroyed;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.destroyed = false;

        // set limits
        leftLimit = this.x;
        rightLimit = this.x + width;
        lowerLimit = this.y;
        upperLimit = this.y + height;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }
}
