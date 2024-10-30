package eu.marcondes.utils;

public interface State {
  void enter();

  void update(float deltaTime);

  void exit();
}
