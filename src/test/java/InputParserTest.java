import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("Returns null if passed an empty string")
    void checkInstructionIfStringEmpty() {
        //Arrange
        InputParser testCase = new InputParser();
        String test = "";
        //Act
        Instruction result = testCase.checkInstruction(test);
        //Assert
        assertNull(result);
    }

    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkIstructionIfSingleInputValid() {
        InputParser testCase = new InputParser();
        String test = "L";
        Instruction result = testCase.checkInstruction(test);
        assertEquals(Instruction.L, result);

    }

    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkIstructionIfMultipleInputValid() {
        InputParser testCase = new InputParser();
        String test = "LRM";
        Instruction result = testCase.checkInstruction(test);
        assertEquals(Instruction.L, result);

    }
}