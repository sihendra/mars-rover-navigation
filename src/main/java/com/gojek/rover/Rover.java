package com.gojek.rover;

import java.util.List;

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

    public void move(RoverCommand command) throws InvalidInputException {
        if (isOutOfBound(command)) {
            throw new InvalidInputException("Movement disallowed: out of bound");
        }
        position.move(command);
    }

    public void move(List<RoverCommand> commands) throws InvalidInputException {
        for (RoverCommand command : commands
                ) {
            move(command);
        }
    }

    public boolean isOutOfBound(RoverCommand movement) {
        RoverPosition currentPos = getPosition();
        RoverPosition newPos = new RoverPosition(currentPos.getX(), currentPos.getY(), currentPos.getDirection());

        newPos.move(movement);

        return plateau.isOutOfBounds(newPos);

    }


}
