package org.example.inputparser;

import org.example.direction.CompassDirection;
import org.example.instruction.Instruction;
import org.example.plateau.PlateauSize;

import java.util.ArrayList;

public class InputParser {

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



    public ArrayList<CompassDirection> checkCompassDirection(String[] input){
        if (input.length ==0){
            return null;
        }
        ArrayList<CompassDirection> validInputs= new ArrayList<>();
        for (String value: input){
            if (value.matches("[NnSsEeWw]+")) {
                for (char c : value.toCharArray()) {
                    validInputs.add(CompassDirection.valueOf(String.valueOf(c).toUpperCase()));
                }
            }
            else throw new IllegalArgumentException("Not a valid direction!");
        }
        return validInputs;
    }

}
