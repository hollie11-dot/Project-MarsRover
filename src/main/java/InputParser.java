import java.util.ArrayList;
import java.util.InputMismatchException;

public class InputParser {

    public ArrayList<Instruction> checkInstruction(String[] input){
        if (input.length ==0){
            return null;
        }
        ArrayList<Instruction> validInputs= new ArrayList<>();
        for (String value: input){
            if (value.matches("[LlRrMm]+")) {
                for (char c : value.toCharArray()) {
                    validInputs.add(Instruction.valueOf(String.valueOf(c).toUpperCase()));
                }
            }
            else throw new IllegalArgumentException("Not a valid instruction!");
        }
        return validInputs;
    }

    public PlateauSize checkPlateauSize(int height, int width) {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("Cannot be a negative number!");
        }
        return new PlateauSize(height, width);
    }

    public ArrayList<CompassDirection> checkCompassDirection(String[] input){
        if (input.length ==0){
            return null;
        }
        ArrayList<CompassDirection> validInputs= new ArrayList<>();
        for (String value: input){
            if (value.matches("[NnSsEeWw]+")) {
                for (char c : value.toCharArray()) {
                    validInputs.add(CompassDirection.valueOf(String.valueOf(c).toUpperCase()));
                }
            }
            else throw new IllegalArgumentException("Not a valid direction!");
        }
        return validInputs;
    }

}
