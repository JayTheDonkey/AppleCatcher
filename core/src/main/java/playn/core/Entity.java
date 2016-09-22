package playn.core;

import playn.core.Image;
import playn.scene.GroupLayer;
import playn.scene.ImageLayer;
import playn.scene.Layer;

public abstract class Entity {

    protected double[] coords = new double[2];
    protected double[] velocity = new double[2];
    protected Image image;

    public Entity(GroupLayer gameLayer, double[] tempCoords, double[] tempVelocity, Image tempImage ){
        coords = tempCoords;
        velocity = tempVelocity;
        image = tempImage;
        ImageLayer layer = new ImageLayer(this.image);
        layer.setOrigin(ImageLayer.Origin.CENTER);
        gameLayer.addAt(layer,(float)this.x(),(float)this.y());
    }

    public double x() {
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
