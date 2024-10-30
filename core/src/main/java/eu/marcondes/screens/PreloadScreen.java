package eu.marcondes.screens;

import com.badlogic.gdx.ScreenAdapter;
import eu.marcondes.FlappyBird;
import eu.marcondes.managers.Assets;

public class PreloadScreen extends ScreenAdapter {
  @Override
  public void show() {
    Assets.getInstance().load();
    FlappyBird.getInstance().setScreen(new GameScreen());
  }
}
