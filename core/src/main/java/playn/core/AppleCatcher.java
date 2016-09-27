package playn.core;

import playn.core.Image;
import playn.core.Platform;
import playn.scene.ImageLayer;
import playn.scene.SceneGame;
import playn.scene.GroupLayer;

import java.util.ArrayList;

public class AppleCatcher extends SceneGame {

  protected Player player;
  protected ArrayList<Apple> apples;
  protected int appleTime = 90; //starting number of game ticks per apple spawn
  protected int updateTicks;
  protected GroupLayer gameLayer;

  public AppleCatcher (Platform plat) {
    super(plat, 33); // update our "simulation" 33ms (30 times per second)

    // create and add background image layer
    Image bgImage = plat.assets().getImage("images/background.png");
    ImageLayer bgLayer = new ImageLayer(bgImage);
    // scale the background to fill the screen
    bgLayer.setSize(plat.graphics().viewSize);
    rootLayer.add(bgLayer);
    rootLayer.add(gameLayer);

    player = new Player(gameLayer, new double[]{0, 0}, new double[]{0, 0}, plat.assets().getImage("images/player.png"),0);

  }


  public boolean checkCollision(Apple apple, Player player){

    double[] appleCenter ={apple.x()+apple.getImage().width(),apple.y()+apple.getImage().height()};
    return ((appleCenter[0] > player.x() && appleCenter[0] < player.x()+player.getImage().width())&&(appleCenter[1] > player.y() && appleCenter[1] < player.y()+player.getImage().height()));
  }

  public void updateAppleTime(int score){
    //TODO fancy algorithm to increase game pace based on score
  }

  @Override public void update(Clock clock){
    super.update(clock);
    //check to see if its time to add another apple
    if (updateTicks == appleTime){
      apples.add(new Apple(gameLayer,new double[]{Math.random()*800, 0}, new double[2], plat.assets().getImage("images/apple.png"))); //TODO make the apple spawn relative to game windows size
      updateTicks =0;
      updateAppleTime(player.getScore());
    }
    //check to see if player caught an apple
    for (int i =0; i < apples.size();i++){
      if (checkCollision(apples.get(i), player)){
        apples.remove(i);
        player.incrementScore(10);
      }
    }
    //move entities
    for (int i=0; i < apples.size();i++){
      apples.get(i).move();
    }
    player.move();

    updateTicks++;
  }

  @Override public void paint(Clock clock){
    super.update(clock);

  }
}
