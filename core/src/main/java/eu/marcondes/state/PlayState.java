package eu.marcondes.state;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import eu.marcondes.FlappyBird;
import eu.marcondes.FlappyBirdEngine;
import eu.marcondes.ecs.EntityFactory;
import eu.marcondes.ecs.systems.DebugCollisionSystem;
import eu.marcondes.ecs.systems.InfiniteScrollSystem;
import eu.marcondes.ecs.systems.MovementSystem;
import eu.marcondes.ecs.systems.PlayerAnimatorSystem;
import eu.marcondes.ecs.systems.PlayerControllerSystem;
import eu.marcondes.ecs.systems.PlayerRotatorSystem;
import eu.marcondes.ecs.systems.SpriteRendererSystem;

public class PlayState extends GameState {
  private Engine engine;

  @Override
  public void enter() {
    System.out.println("Entering PlayState");
    engine = FlappyBirdEngine.getInstance().getEngine();
    engine.addSystem(new InfiniteScrollSystem());
    engine.addSystem(new PlayerAnimatorSystem());
    engine.addSystem(new PlayerRotatorSystem());
    engine.addSystem(new SpriteRendererSystem());
    engine.addSystem(new MovementSystem());
    engine.addSystem(new PlayerControllerSystem());
    if (FlappyBird.DEBUG) {
      engine.addSystem(new DebugCollisionSystem());
    }
    engine.addEntity(EntityFactory.createPlayer(engine));
    engine.addEntity(EntityFactory.infiniteBackground(engine));
    engine.addEntity(EntityFactory.infiniteForeground(engine));
  }

  @Override
  public void update(float deltaTime) {}

  @Override
  public void render(SpriteBatch batch, float deltaTime) {}

  @Override
  public void exit() {
    engine.removeAllSystems();
    engine.removeAllEntities();
  }
}
