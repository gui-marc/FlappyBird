package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.TransformComponent;
import eu.marcondes.managers.Assets;

public class MovementSystem extends IteratingSystem {
  public static float GRAVITY = -980f;

  private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
  private ComponentMapper<RigidBodyComponent> rm = ComponentMapper.getFor(RigidBodyComponent.class);

  public MovementSystem() {
    super(Family.all(TransformComponent.class, RigidBodyComponent.class).get());
  }

  @Override
  public void processEntity(Entity entity, float deltaTime) {
    TransformComponent transform = tm.get(entity);
    RigidBodyComponent rigidBody = rm.get(entity);

    rigidBody.velocity.y += GRAVITY * deltaTime;

    transform.x += rigidBody.velocity.x * deltaTime;
    transform.y += rigidBody.velocity.y * deltaTime;

    if (transform.y < Assets.get(Assets.BASE_TEXTURE).getHeight()) {
      transform.y = Assets.get(Assets.BASE_TEXTURE).getHeight();
      rigidBody.velocity.y = 0;
    }
  }
}
