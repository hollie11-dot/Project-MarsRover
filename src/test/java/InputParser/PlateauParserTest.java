package InputParser;

import org.example.inputparser.InputParser;
import org.example.inputparser.PlateauParser;
import org.example.plateau.PlateauSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauParserTest {
    private PlateauParser testCase;

    @BeforeEach
    public void setUpTestCase() {
    testCase = new PlateauParser();
    }

    @Test
    @DisplayName("Returns exception when passed co-ordinates of invalid length")
    void checkPlateauSizeWithInvalidLengthInput() throws Exception {
        String input = "1, 2, 3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.checkPlateauSize(input));
        assertEquals("Please enter two co-ordinates for the plateau size", exception.getMessage());
    }

    @Test
    @DisplayName("Returns exception when passed negative numbers")
    void checkPlateauSizeWithNegativeNumber() throws Exception {
        String input = "-1, 4";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testCase.checkPlateauSize(input));
        assertEquals("Cannot be a negative number!", exception.getMessage());
        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("Returns new PlataeuSize when passed valid numbers")
    void checkPlateuaSizeWithValidNumber() throws Exception {
        String input = "5, 5";
        PlateauSize result = testCase.checkPlateauSize(input);
        assertEquals(5, result.getCoordinateX());
        assertEquals(5, result.getCoordinateY());
    }
}
