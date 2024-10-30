package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import eu.marcondes.ecs.components.PlayerComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.TransformComponent;

public class PlayerRotatorSystem extends IteratingSystem {
  private ComponentMapper<RigidBodyComponent> rm = ComponentMapper.getFor(RigidBodyComponent.class);
  private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);

  public PlayerRotatorSystem() {
    super(
        Family.all(PlayerComponent.class, RigidBodyComponent.class, TransformComponent.class)
            .get());
  }

  @Override
  protected void processEntity(Entity entity, float v) {
    RigidBodyComponent rigidBody = rm.get(entity);
    TransformComponent transform = tm.get(entity);

    float targetRotation = Math.signum(rigidBody.velocity.y) * 15;
    transform.rotation += (targetRotation - transform.rotation) * 0.1f;
  }
}
