package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import eu.marcondes.ecs.components.PlayerComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;

public class PlayerControllerSystem extends IteratingSystem {
  public final float JUMP_VELOCITY = 400;

  private final ComponentMapper<RigidBodyComponent> rm =
      ComponentMapper.getFor(RigidBodyComponent.class);

  public PlayerControllerSystem() {
    super(Family.all(PlayerComponent.class, RigidBodyComponent.class).get());
  }

  @Override
  public void processEntity(Entity entity, float deltaTime) {
    RigidBodyComponent rigidBody = rm.get(entity);

    if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
      rigidBody.velocity.y = JUMP_VELOCITY;
    }
  }
}
