package com.gojek.rover;

import java.util.Map;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public enum CompassPoint {
    NORTH("west", "east", 0, 1),
    EAST("north", "south", 1, 0),
    SOUTH("east", "west", 0, -1),
    WEST("south", "north", -1, 0);

    private Map<String,CompassPoint> directionStrMap;
    private CompassPoint left;
    private CompassPoint right;
    private int moveX;
    private int moveY;

    CompassPoint(String left, String right, int moveX, int moveY) {
        this.left = directionStrMap.get(left);
        this.right = directionStrMap.get(right);
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public CompassPoint left() {
        return left;
    }

    public CompassPoint right() {
        return right;
    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }
}
