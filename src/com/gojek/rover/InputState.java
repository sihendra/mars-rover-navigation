package com.gojek.rover;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public enum InputState {
    MAX_BOUND("pos"),
    POS("movement"),
    MOVEMENTS("pos");


    private String nextState;

    InputState(String nextState) {
        this.nextState = nextState;
    }

    public InputState getNextState() {
        if (this.nextState == "pos") {
            return POS;
        } else if (this.nextState == "movement") {
            return MOVEMENTS;
        } else {
            return MAX_BOUND;
        }
    }
}
