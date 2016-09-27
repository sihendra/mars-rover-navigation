package com.gojek.rover;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class Rover {
    protected RoverPosition position;
    protected Plateau plateau;

    public Rover() {
        super();
    }

    public RoverPosition getPosition() {
        return position;
    }

    public void setPosition(RoverPosition position) {
        this.position = position;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Plateau getPlateau() {
        return plateau;
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

        return plateau.isOutOfBounds(newPos);

    }


}
