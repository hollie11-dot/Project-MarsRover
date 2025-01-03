public class PlateauSize {

    private int height;
    private int width;

    public PlateauSize(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkIsWithinBoundary(RoverPosition position){
        return (position.getY() >=0 && position.getY() < height) && (position.getX() >= 0 && position.getX() < width);
    }
}
