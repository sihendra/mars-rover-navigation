package com.gojek.rover;

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

}