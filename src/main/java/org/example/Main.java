package org.example;

import org.example.inputparser.InputParser;
import org.example.inputparser.InstructionParser;
import org.example.inputparser.PlateauParser;
import org.example.instruction.Instruction;
import org.example.plateau.PlateauSize;
import org.example.rover.RoverPosition;
import org.example.rover.RoverVehicle;

import java.security.spec.ECField;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, and welcome to the Mars Rover Mission!");
        System.out.println("Would you like to land a Rover on Mars today? y/n");
        String commenceMission = scanner.nextLine().toLowerCase();
        if (!commenceMission.equals("y")) {
            System.out.println("Rover will not be deployed today. See you next time.");
        }
        PlateauSize plateauSize;
        while (true) {
            PlateauParser plateauParser = new PlateauParser();
            try {
                System.out.println("Please enter plateau dimensions in the format (x,y):");
                String plateauDimensions = scanner.nextLine();
                plateauSize = plateauParser.checkPlateauSize(plateauDimensions);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Please enter a name for your Rover");
        String roverName = scanner.nextLine();

        while (true) {
            InputParser inputParser = new InputParser();
            InstructionParser instructionParser = new InstructionParser();
            try {
                System.out.println("Please enter starting position of the Rover in the format (x, y, direction): ");
                String landingPosition = scanner.nextLine();
                RoverPosition roverPosition = inputParser.validateInitialPosition(landingPosition);
                RoverVehicle roverVehicle = new RoverVehicle(roverPosition, roverName);
                plateauSize.addRover(roverVehicle);
                System.out.println("Please enter instructions to navigate the Rover in the format (LRM):");
                String instructions = scanner.nextLine();
                List<Instruction> parsedInstructions = instructionParser.checkInstructionInputs(instructions);
                roverVehicle.interpretInstruction(parsedInstructions, plateauSize);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

                //Ask user to enter instructions
                //Return output of where rover is
            }
        }

