package com.marcelotozzi.redoctober.entity;

import com.marcelotozzi.redoctober.entity.enums.DIRECTION;

/**
 * Created by tsfreitas on 17/07/16.
 */
public class Position {

    private int x;
    private int y;
    private int z;
    private DIRECTION direction;

    public Position(int x, int y, int z, DIRECTION direction) {
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Position addX(int value) {
        x += value;
        return this;
    }


    public Position addY(int value) {
        y += value;
        return this;
    }


    public Position addZ(int value) {
        z += value;
        return this;
    }

    public Position changeDirection(DIRECTION newDirection) {
        direction = newDirection;
        return this;
    }

}
