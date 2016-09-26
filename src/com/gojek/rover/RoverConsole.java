package com.gojek.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverConsole {

    protected Point2D upperBound;

    public Point2D getUpperBound() {
        return upperBound;
    }

    public void readUntilCtrlC() {
        BufferedReader br = null;
        try {

            // Refer to this http://www.mkyong.com/java/how-to-read-input-from-console-java/
            // for JDK 1.6, please use java.io.Console class to read system input.
            br = new BufferedReader(new InputStreamReader(System.in));

            boolean isVeryFirst = true;
            while (true) {
                System.out.print("$ ");
                String input = br.readLine();

                if ("done".equals(input)) {
                    calculateOutputs();
                }

                if (isVeryFirst) {
                    try {
                        setUpperCoordinate(input);
                        isVeryFirst = false;
                    } catch (InvalidInputException e) {
                        System.out.println("Invalid upper coordinate");
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
    }

    private void setUpperCoordinate(String input) throws InvalidInputException {
        this.upperBound = parsePoint2D(input);
    }

    public Point2D parsePoint2D(String input) throws InvalidInputException {
        String pattern = "(\\d+) (\\d+)";

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
}
