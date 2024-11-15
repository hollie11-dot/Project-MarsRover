import static javax.swing.text.html.HTML.Attribute.N;

public class RoverVehicle {
    private RoverPosition position;
    private String name;
    private CompassDirection direction;


    public RoverVehicle() {

    }

    public RoverPosition getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public CompassDirection getDirection() {
        return direction;
    }

    public CompassDirection rotate (CompassDirection direction, Instruction instruction) {

        if (instruction.equals(Instruction.L)) {
            switch (direction) {
                case N:
                    return CompassDirection.W;
                case W:
                    return CompassDirection.S;
                case S:
                    return CompassDirection.E;
                case E:
                    return CompassDirection.N;
                default:
                    throw new RuntimeException("Not able to access this location");
            }
        }
        if (instruction.equals(Instruction.R)) {
            switch (direction) {
                case N:
                    return CompassDirection.E;
                case E:
                    return CompassDirection.S;
                case S:
                    return CompassDirection.W;
                case W:
                    return CompassDirection.N;
                default:
                    throw new RuntimeException("Not able to access this location");
            }
        }
        return null;
    }
    public RoverPosition move(CompassDirection direction){
        return null;
    };
}


