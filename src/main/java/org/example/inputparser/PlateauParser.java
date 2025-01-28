package org.example.inputparser;

import org.example.plateau.PlateauSize;

import java.util.Arrays;

public class PlateauParser {

    public PlateauSize checkPlateauSize(String input) {
        String[] plateauSize = input.trim().split(",\\s");
        if(plateauSize.length != 2){
            throw new IllegalArgumentException("Please enter two co-ordinates for the plateau size");
        }
        int coordinateX = Integer.parseInt(plateauSize[0]);
        int coordinateY = Integer.parseInt(plateauSize[1]);
        if (coordinateX < 0 || coordinateY < 0) {
            throw new IllegalArgumentException("Co-ordinates cannot be a negative number! Please re-enter.");
        }
        return new PlateauSize(coordinateX, coordinateY);
    }
}
