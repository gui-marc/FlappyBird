package eu.marcondes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import eu.marcondes.FlappyBirdEngine;
import eu.marcondes.state.GameState;
import eu.marcondes.utils.StateMachine;

public class GameScreen extends ScreenAdapter {
  private final StateMachine<GameState> gameStateStateMachine = new StateMachine<>();

  private SpriteBatch batch;

  @Override
  public void show() {
    batch = new SpriteBatch();
    FlappyBirdEngine.getInstance().init();
    gameStateStateMachine.changeState(GameState.PLAY_STATE);
  }

  @Override
  public void render(float delta) {
    ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
    gameStateStateMachine.update(delta);

    batch.begin();
    gameStateStateMachine.render(batch, delta);
    batch.end();

    FlappyBirdEngine.getInstance().update(Gdx.graphics.getDeltaTime());
  }

  @Override
  public void dispose() {
    batch.dispose();
    FlappyBirdEngine.getInstance().finish();
  }
}
