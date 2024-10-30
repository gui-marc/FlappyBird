package eu.marcondes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class FlappyBird extends ApplicationAdapter {
  private SpriteBatch batch;
  private Texture image;

  public enum GameState {
    MENU,
    PLAYING,
    GAME_OVER
  }

  private GameState gameState = GameState.MENU;

  public final boolean DEBUG = true;

  @Override
  public void create() {
    batch = new SpriteBatch();
    image = new Texture("sprites/background-day.png");

    FlappyBirdEngine.getInstance().init();
  }

  @Override
  public void render() {
    FlappyBirdEngine.getInstance().update(Gdx.graphics.getDeltaTime());

    if (DEBUG) {
      Gdx.app.log("FPS: ", String.valueOf(Gdx.graphics.getFramesPerSecond()));
    }

    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
    batch.begin();
    batch.draw(image, 0, 0);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    image.dispose();
    FlappyBirdEngine.getInstance().finish();
  }
}
