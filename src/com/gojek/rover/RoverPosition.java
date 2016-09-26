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

    public void setDirection(CompassPoint direction) {
        this.direction = direction;
    }

    public CompassPoint getDirection() {
        return direction;
    }

    public void move(RoverMovement movement) {
        if (movement == movement.L) {
            setDirection(direction.left());
        } else if (movement == movement.R) {
            setDirection(direction.right());
        } else if (movement == movement.M) {
            setX(getX() + direction.getMoveX());
            setY(getY() + direction.getMoveY());
        }
    }

    @Override
    public String toString() {
        return getX() + " " + getY() + " " + getDirection();
    }
}
