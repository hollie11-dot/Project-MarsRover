import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverVehicleTest {

    @Test
    @DisplayName("Turns left based on input direction")
    void testRotateTurnsLeft() {
        //Arrange
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.N), "Rover1");

        roverVehicle.rotate(Instruction.L);
        assertEquals(roverVehicle.getDirection(), CompassDirection.W);

        roverVehicle.rotate(Instruction.L);
        assertEquals(roverVehicle.getDirection(), CompassDirection.S);

        roverVehicle.rotate(Instruction.L);
        assertEquals(roverVehicle.getDirection(), CompassDirection.E);

        roverVehicle.rotate(Instruction.L);
        assertEquals(roverVehicle.getDirection(), CompassDirection.N);
    }

    @Test
    @DisplayName("Turns right based on input direction")
    void testRotateTurnsRight() {
        //Arrange
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.N), "Rover2");

        roverVehicle.rotate(Instruction.R);
        assertEquals(roverVehicle.getDirection(), CompassDirection.E);

        roverVehicle.rotate(Instruction.R);
        assertEquals(roverVehicle.getDirection(), CompassDirection.S);

        roverVehicle.rotate(Instruction.R);
        assertEquals(roverVehicle.getDirection(), CompassDirection.W);

        roverVehicle.rotate(Instruction.R);
        assertEquals(roverVehicle.getDirection(), CompassDirection.N);
    }

    @Test
    @DisplayName("Test that Y co-ordinate increments when Rover moves forward from North facing position")
    void testMoveGoesNorth (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.N), "movingRover");
        roverVehicle.move(Instruction.M);
        assertEquals(4, roverVehicle.getYCoordinates());
    }

    @Test
    @DisplayName("Test that X co-ordinate increments when Rover moves forward from East facing position")
    void testMoveGoesEast (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.E), "movingRover");
        roverVehicle.move(Instruction.M);
        assertEquals(2, roverVehicle.getXCoordinates());
    }

    @Test
    @DisplayName("Test that X co-ordinate decrements when Rover moves forward from West facing position")
    void testMoveGoesWest (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(2, 3, CompassDirection.W), "movingRover");
        roverVehicle.move(Instruction.M);
        assertEquals(1, roverVehicle.getXCoordinates());
    }

    @Test
    @DisplayName("Test that Y co-ordinate decrements when Rover moves forward from South facing position")
    void testMoveGoesSouth (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(2, 3, CompassDirection.S), "movingRover");
        roverVehicle.move(Instruction.M);
        assertEquals(2, roverVehicle.getYCoordinates());
    }
}