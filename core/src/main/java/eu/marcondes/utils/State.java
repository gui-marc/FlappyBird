package eu.marcondes.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface State {
  void enter();

  void update(float deltaTime);

  void render(SpriteBatch batch, float deltaTime);

  void exit();
}
