package org.example.inputparser;

import org.example.direction.CompassDirection;
import org.example.instruction.Instruction;
import org.example.plateau.PlateauSize;
import org.example.rover.RoverPosition;
import org.example.rover.RoverVehicle;

import java.util.ArrayList;

public class InputParser {

    public RoverPosition validateInitialPosition(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("Invalid input. Please try again");
        }
        String[] roverPosition = input.trim().split(",\\s");
        if (roverPosition.length != 3) {
            throw new IllegalArgumentException("Incorrect format. Please enter landing position in the following format: '1,2,N'.");
        }
            int x = Integer.parseInt(roverPosition[0]);
            int y = Integer.parseInt(roverPosition[1]);
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Co-ordinates cannot be a negative number! Please re-enter.");
        }
        try{
            CompassDirection facing = CompassDirection.valueOf(roverPosition[2]);
            return new RoverPosition(x,y,facing);

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Please enter direction facing as 'N,S,E,W'.");
        }
    }

}
