package playn.html;

import playn.core.Image;

/**
 * Created by JackassNoonNerd on 9/15/16.
 */
public class Player extends Entity{

    protected Image[] animations;
    protected int score;
    protected int frameIndex = 1; //where you are in the animations array

    public Player(int[] tempCoords, int[] tempVelocity, Image tempImage, Image[] tempAnimations, int tempScore){
        super( tempCoords, tempVelocity, tempImage);

        animations = tempAnimations;
        score = tempScore;
    }
    public void Animate(){ //call this in game loop when key is press (player is moving)
        image = animations[frameIndex]; //switches between last two images in animations every game tick
        if (frameIndex == 1){
            frameIndex++;
        }
        else {
            frameIndex = 1;  //CHARLIE: you should do the timer task magic here
        }
    }
    public int getScore() {
        return score;
    }
    public void setScore(int newValue){
        score = newValue;
    }

}
