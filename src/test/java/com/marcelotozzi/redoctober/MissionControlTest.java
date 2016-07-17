package com.marcelotozzi.redoctober;

import com.marcelotozzi.redoctober.entity.Submarine;
import org.junit.Before;
import org.junit.Test;

import static com.marcelotozzi.redoctober.entity.enums.DIRECTION.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by marcelotozzi on 15/07/16.
 */
public class MissionControlTest {

    private Submarine redoctober;

    @Before
    public void setUp() throws Exception {
        redoctober = new Submarine(0, 0, 0, NORTH);
    }

    @Test
    public void itShouldTurnLeftAndBeWest() throws Exception {
        redoctober.receiveCommands("L");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(WEST)));
    }

    @Test
    public void itShouldTurnRightAndBeEast() throws Exception {
        redoctober.receiveCommands("R");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(EAST)));
    }

    @Test
    public void itShouldTurnRightTwiceAndBeWest() throws Exception {
        redoctober.receiveCommands("RR");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(SOUTH)));
    }

    @Test
    public void itShouldTurnRight3TimesAndBeWest() throws Exception {
        redoctober.receiveCommands("RRR");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(WEST)));
    }

    @Test
    public void itShouldTurnRight4TimesAndBeWest() throws Exception {
        redoctober.receiveCommands("RRRR");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldNotTurnForAInvalidCommand() throws Exception {
        redoctober.receiveCommands("TTT");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(0))));
        assertThat(redoctober, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldUpInDirectionToNorth(){
        redoctober.receiveCommands("U");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(1))));
        assertThat(redoctober, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldDownInDirectionToNorth(){
        redoctober.receiveCommands("D");

        assertThat(redoctober, hasProperty("x", is(equalTo(0))));
        assertThat(redoctober, hasProperty("y", is(equalTo(0))));
        assertThat(redoctober, hasProperty("z", is(equalTo(-1))));
        assertThat(redoctober, hasProperty("direction", is(NORTH)));
    }
}