package com.marcelotozzi.redoctober;

import com.marcelotozzi.redoctober.entity.Position;
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

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(WEST)));
    }

    @Test
    public void itShouldTurnRightAndBeEast() throws Exception {
        redoctober.receiveCommands("R");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(EAST)));
    }

    @Test
    public void itShouldTurnRightTwiceAndBeWest() throws Exception {
        redoctober.receiveCommands("RR");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(SOUTH)));
    }

    @Test
    public void itShouldTurnRight3TimesAndBeWest() throws Exception {
        redoctober.receiveCommands("RRR");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(WEST)));
    }

    @Test
    public void itShouldTurnRight4TimesAndBeWest() throws Exception {
        redoctober.receiveCommands("RRRR");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldNotTurnForAInvalidCommand() throws Exception {
        redoctober.receiveCommands("TTT");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldUpInDirectionToNorth() {
        redoctober = new Submarine(0, 0, -1, NORTH);

        redoctober.receiveCommands("U");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldDownInDirectionToNorth() {
        redoctober.receiveCommands("D");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(-1))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldMoveToDirectionNorth() {
        redoctober.receiveCommands("M");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(1))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void itShouldStopInSurface(){
        redoctober.receiveCommands("UUUUUUUU");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("x", is(equalTo(0))));
        assertThat(position, hasProperty("y", is(equalTo(0))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
        assertThat(position, hasProperty("direction", is(NORTH)));
    }

    @Test
    public void firstSequence() {
        redoctober.receiveCommands("LMRDDMMUU");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("direction", is(NORTH)));
        assertThat(position, hasProperty("x", is(equalTo(-1))));
        assertThat(position, hasProperty("y", is(equalTo(2))));
        assertThat(position, hasProperty("z", is(equalTo(0))));
    }

    @Test
    public void secondSequence() {
        redoctober.receiveCommands("RMMLMMMDDLL");

        Position position = redoctober.getPosition();

        assertThat(position, hasProperty("direction", is(SOUTH)));
        assertThat(position, hasProperty("x", is(equalTo(2))));
        assertThat(position, hasProperty("y", is(equalTo(3))));
        assertThat(position, hasProperty("z", is(equalTo(-2))));
    }
}