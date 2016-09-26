package com.gojek.rover;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class Rover {
    protected RoverPosition position;
    protected Point2D maxBound;
    protected Point2D minBound = new Point2D(0,0);


    public Rover() {
        super();
    }

    public RoverPosition getPosition() {
        return position;
    }

    public void setPosition(RoverPosition position) {
        this.position = position;
    }

    public void setMinBound(Point2D minBound) {
        this.minBound = minBound;
    }

    public Point2D getMinBound() {
        return minBound;
    }

    public void setMaxBound(Point2D maxBound) {
        this.maxBound = maxBound;
    }

    public Point2D getMaxBound() {
        return maxBound;
    }

    public void move(RoverMovement movement) throws InvalidInputException {
        if (isOutOfBound(movement)) {
            throw new InvalidInputException("Movement disallowed: out of bound");
        }
        position.move(movement);
    }

    public boolean isOutOfBound(RoverMovement movement) {
        RoverPosition currentPos = getPosition();
        RoverPosition newPos = new RoverPosition(currentPos.getX(), currentPos.getY(), currentPos.getDirection());

        newPos.move(movement);

        return newPos.getX() < minBound.getX() || newPos.getX() > maxBound.getX() || newPos.getY() < minBound.getY() || newPos.getY() > maxBound.getY();

    }


}
