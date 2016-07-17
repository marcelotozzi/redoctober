package com.marcelotozzi.redoctober.entity;

import com.marcelotozzi.redoctober.entity.enums.DIRECTION;
import com.marcelotozzi.redoctober.entity.enums.MOVEMENT;
import com.marcelotozzi.redoctober.entity.enums.SPIN;

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

            if (SPIN.contains(character)) {
                applySpin(SPIN.valueOf(character));
                continue;
            }

            if (MOVEMENT.contains(character)) {
                applyMovement(MOVEMENT.valueOf(character));
                continue;
            }
        }
    }

    private void applyMovement(MOVEMENT movement) {
        switch (movement) {
            case U:
                if (isNotOnTheSurface()) z += 1;
                break;
            case D:
                z -= 1;
                break;
            case M:
                break;
            default:
                break;
        }
    }

    private boolean isNotOnTheSurface() {
        return (z <= 0);
    }

    private void applySpin(SPIN spin) {
        int index = compass.indexOf(direction);
        switch (spin) {
            case L:
                direction = compass.get(index - 1);
                break;
            case R:
                direction = compass.get(index + 1);
                break;
        }
    }

}
