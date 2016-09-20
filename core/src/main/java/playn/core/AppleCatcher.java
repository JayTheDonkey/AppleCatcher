package playn.core;

import playn.core.Image;
import playn.core.Platform;
import playn.scene.ImageLayer;
import playn.scene.SceneGame;

public class AppleCatcher extends SceneGame {

  protected Player player;

  public AppleCatcher (Platform plat) {
    super(plat, 33); // update our "simulation" 33ms (30 times per second)

    // create and add background image layer
    Image bgImage = plat.assets().getImage("images/bg.png");
    ImageLayer bgLayer = new ImageLayer(bgImage);
    // scale the background to fill the screen
    bgLayer.setSize(plat.graphics().viewSize);

    player = new Player(new double[]{0, 0}, new double[]{0, 0}, plat.assets().getImage("images/player.png"),
            new Image[] {
                    plat.assets().getImage("images/player.png"),
                    plat.assets().getImage("images/playerMoving1.png"),
                    plat.assets().getImage("images/playerMoving2.png")},
            0);

    rootLayer.add(bgLayer);
  }

  @Override public void update(Clock clock){
    super.update(clock);
    player.move();
  }

  @Override public void paint(Clock clock){
    super.update(clock);

  }
}
