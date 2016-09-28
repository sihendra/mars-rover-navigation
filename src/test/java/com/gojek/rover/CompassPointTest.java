package com.gojek.rover;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class CompassPointTest {
    @Test
    public void left() throws Exception {
        assertEquals(CompassPoint.NORTH.left(),CompassPoint.WEST);
    }

    @Test
    public void right() throws Exception {

    }

    @Test
    public void getMoveX() throws Exception {

    }

    @Test
    public void getMoveY() throws Exception {

    }

}