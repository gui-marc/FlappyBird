package eu.marcondes.utils;

public class StateMachine<T extends State> {
  private T currentState;

  public StateMachine(T initialState) {
    currentState = initialState;
    currentState.enter();
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
}
