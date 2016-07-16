package com.marcelotozzi.redoctober.entity.enums;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public enum ACTION {
    U, D, M;


    public static boolean contains(char character) {
        ACTION a = valueOf(character);
        return a != null;
    }

    public static ACTION valueOf(char character) {
        try {
            return valueOf(String.valueOf(character));
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

}
