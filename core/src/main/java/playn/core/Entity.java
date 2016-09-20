package playn.core;

import playn.core.Image;

/**
 * Created by JackassNoonNerd on 9/15/16.
 */
public class Entity {

    protected int[] coords = new int[2];
    protected int[] velocity = new int[2];
    protected Image image;

    public Entity(int[] tempCoords, int[] tempVelocity, Image tempImage ){
        coords = tempCoords;
        velocity = tempVelocity;
        image = tempImage;
    }

    public int[] getCoords() { //X coord is the int at index zero of the coords array
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public int[] getVelocity() {
        return velocity;
    }

    public void setVelocity(int[] velocity) {
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
