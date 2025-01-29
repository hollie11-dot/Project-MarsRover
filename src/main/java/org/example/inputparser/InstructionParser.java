package org.example.inputparser;

import org.example.direction.CompassDirection;
import org.example.instruction.Instruction;

import java.util.ArrayList;

import static org.example.instruction.Instruction.L;

public class InstructionParser {

    public ArrayList<Instruction> checkInstructionInputs(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Please try again");
        }
        String[] inputs = input.toUpperCase().split(",");
        ArrayList<Instruction> validInputs = new ArrayList<>();
        for (String value : inputs) {
            if(value.matches("[LlRrMm]+")) {
                for (char c : value.toCharArray()) {
                    validInputs.add(Instruction.valueOf(value));
                }
            }
          else throw new IllegalArgumentException("Not a valid instruction! Please only enter instructions as 'L,R,M'.");
        }
        return validInputs;
    }
}


