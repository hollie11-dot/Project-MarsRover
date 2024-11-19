import static javax.swing.text.html.HTML.Attribute.N;

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

    public void interpretInstruction(Instruction instruction) {
        if (instruction.equals(Instruction.M)) {
            move(instruction);
        } else {
            rotate(instruction);
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

    public RoverPosition move(Instruction instruction){
        //N move - y increments. S move - y decrements. E - increments X, W move - decrements X
        //check bounds

        return null;

    };


}


