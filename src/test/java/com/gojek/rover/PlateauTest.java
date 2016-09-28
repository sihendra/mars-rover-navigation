package com.gojek.rover;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hendra.s@go-jek.com on 9/27/16.
 */
public class PlateauTest {
    @Test
    public void isOutOfBounds() throws Exception {
        Point2D roverPos = new Point2D(3, 3);
        Plateau plateau = new Plateau(new Point2D(3, 3));

        assertFalse(plateau.isOutOfBounds(roverPos));
    }

    @Test
    public void isOutOfBoundsGivenOutsidePoint() throws Exception {
        Point2D roverPos = new Point2D(2, 4);
        Plateau plateau = new Plateau(new Point2D(3, 3));

        assertTrue(plateau.isOutOfBounds(roverPos));
    }


}