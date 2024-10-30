package eu.marcondes;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;

public class FlappyBirdEngine {
  private static FlappyBirdEngine instance;

  public static FlappyBirdEngine getInstance() {
    if (instance == null) {
      instance = new FlappyBirdEngine();
    }
    return instance;
  }

  private Engine engine;

  public void init() {
    engine = new PooledEngine();
  }

  public void update(float deltaTime) {
    Gdx.app.log("FlappyBirdEngine", "Updating engine");
    engine.update(deltaTime);
  }

  public void finish() {
    engine.removeAllEntities();
    engine.removeAllSystems();
  }

  public Engine getEngine() {
    return engine;
  }
}