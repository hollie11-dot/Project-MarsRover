import java.util.InputMismatchException;

public class InputParser {

    public Instruction checkInstruction(String input){
        String inputString = input.replace("[^LlRrMm]", "");
        if (input.isEmpty()){
            return null;
        }
        try{
            return Instruction.valueOf(inputString.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Not a valid Instruction!");
        }
        return null;
    }

    public void checkPlateauSize(String input){

    }

    public CompassDirection checkCompassDirection(String input){
        String inputString = input.replace("[^NnSsEeWw]", "");
        try{
            return CompassDirection.valueOf(inputString.toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("Not a valid Direction!");
        }
        return null;
    }
}
