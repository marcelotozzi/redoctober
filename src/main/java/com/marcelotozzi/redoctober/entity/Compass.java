package com.marcelotozzi.redoctober.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by marcelotozzi on 16/07/16.
 */
public class Compass<DIRECTION> extends ArrayList<DIRECTION> {
    private static final long serialVersionUID = 1L;

    public Compass(DIRECTION[] directions) {
        super(Collections.unmodifiableList(Arrays.asList(directions)));
    }

    public DIRECTION get(int index) {
        if (index == -1) {
            index = size() - 1;
        } else if (index == size()) {
            index = 0;
        }

        return super.get(index);
    }
}
