package com.marcelotozzi.redoctober.entity.enums;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum COMMAND {
    L, R;

    public static boolean contains(char character) {
        COMMAND c = valueOf(character);
        return c != null;
    }

    public static COMMAND valueOf(char character) {
        try {
            return valueOf(String.valueOf(character));
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }
}
