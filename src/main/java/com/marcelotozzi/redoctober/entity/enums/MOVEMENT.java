package com.marcelotozzi.redoctober.entity.enums;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum MOVEMENT {
    U, D, M;


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

}
