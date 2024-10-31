package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import eu.marcondes.ecs.components.StaticBodyComponent;
import eu.marcondes.ecs.components.TransformComponent;

public class StaticMovementSystem extends IteratingSystem {
  public StaticMovementSystem() {
    super(Family.all(StaticBodyComponent.class, TransformComponent.class).get());
  }

  ComponentMapper<StaticBodyComponent> sbm = ComponentMapper.getFor(StaticBodyComponent.class);
  ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);

  @Override
  protected void processEntity(Entity entity, float deltaTime) {
    StaticBodyComponent sb = sbm.get(entity);
    TransformComponent tc = tm.get(entity);

    tc.x += sb.velocity.x * deltaTime;
    tc.y += sb.velocity.y * deltaTime;
  }
}
