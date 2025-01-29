package InputParser;

import org.example.direction.CompassDirection;
import org.example.inputparser.InputParser;
import org.example.rover.RoverPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    private InputParser testCase;

    @BeforeEach
    public void setUpTestCase(){
        testCase = new InputParser();
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed an empty String as an input")
    public void checkInputIfStringEmpty() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.validateInitialPosition(input));
        assertEquals("Invalid input. Please try again", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed null String as an input")
    public void checkInputIfStringNull() {
        String input = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.validateInitialPosition(input));
        assertEquals("Invalid input. Please try again", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed an input of a length not equal to three")
    public void checkInputIfStringIncorrectLength(){
        String input = "1, 2, 3, 4";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.validateInitialPosition(input));
        assertEquals("Incorrect format. Please enter landing position in the following format: '1,2,N'.", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed a negative co-ordinate")
    public void checkInputWithNegativeCoordinate(){
        String input = "1, -2, N";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.validateInitialPosition(input));
        assertEquals("Co-ordinates cannot be a negative number! Please re-enter.", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns IllegalArgumentException when passed an incorrect input for direction")
    public void checkInputWithIncorrectDirection(){
        String input = "1, 2, T";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.validateInitialPosition(input));
        assertEquals("Please enter direction facing as 'N,S,E,W'.", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns new RoverPosition when passed correct inputs")
    public void checkInputWithCorrectInputs(){
        String input = "1, 2, N";
        RoverPosition result = testCase.validateInitialPosition(input);
        assertEquals(1, result.getX());
        assertEquals(2, result.getY());
        assertEquals(CompassDirection.N, result.getFacing());
    }

}
