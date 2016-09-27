package com.gojek.rover;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public enum CompassPoint {
    NORTH("N","west", "east", 0, 1),
    EAST("E","north", "south", 1, 0),
    SOUTH("S","east", "west", 0, -1),
    WEST("S","south", "north", -1, 0);

    private String stringValue;
    private String left;
    private String right;
    private int moveX;
    private int moveY;

    CompassPoint(String stringValue, String left, String right, int moveX, int moveY) {
        this.left = left;
        this.right = right;
        this.moveX = moveX;
        this.moveY = moveY;
        this.stringValue = stringValue;
    }

    private CompassPoint parse(String str) {
        Map<String, CompassPoint> m = new HashMap<>();
        m.put("north", NORTH);
        m.put("east", EAST);
        m.put("south", SOUTH);
        m.put("west", WEST);

        return m.get(str);
    }

    public CompassPoint left() {
        return parse(this.left);
    }

    public CompassPoint right() {
        return parse(this.right);
    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
