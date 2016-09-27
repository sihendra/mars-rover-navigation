package com.gojek.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverConsole {

    protected Plateau plateau = new Plateau();
    protected List<RoverPosition> roverPositions = new ArrayList<>();
    protected List<List<RoverCommand>> roverMovements = new ArrayList<>();


    public void readUntilCtrlC() {
        BufferedReader br = null;
        try {

            // Refer to this http://www.mkyong.com/java/how-to-read-input-from-console-java/
            // for JDK 1.6, please use java.io.Console class to read system input.
            br = new BufferedReader(new InputStreamReader(System.in));

            InputState inputState = InputState.MAX_BOUND;
            Rover rover = null;
            while (true) {
                System.out.print("$ ");
                String input = br.readLine();

                if ("done".equals(input) || "".equals(input)) {
                    calculateOutputs();
                    break;
                }

                if (inputState == InputState.MAX_BOUND) {
                    try {
                        setUpperCoordinate(input);
                        inputState = inputState.getNextState();
                    } catch (InvalidInputException e) {
                        System.out.println("Invalid upper coordinate");
                    }
                } else if (inputState == InputState.POS) {
                    try {
                        RoverPosition roverPosition = parseRoverPosition(input);
                        roverPositions.add(roverPosition);
                        inputState = inputState.getNextState();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (inputState == InputState.MOVEMENTS) {
                    try {
                        List<RoverCommand> movements = parseRoverMovements(input);
                        roverMovements.add(movements);
                        inputState = inputState.getNextState();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void calculateOutputs() {
        List<Rover> rovers = new ArrayList<>();

        if (roverPositions.size() > roverMovements.size()) {
            roverPositions = roverPositions.subList(0, roverMovements.size());
        }


        for (RoverPosition pos: roverPositions
             ) {
            Rover r = new Rover();
            r.setPlateau(plateau);
            r.setPosition(pos);
            rovers.add(r);
        }

        int idx = 0;
        for(Rover r: rovers) {
            List<RoverCommand> roverCommandList = roverMovements.get(idx++);
            try {
                r.move(roverCommandList);
            } catch (InvalidInputException e) {
                System.out.println(e);
                break;
            }

            System.out.println(r.getPosition());
        }
    }

    private void setUpperCoordinate(String input) throws InvalidInputException {
        Point2D upperBoudn = parsePoint2D(input);
        this.plateau = new Plateau(upperBoudn);
    }

    public Point2D parsePoint2D(String input) throws InvalidInputException {
        String pattern = "^(\\d+) (\\d+)$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(input);

        if (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            return new Point2D(x, y);
        }

        throw new InvalidInputException("Invalid input value. Please use 'int int' (separated by space)");
    }

    public RoverPosition parseRoverPosition(String input) throws InvalidInputException {
        String pattern = "^(\\d+) (\\d+) (\\w?)$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(input);

        if (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            CompassPoint dir = compassPointFromString(m.group(3));
            if (dir == null) {
                throw new InvalidInputException("Invalid compass point value. Please use N,E,S,W char only");
            }
            return new RoverPosition(x, y, dir);
        }

        throw new InvalidInputException("Invalid input value. Please use 'int int String' (separated by space)");
    }

    public List<RoverCommand> parseRoverMovements(String input) throws InvalidInputException {
        List<RoverCommand> ret = new ArrayList<>();
        if (input == null) {
            return ret;
        }

        String pattern = "^[LRM]+$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(input);

        if (m.find()) {
            String[] commands = input.split("(?!^)");
            for (String command : commands) {
                ret.add(roverMovementFromString(command));
            }

            return ret;
        }

        throw new InvalidInputException("Invalid input value. Please use L,R,M only");
    }

    public RoverCommand roverMovementFromString(String str) {
        if (str == null) {
            return null;
        }

        Map<String, RoverCommand> m = new HashMap<>();
        m.put("L", RoverCommand.L);
        m.put("R", RoverCommand.R);
        m.put("M", RoverCommand.M);

        return m.get(str.toUpperCase());
    }

    public CompassPoint compassPointFromString(String str) {
        if (str == null) {
            return null;
        }

        Map<String, CompassPoint> m = new HashMap<>();
        m.put("N", CompassPoint.NORTH);
        m.put("E", CompassPoint.EAST);
        m.put("S", CompassPoint.SOUTH);
        m.put("W", CompassPoint.WEST);

        return m.get(str.toUpperCase());
    }
}
