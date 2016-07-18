package com.marcelotozzi.redoctober.entity;

import com.marcelotozzi.redoctober.entity.enums.DIRECTION;
import com.marcelotozzi.redoctober.entity.enums.MOVEMENT;
import com.marcelotozzi.redoctober.entity.enums.SPIN;

import static com.marcelotozzi.redoctober.entity.enums.DIRECTION.*;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public class Submarine {

    private Position position;
    private Compass<DIRECTION> compass;
    private DIRECTION[] directions = new DIRECTION[]{NORTH, EAST, SOUTH, WEST};

    private Submarine() {
    }

    public Submarine(int x, int y, int z, DIRECTION initialDirection) {
        compass = new Compass<>(directions);

        position = new Position(x, y, z, initialDirection);
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

    public Position getPosition() {
        return position;
    }

    private void applyMovement(MOVEMENT movement) {
        movement.executeMovement(position);
    }


    private void applySpin(SPIN spin) {
        int index = compass.indexOf(position.getDirection());
        switch (spin) {
            case L:
                position.changeDirection(compass.get(index - 1));
                break;
            case R:
                position.changeDirection(compass.get(index + 1));
                break;
        }
    }

}
