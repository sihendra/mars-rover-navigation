package com.gojek.rover;

public class Main {

    public static void main(String[] args) {
        // input reader
        RoverConsole rc = new RoverConsole();
        rc.readUntilCtrlC();
    }
}
