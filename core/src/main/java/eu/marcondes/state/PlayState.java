package eu.marcondes.state;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import eu.marcondes.FlappyBird;
import eu.marcondes.FlappyBirdEngine;
import eu.marcondes.ecs.EntityFactory;
import eu.marcondes.ecs.systems.DebugCollisionSystem;
import eu.marcondes.ecs.systems.DeleteOffScreenSystem;
import eu.marcondes.ecs.systems.InfiniteScrollSystem;
import eu.marcondes.ecs.systems.MovementSystem;
import eu.marcondes.ecs.systems.PlayerAnimatorSystem;
import eu.marcondes.ecs.systems.PlayerControllerSystem;
import eu.marcondes.ecs.systems.PlayerRotatorSystem;
import eu.marcondes.ecs.systems.SpriteRendererSystem;
import eu.marcondes.ecs.systems.StaticMovementSystem;
import eu.marcondes.ecs.systems.TimerSystem;

public class PlayState extends GameState {
  private Engine engine;

  @Override
  public void enter() {
    engine = FlappyBirdEngine.getInstance().getEngine();

    // Systems
    engine.addSystem(new InfiniteScrollSystem());
    engine.addSystem(new PlayerAnimatorSystem());
    engine.addSystem(new PlayerRotatorSystem());
    engine.addSystem(new TimerSystem());
    engine.addSystem(new SpriteRendererSystem());
    engine.addSystem(new MovementSystem());
    engine.addSystem(new StaticMovementSystem());
    engine.addSystem(new PlayerControllerSystem());
    engine.addSystem(new DeleteOffScreenSystem());
    if (FlappyBird.DEBUG) {
      engine.addSystem(new DebugCollisionSystem());
    }

    // Entities
    engine.addEntity(EntityFactory.createPlayer(engine));
    engine.addEntity(EntityFactory.infiniteBackground(engine));
    engine.addEntity(EntityFactory.infiniteForeground(engine));
    engine.addEntity(EntityFactory.pipeSpawner(engine));
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
