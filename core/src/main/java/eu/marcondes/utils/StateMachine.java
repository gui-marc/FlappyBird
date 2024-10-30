package eu.marcondes.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateMachine<T extends State> {
  private T currentState;

  public StateMachine() {
    currentState = null;
  }

  public StateMachine(T initialState) {
    currentState = initialState;
  }

  public T getCurrentState() {
    return currentState;
  }

  public void changeState(T nextState) {
    if (this.currentState != null) {
      this.currentState.exit();
    }
    this.currentState = nextState;
    this.currentState.enter();
  }

  public void update(float deltaTime) {
    currentState.update(deltaTime);
  }

  public void render(SpriteBatch batch, float deltaTime) {
    currentState.render(batch, deltaTime);
  }
}
