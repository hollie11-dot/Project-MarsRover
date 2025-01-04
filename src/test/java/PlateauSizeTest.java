import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauSizeTest {

    @Test
    @DisplayName("RoverVehicle successfully added to list when passed position in bounds in addRover method")
    public void testRoverAddedWhenPassedCorrectPositionAddRoverMethod(){
        PlateauSize testCase = new PlateauSize(5,5);
        RoverVehicle testRoverVehicle = new RoverVehicle(new RoverPosition(3, 4, CompassDirection.N), "Rover1");
        testCase.addRover(testRoverVehicle);
        assertTrue(testCase.getRoverVehicleList().contains(testRoverVehicle));
    }

    @Test
    @DisplayName("Test exception thrown when passed position out of bounds in addRoverMethod")
    public void testExceptionThrownWhenPassedOutOfBoundsPositionAddRoverMethod() throws Exception {
        PlateauSize testCase = new PlateauSize(5, 5);
        RoverVehicle testRoverVehicle = new RoverVehicle(new RoverPosition(5, 6, CompassDirection.E), "Rover1");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.addRover(testRoverVehicle));
        assertEquals("Rover is not within plateau bounds. Unable to land here", exception.getMessage());
    }

    @Test
    @DisplayName("Test exception thrown when passed position already occupied in addRoverMethod")
    public void testExceptionThrownWhenPassedOccupiedPositionAddRoverMethod() throws Exception {
        PlateauSize testCase = new PlateauSize(5, 5);
        RoverVehicle testRoverVehicle = new RoverVehicle(new RoverPosition(1, 1, CompassDirection.E), "Rover1");
        List<RoverVehicle> currentRovers = testCase.getRoverVehicleList();
        currentRovers.add(new RoverVehicle(new RoverPosition(1, 1, CompassDirection.E), "Occupied Rover"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.addRover(testRoverVehicle));
        assertEquals("There is a Rover at this position. Unable to land here", exception.getMessage());
    }
}
