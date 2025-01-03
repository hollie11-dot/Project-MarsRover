import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverVehicleTest {

    @Test
    @DisplayName("Turns left based on input direction")
    void testRotateTurnsLeft() {
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
        roverVehicle.move(new PlateauSize(5, 5));
        assertEquals(4, roverVehicle.getYCoordinates());
    }

    @Test
    @DisplayName("Test that X co-ordinate increments when Rover moves forward from East facing position")
    void testMoveGoesEast (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.E), "movingRover");
        roverVehicle.move(new PlateauSize(5, 5));
        assertEquals(2, roverVehicle.getXCoordinates());
    }

    @Test
    @DisplayName("Test that X co-ordinate decrements when Rover moves forward from West facing position")
    void testMoveGoesWest (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(2, 3, CompassDirection.W), "movingRover");
        roverVehicle.move(new PlateauSize(5, 5));
        assertEquals(1, roverVehicle.getXCoordinates());
    }

    @Test
    @DisplayName("Test that Y co-ordinate decrements when Rover moves forward from South facing position")
    void testMoveGoesSouth (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(2, 3, CompassDirection.S), "movingRover");
        roverVehicle.move(new PlateauSize(5,5));
        assertEquals(2, roverVehicle.getYCoordinates());
    }

    @Test
    @DisplayName("Test an exception is thrown when Rover moves out of bounds when facing North")
    void testExceptionThrownWhenRoverMovesOutOfBoundsNorth (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(5, 5, CompassDirection.N), "movingRover");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> roverVehicle.move(new PlateauSize(5,5)));
        assertEquals("Movement to this location is out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Test an exception is thrown when Rover moves out of bounds when facing East")
    void testExceptionThrownWhenRoverMovesOutOfBoundsEast (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(5, 5, CompassDirection.E), "movingRover");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> roverVehicle.move(new PlateauSize(5,5)));
        assertEquals("Movement to this location is out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Test an exception is thrown when Rover moves out of bounds when facing South")
    void testExceptionThrownWhenRoverMovesOutOfBoundsSouth (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(5, 0, CompassDirection.S), "movingRover");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> roverVehicle.move(new PlateauSize(5,5)));
        assertEquals("Movement to this location is out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Test an exception is thrown when Rover moves out of bounds when facing West")
    void testExceptionThrownWhenRoverMovesOutOfBoundsWest (){
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(0, 5, CompassDirection.W), "movingRover");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> roverVehicle.move(new PlateauSize(5,5)));
        assertEquals("Movement to this location is out of bounds", exception.getMessage());
    }
}