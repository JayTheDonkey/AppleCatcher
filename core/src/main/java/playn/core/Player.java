package playn.core;


import com.google.gwt.user.client.Timer;
import com.google.gwt.animation.client.AnimationScheduler;
import playn.core.Entity;
import playn.core.Image;
import playn.scene.GroupLayer;

public class Player extends Entity {

    protected int score;

    public Player(GroupLayer gameLayer, double[] tempCoords, double[] tempVelocity, Image tempImage, int tempScore){
        super( gameLayer, tempCoords, tempVelocity, tempImage);
        score = tempScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newValue){
        score = newValue;
    }

    public void incrementScore(int value){
        score += value;
    }

    

}
