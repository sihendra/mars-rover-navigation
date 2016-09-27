package com.gojek.rover;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverConsoleTest {
    @org.junit.Test
    public void readUntilCtrlC() throws Exception {

    }

    @org.junit.Test
    public void parsePoint2D() throws Exception {
        RoverConsole rc = new RoverConsole();
        Point2D point = rc.parsePoint2D("5 5");

        assertEquals(point.getX(), 5);
        assertEquals(point.getY(), 5);
    }

    @Test
    public void parseRoverPosition() throws Exception {
        RoverConsole rc = new RoverConsole();
        RoverPosition pos = rc.parseRoverPosition("1 2 N");

        assertEquals(1, pos.getX());
        assertEquals(2, pos.getY());
        assertEquals(CompassPoint.NORTH, pos.getDirection());
    }

    @Test
    public void parseRoverMovement() throws Exception {
        RoverConsole rc = new RoverConsole();
        List<RoverCommand> movements = rc.parseRoverMovements("LRMM");

        assertEquals(RoverCommand.L, movements.get(0));
        assertEquals(RoverCommand.R, movements.get(1));
        assertEquals(RoverCommand.M, movements.get(2));
        assertEquals(RoverCommand.M, movements.get(3));

    }


}