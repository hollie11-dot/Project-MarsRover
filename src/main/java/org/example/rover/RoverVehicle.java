package org.example.rover;

import org.example.direction.CompassDirection;
import org.example.instruction.Instruction;
import org.example.plateau.PlateauSize;

import java.util.List;

public class RoverVehicle {

    private final RoverPosition position;
    private final String name;

    public RoverVehicle(RoverPosition position, String name) {
        this.position = position;
        this.name = name;
    }

    public CompassDirection getDirection() {
        return position.getFacing();
    }

    public int getXCoordinates(){
        return position.getX();
    }

    public int getYCoordinates(){
        return position.getY();
    }

    public RoverPosition getPosition(){
        return position;
    }

    public boolean hasPosition(RoverPosition positions){
        return position.equals(positions);
    }

    public String getName() {
        return name;
    }

    public void interpretInstruction(List<Instruction> instruction, PlateauSize plateauSize) {
        for (Instruction i : instruction) {
            if (i.equals(Instruction.M)) {
                move(plateauSize);
            } else {
                rotate(i);
            }
        }
    }

    public void rotate(Instruction instruction) {
        if (instruction.equals(Instruction.L)) {
            switch (position.getFacing()) {
                case N:
                    position.setFacing(CompassDirection.W);
                    break;
                case W:
                    position.setFacing(CompassDirection.S);
                    break;
                case S:
                    position.setFacing(CompassDirection.E);
                    break;
                case E:
                    position.setFacing(CompassDirection.N);
                    break;
                default:
                    throw new RuntimeException("Not able to access this location");
            }
        }

        if (instruction.equals(Instruction.R)) {
            switch (position.getFacing()) {
                case N:
                    position.setFacing(CompassDirection.E);
                    break;
                case E:
                    position.setFacing(CompassDirection.S);
                    break;
                case S:
                    position.setFacing(CompassDirection.W);
                    break;
                case W:
                    position.setFacing(CompassDirection.N);
                    break;
                default:
                    throw new RuntimeException("Not able to access this location");
            }
        }
    }


    public void move(PlateauSize plateauSize) {
        if (position.getFacing().equals(CompassDirection.N) && position.getY() >= plateauSize.getCoordinateY() ||
            position.getFacing().equals(CompassDirection.E) && position.getX() >= plateauSize.getCoordinateX() ||
            position.getFacing().equals(CompassDirection.S) && position.getY() <= 0||
            position.getFacing().equals(CompassDirection.W) && position.getX() <= 0) {
            throw new IllegalArgumentException("Movement to this location is out of bounds");
        }

        switch (position.getFacing()) {
            case N:
                position.setY(position.getY() + 1);
                break;
            case E:
                position.setX(position.getX() +1);
                break;
            case S:
                position.setY(position.getY() -1);
                break;
            case W:
                position.setX(position.getX() -1);
                break;
            }
        }
    }



