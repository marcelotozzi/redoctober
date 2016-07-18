package com.marcelotozzi.redoctober.entity.enums;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum DIRECTION {
    NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);

    private int x;
    private int y;

    DIRECTION(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
