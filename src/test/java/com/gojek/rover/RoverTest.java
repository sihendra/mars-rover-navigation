package com.gojek.rover;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverTest {
    @Test
    public void move1() throws Exception {
        Rover r = new Rover();
        r.setPlateau(new Plateau(new Point2D(5,5)));
        r.setPosition(new RoverPosition(1, 2, CompassPoint.NORTH));

        // LMLMLMLMM
        r.move(RoverCommand.L);
        r.move(RoverCommand.M);
        r.move(RoverCommand.L);
        r.move(RoverCommand.M);
        r.move(RoverCommand.L);
        r.move(RoverCommand.M);
        r.move(RoverCommand.L);
        r.move(RoverCommand.M);
        r.move(RoverCommand.M);

        RoverPosition finalPosition = r.getPosition();

        assertEquals(1, finalPosition.getX());
        assertEquals(3, finalPosition.getY());
        assertEquals(CompassPoint.NORTH, finalPosition.getDirection());

    }

    @Test
    public void move2() throws Exception {
        Rover r = new Rover();
        r.setPosition(new RoverPosition(3, 3, CompassPoint.EAST));
        r.setPlateau(new Plateau(new Point2D(5,5)));

        // LMLMLMLMM
        r.move(RoverCommand.M);
        r.move(RoverCommand.M);
        r.move(RoverCommand.R);
        r.move(RoverCommand.M);
        r.move(RoverCommand.M);
        r.move(RoverCommand.R);
        r.move(RoverCommand.M);
        r.move(RoverCommand.R);
        r.move(RoverCommand.R);
        r.move(RoverCommand.M);

        RoverPosition finalPosition = r.getPosition();

        assertEquals(5, finalPosition.getX());
        assertEquals(1, finalPosition.getY());
        assertEquals(CompassPoint.EAST, finalPosition.getDirection());

    }

    @Test(expected = InvalidInputException.class)
    public void isOutOfBound() throws InvalidInputException {
        Rover r = new Rover();
        r.setPosition(new RoverPosition(1, 1, CompassPoint.SOUTH));
        r.setPlateau(new Plateau(new Point2D(2, 2)));

        r.move(RoverCommand.M);
        r.move(RoverCommand.M);
    }

}