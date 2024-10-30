package eu.marcondes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import eu.marcondes.managers.Assets;
import eu.marcondes.screens.PreloadScreen;
import eu.marcondes.state.GameState;
import eu.marcondes.state.MenuState;
import eu.marcondes.utils.StateMachine;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class FlappyBird extends Game {
  private static FlappyBird instance;

  public static FlappyBird getInstance() {
    return instance;
  }

  public FlappyBird() {
    super();
    instance = this;
  }

  public static final boolean DEBUG = true;

  @Override
  public void create() {
    this.setScreen(new PreloadScreen());
  }
}
