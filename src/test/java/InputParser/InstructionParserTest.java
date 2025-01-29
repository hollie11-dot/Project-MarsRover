package InputParser;

import org.example.direction.CompassDirection;
import org.example.inputparser.InputParser;
import org.example.inputparser.InstructionParser;
import org.example.instruction.Instruction;
import org.example.rover.RoverPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class InstructionParserTest {

    private InstructionParser testCase;

    @BeforeEach
    public void setUpTestCase(){
        testCase = new InstructionParser();
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed an empty String as an input")
    public void checkInputIfStringEmpty() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.checkInstructionInputs(input));
        assertEquals("Invalid input. Please try again", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed null String as an input")
    public void checkInputIfStringNull() {
        String input = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.checkInstructionInputs(input));
        assertEquals("Invalid input. Please try again", exception.getMessage());
        System.out.println(exception.getMessage());
    }


    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkInstructionIfSingleInputValid() {
        String input = "L";
        ArrayList<Instruction> result = testCase.checkInstructionInputs(input);
        ArrayList<Instruction> expectedResult = new ArrayList<>();
        expectedResult.add(Instruction.L);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Returns Instruction when passed valid input")
    void checkInstructionIfMultipleInputValid() {
        String input = "L,R,M";
        ArrayList<Instruction> result = testCase.checkInstructionInputs(input);
        ArrayList<Instruction> expectedResult = new ArrayList<>();
        expectedResult.add(Instruction.L);
        expectedResult.add(Instruction.R);
        expectedResult.add(Instruction.M);
        assertEquals(expectedResult, result);

    }

    @Test
    @DisplayName("Returns exception when passed invalid input")
    void checkInstructionWithInvalidInput() throws Exception {
        String input = "AbC";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.checkInstructionInputs(input));
        assertEquals("Not a valid instruction! Please only enter instructions as 'L,R,M'.", exception.getMessage());
    }








}