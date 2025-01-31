package PlateuaSize;

import org.example.direction.CompassDirection;
import org.example.plateau.PlateauSize;
import org.example.rover.RoverPosition;
import org.example.rover.RoverVehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauSizeTest {

    @Test
    @DisplayName("Returns exception when rover landing out of bounds")
    public void testRoverWhenLandingOutOfBounds() {
        PlateauSize testCase = new PlateauSize(5, 5);
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(5, 6, CompassDirection.N), "TestRover");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.addRover(roverVehicle));
        assertEquals("Rover is not within plateau bounds. Unable to land here", exception.getMessage());
    }

//    @Test
//    @DisplayName("Returns exception when rover landing on occupied plateau space")
//    public void testRoverWhenLandingOnOccupiedSpace() {
//        PlateauSize plateauSize = new PlateauSize(5, 5);
//        RoverVehicle roverVehicle1 = new RoverVehicle(new RoverPosition(1, 2, CompassDirection.N), "TestRover1");
//        plateauSize.addRover(roverVehicle1);
//        RoverVehicle roverVehicle2 = new RoverVehicle(new RoverPosition(1, 2, CompassDirection.N), "TestRover2");
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> plateauSize.addRover(roverVehicle2));
//        assertEquals("There is a Rover at this position. Unable to land here", exception.getMessage());
//    }

    @Test
    public void checkIsOccupied(){
        PlateauSize plateauSize = new PlateauSize(5, 5);
        RoverVehicle roverVehicle = new RoverVehicle(new RoverPosition(1, 2, CompassDirection.N), "Rover1");
        RoverVehicle roverVehicle2 = new RoverVehicle(new RoverPosition(1, 3, CompassDirection.N), "Rover2");
        RoverVehicle roverVehicle3 = new RoverVehicle(new RoverPosition(1, 2, CompassDirection.N), "Rover1Copy");
        plateauSize.addRover(roverVehicle);
        assertTrue(plateauSize.isOccupied(roverVehicle3.getPosition()));
        assertFalse(plateauSize.isOccupied(roverVehicle2.getPosition()));
    }
}

