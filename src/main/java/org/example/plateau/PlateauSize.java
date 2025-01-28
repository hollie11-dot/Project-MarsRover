import java.util.ArrayList;
import java.util.List;

public class PlateauSize {

    private int height;
    private int width;
    private List<RoverVehicle> roverVehicleList = new ArrayList<>();

    public PlateauSize(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<RoverVehicle> getRoverVehicleList(){
        return roverVehicleList;
    }

    public boolean checkIsWithinBoundary(RoverPosition position) {
        return (position.getY() >= 0 && position.getY() < height) && (position.getX() >= 0 && position.getX() < width);
    }

    public boolean isOccupied(RoverVehicle roverVehicle){
        return roverVehicleList.stream()
        .anyMatch(roverVehicle1 -> roverVehicle.hasPosition(roverVehicle.getPosition()));
        }


    public void addRover(RoverVehicle roverVehicle) {
        if(!checkIsWithinBoundary(roverVehicle.getPosition())){
        throw new IllegalArgumentException("Rover is not within plateau bounds. Unable to land here");
        }
        if(isOccupied(roverVehicle)){
        throw new IllegalArgumentException("There is a Rover at this position. Unable to land here");
        }
        roverVehicleList.add(roverVehicle);
        System.out.println("Rover successfully landed!");
    }
}
