import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("Returns null if passed an empty string")
    void checkInstructionIfStringEmpty() {
        //Arrange
        InputParser testCase = new InputParser();
        String[] test = new String[0];
        //Act
        ArrayList<Instruction> result = testCase.checkInstruction(test);
        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkInstructionIfSingleInputValid() {
        InputParser testCase = new InputParser();
        String[] test = new String[] {"L"};
        ArrayList<Instruction> result = testCase.checkInstruction(test);
        ArrayList<Instruction> expectedResult = new ArrayList<>();
        expectedResult.add(Instruction.L);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkInstructionIfMultipleInputValid() {
        InputParser testCase = new InputParser();
        String[] test = new String[] {"L","r","M"};
        ArrayList<Instruction> result = testCase.checkInstruction(test);
        ArrayList<Instruction> expectedResult = new ArrayList<>();
        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);
        assertEquals(expectedResult, result);

    }


//    @Test
//    @DisplayName("Returns exception when passed negative numbers")
//    void checkPlateauSizeWithNegativeNumber() throws Exception {
//        InputParser testCase = new InputParser();
//        int height = -1;
//        int width = 5;
//        PlateauSize result = testCase.checkPlateauSize(height, width);
//        assertEquals(new IllegalArgumentException("Cannot be a negative number!"),testCase.checkPlateauSize(height, width));
//    }

        @Test
        @DisplayName("Returns new PlataeuSize when passed valid numbers")
        void checkPlateuaSizeWithValidNumber() throws Exception {
            InputParser testCase = new InputParser();
            int height = 5;
            int width = 5;
            PlateauSize result = testCase.checkPlateauSize(height, width);
            assertEquals(5, result.height);
            assertEquals(5, result.width);
    }

    @Test
    @DisplayName("Returns null if passed an empty string")
    void checkCompassDirectionIfStringEmpty() {
        //Arrange
        InputParser testCase = new InputParser();
        String[] test = new String[0];
        //Act
        ArrayList<CompassDirection> result = testCase.checkCompassDirection(test);
        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Returns CompassDirection when passed valid input")
    void checkCompassDirectionIfSingleInputValid() {
        InputParser testCase = new InputParser();
        String[] test = new String[] {"W"};
        ArrayList<CompassDirection> result = testCase.checkCompassDirection(test);
        ArrayList<CompassDirection> expectedResult = new ArrayList<>();
        expectedResult.add(CompassDirection.W);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Returns CompassDirection when passed valid input")
    void checkCompassDirectionIfMultipleInputValid() {
        InputParser testCase = new InputParser();
        String[] test = new String[]{"s", "N", "E"};
        ArrayList<CompassDirection> result = testCase.checkCompassDirection(test);
        ArrayList<CompassDirection> expectedResult = new ArrayList<>();
        expectedResult.add(CompassDirection.S);
        expectedResult.add(CompassDirection.N);
        expectedResult.add(CompassDirection.E);
        assertEquals(expectedResult, result);
    }

        @Test
        @DisplayName("Returns CompassDirection when passed valid input per string")
        void checkCompassDirectionIfMultipleInputValidPerString() {
            InputParser testCase = new InputParser();
            String[] test = new String[] {"sNE","NE","Ew"};
            ArrayList<CompassDirection> result = testCase.checkCompassDirection(test);
            ArrayList<CompassDirection> expectedResult = new ArrayList<>();
            expectedResult.add(CompassDirection.S);
            expectedResult.add(CompassDirection.N);
            expectedResult.add(CompassDirection.E);
            expectedResult.add(CompassDirection.N);
            expectedResult.add(CompassDirection.E);
            expectedResult.add(CompassDirection.E);
            expectedResult.add(CompassDirection.W);
            assertEquals(expectedResult, result);

    }
}