package playn.core;

import playn.core.Image;

public abstract class Entity {

    protected double[] coords = new double[2];
    protected double[] velocity = new double[2];
    protected Image image;

    public Entity(double[] tempCoords, double[] tempVelocity, Image tempImage ){
        coords = tempCoords;
        velocity = tempVelocity;
        image = tempImage;
    }

    public double x() { //X coord is the int at index zero of the coords array
        return coords[0];
    }

    public double y(){
        return coords[1];
    }

    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    public int[] getVelocity() {
        return new int[] {(int)velocity[0], (int)velocity[1]};
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public Image getImage() {
        return image;
    }

    public void move(){
        coords[0]+= velocity[0];
        coords[1]+= velocity[1];
    }

}
