package org.example.rover;

import org.example.direction.CompassDirection;

public class RoverPosition {
    private int x;
    private int y;
    private CompassDirection facing;

    public RoverPosition(int x, int y, CompassDirection facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CompassDirection getFacing() {
        return facing;
    }

    public void setFacing(CompassDirection facing) {
        this.facing = facing;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "RoverPosition{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + facing +
                '}';
    }
}
