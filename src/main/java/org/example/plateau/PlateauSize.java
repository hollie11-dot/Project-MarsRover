package org.example.plateau;

import org.example.rover.RoverPosition;
import org.example.rover.RoverVehicle;

import java.util.ArrayList;
import java.util.List;

public class PlateauSize {

    private int coordinateX;
    private int coordinateY;
    private List<RoverVehicle> roverVehicleList = new ArrayList<>();

    public PlateauSize(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public List<RoverVehicle> getRoverVehicleList(){
        return roverVehicleList;
    }

    public boolean checkIsWithinBoundary(RoverPosition position) {
        return (position.getY() >= 0 && position.getY() < coordinateY) && (position.getX() >= 0 && position.getX() < coordinateX);
    }

    public boolean isOccupied(RoverPosition roverPosition){
        return roverVehicleList.stream()
        .anyMatch(roverVehicle -> roverVehicle.getPosition().equals(roverPosition));
        }


    public void addRover(RoverVehicle roverVehicle) {
        if(!checkIsWithinBoundary(roverVehicle.getPosition())){
        throw new IllegalArgumentException("Rover is not within plateau bounds. Unable to land here");
        }
        if(isOccupied(roverVehicle.getPosition())){
        throw new IllegalArgumentException("There is a Rover at this position. Unable to land here");
        }
        roverVehicleList.add(roverVehicle);
        System.out.println("Rover successfully landed!");
    }
}
