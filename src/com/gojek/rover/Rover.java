package com.gojek.rover;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class Rover {
    protected RoverPosition position;


    public Rover() {
        super();
    }

    public void move(RoverMovement movement) {
        position.move(movement);
    }


}
