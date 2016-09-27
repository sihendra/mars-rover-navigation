package com.gojek.rover;

/**
 * Created by hendra.s@go-jek.com on 9/27/16.
 */
public class Plateau {
    protected Point2D lowerBound;
    protected Point2D upperBound;

    public Plateau(Point2D upperBound) {
        this.lowerBound = new Point2D(0, 0);
        this.upperBound = upperBound;
    }

    public Point2D getUpperBound() {
        return upperBound;
    }

    public Point2D getLowerBound() {
        return lowerBound;
    }

    public boolean isOutOfBounds(Point2D pos) {

        return lowerBound.getX() > pos.getX() || upperBound.getX() <  pos.getX() ||
               lowerBound.getY() > pos.getY() || upperBound.getY() <  pos.getY();
    }
}
