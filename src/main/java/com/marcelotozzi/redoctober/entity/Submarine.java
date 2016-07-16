package com.marcelotozzi.redoctober.entity;

import com.marcelotozzi.redoctober.entity.enums.ACTION;
import com.marcelotozzi.redoctober.entity.enums.COMMAND;
import com.marcelotozzi.redoctober.entity.enums.DIRECTION;

import static com.marcelotozzi.redoctober.entity.enums.DIRECTION.*;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public class Submarine {
    private int x;
    private int y;
    private int z;
    private DIRECTION direction;
    private Compass<DIRECTION> compass;
    private DIRECTION[] directions = new DIRECTION[]{NORTH, EAST, SOUTH, WEST};

    private Submarine() {
        compass = new Compass<>(directions);
    }

    public Submarine(int x, int y, int z, DIRECTION initialDirection) {
        compass = new Compass<>(directions);
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = initialDirection;
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

    public DIRECTION getDirection() {
        return direction;
    }

    public void receiveCommands(String commands) {
        for (char character : commands.toCharArray()) {

            if (COMMAND.contains(character)) {
                applyCommand(COMMAND.valueOf(character));
                continue;
            }

            if (ACTION.contains(character)) {
                applyAction(ACTION.valueOf(character));
                continue;
            }
        }
    }

    private void applyAction(ACTION action) {
        //TODO:
    }

    private void applyCommand(COMMAND command) {
        int index = compass.indexOf(direction);
        switch (command) {
            case L:
                direction = compass.get(index - 1);
                break;
            case R:
                direction = compass.get(index + 1);
                break;
        }
    }

}
