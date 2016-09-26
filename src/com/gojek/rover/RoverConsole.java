package com.gojek.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hendra.s@go-jek.com on 9/26/16.
 */
public class RoverConsole {


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

    private void setUpperCoordinate(String input) throws InvalidInputException {

    }
}
