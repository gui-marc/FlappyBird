package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import eu.marcondes.ecs.components.DeleteOffScreenComponent;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.ecs.components.TransformComponent;

public class DeleteOffScreenSystem extends IteratingSystem {
  public DeleteOffScreenSystem() {
    super(
        Family.all(SpriteComponent.class, TransformComponent.class, DeleteOffScreenComponent.class)
            .get());
  }

  private ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
  private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);

  @Override
  protected void processEntity(Entity entity, float v) {
    SpriteComponent sc = sm.get(entity);
    TransformComponent tc = tm.get(entity);

    if (tc.x + sc.sprite.getWidth() < 10) {
      getEngine().removeEntity(entity);
    }
  }
}
