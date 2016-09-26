package com.gojek.rover;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverPosition extends Point2D {
    protected CompassPoint direction;

    public RoverPosition(int x, int y, CompassPoint direction) {
        super(x, y);
        this.direction = direction;
    }
}
