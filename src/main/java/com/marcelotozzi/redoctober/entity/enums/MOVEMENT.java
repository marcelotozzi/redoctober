package com.marcelotozzi.redoctober.entity.enums;

import com.marcelotozzi.redoctober.entity.Position;

import java.util.function.Consumer;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum MOVEMENT {
    U(position -> {
        if (isNotOnTheSurface(position)) {
            position.addZ(1);
        }
    }),
    D(position -> position.addZ(-1)),
    M(pos -> pos.addX(pos.getDirection().getX()).addY(pos.getDirection().getY()));


    private Consumer<Position> movementFunction;


    MOVEMENT(Consumer<Position> movementFunction) {
        this.movementFunction = movementFunction;
    }

    public static boolean contains(char character) {
        MOVEMENT a = valueOf(character);
        return a != null;
    }

    public static MOVEMENT valueOf(char character) {
        try {
            return valueOf(String.valueOf(character));
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    private static boolean isNotOnTheSurface(Position position) {
        return (position.getZ() < 0);
    }

    public void executeMovement(Position originalPosition) {
        movementFunction.accept(originalPosition);
    }

}
