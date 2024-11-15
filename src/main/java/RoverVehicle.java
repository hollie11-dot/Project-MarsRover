import static javax.swing.text.html.HTML.Attribute.N;

public class RoverVehicle {
    private RoverPosition position;
    private String name;
    private CompassDirection direction;


    public RoverVehicle(RoverPosition position, String name) {
        this.position = position;
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

    public void turnLeft(Instruction left) {
        switch (direction) {
            case N:
                direction = CompassDirection.W;
                break;
            case W:
                direction = CompassDirection.S;
                break;
            case S:
                direction = CompassDirection.E;
                break;
            case E:
                direction = CompassDirection.N;
                break;
            default:
                throw new RuntimeException("Not able to access this location");
        }
    }

    public void turnRight(Instruction right) {
        switch (direction) {
            case N:
                direction = CompassDirection.E;
                break;
            case E:
                direction = CompassDirection.S;
                break;
            case S:
                direction = CompassDirection.W;
                break;
            case W:
                direction = CompassDirection.N;
                break;
            default:
                throw new RuntimeException("Not able to access this location");
        }
    }
    public RoverPosition move(CompassDirection direction)
}


