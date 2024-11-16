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

//    @Test
//    @DisplayName("Turns left based on input direction")
//    void testRotateTurnsRight() {
//    //Arrange
//    RoverVehicle testCase = new RoverVehicle(new RoverPosition(2, 5, CompassDirection.E), "Rover2");
//    CompassDirection testDirection = CompassDirection.N;
//        CompassDirection testDirection2 = CompassDirection.E;
//        CompassDirection testDirection3 = CompassDirection.S;
//        CompassDirection testDirection4 = CompassDirection.W;
//
//    Instruction testInstruction = Instruction.R;
//        Assertions.assertAll(
//                "Grouped assertions of instructions to turn right",
//                () -> assertEquals(CompassDirection.E, testCase.rotate(testDirection, testInstruction)),
//                () -> assertEquals(CompassDirection.S, testCase.rotate(testDirection2, testInstruction)),
//                () -> assertEquals(CompassDirection.W, testCase.rotate(testDirection3, testInstruction)),
//                () -> assertEquals(CompassDirection.N, testCase.rotate(testDirection4, testInstruction))
//        );
//}

}