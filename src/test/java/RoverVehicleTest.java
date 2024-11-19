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

}