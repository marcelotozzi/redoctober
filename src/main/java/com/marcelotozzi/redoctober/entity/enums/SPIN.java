package com.marcelotozzi.redoctober.entity.enums;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum SPIN {
    L, R;

    public static boolean contains(char character) {
        SPIN c = valueOf(character);
        return c != null;
    }

    public static SPIN valueOf(char character) {
        try {
            return valueOf(String.valueOf(character));
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }
}
