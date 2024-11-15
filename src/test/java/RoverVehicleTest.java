import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverVehicleTest {

    @Test
    @DisplayName("Turns left based on input direction")
    void testRotateTurnsLeft() {
        //Arrange
        RoverVehicle testCase = new RoverVehicle();
        CompassDirection testDirection = CompassDirection.N;
        CompassDirection testDirection2 = CompassDirection.E;
        CompassDirection testDirection3 = CompassDirection.S;
        CompassDirection testDirection4 = CompassDirection.W;
        Instruction testInstruction = Instruction.L;

        Assertions.assertAll(
                "Grouped assertions of instructions to turn left",
                () -> assertEquals(CompassDirection.W, testCase.rotate(testDirection, testInstruction)),
                () -> assertEquals(CompassDirection.N, testCase.rotate(testDirection2, testInstruction)),
                () -> assertEquals(CompassDirection.E, testCase.rotate(testDirection3, testInstruction)),
                () -> assertEquals(CompassDirection.S, testCase.rotate(testDirection4, testInstruction))
                );

    }

    @Test
    @DisplayName("Turns left based on input direction")
    void testRotateTurnsRight() {
    //Arrange
    RoverVehicle testCase = new RoverVehicle();
    CompassDirection testDirection = CompassDirection.N;
        CompassDirection testDirection2 = CompassDirection.E;
        CompassDirection testDirection3 = CompassDirection.S;
        CompassDirection testDirection4 = CompassDirection.W;

    Instruction testInstruction = Instruction.R;
        Assertions.assertAll(
                "Grouped assertions of instructions to turn right",
                () -> assertEquals(CompassDirection.E, testCase.rotate(testDirection, testInstruction)),
                () -> assertEquals(CompassDirection.S, testCase.rotate(testDirection2, testInstruction)),
                () -> assertEquals(CompassDirection.W, testCase.rotate(testDirection3, testInstruction)),
                () -> assertEquals(CompassDirection.N, testCase.rotate(testDirection4, testInstruction))
        );

}
}