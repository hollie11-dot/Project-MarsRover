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
            RoverPosition rover = new RoverPosition(x,y,facing);
            System.out.println(rover.getX());
            System.out.println(rover.getY());
            System.out.println(rover.getFacing());
            return rover;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Please enter direction facing as 'N,S,E,W'.");
        }
    }

    public ArrayList<Instruction> checkInstruction(String[] input){
        if (input.length ==0){
            return null;
        }
        ArrayList<Instruction> validInputs= new ArrayList<>();
        for (String value: input){
            if (value.matches("[LlRrMm]+")) {
                for (char c : value.toCharArray()) {
                    validInputs.add(Instruction.valueOf(String.valueOf(c).toUpperCase()));
                }
            }
            else throw new IllegalArgumentException("Not a valid instruction!");
        }
        return validInputs;
    }

}
