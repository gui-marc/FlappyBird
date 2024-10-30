package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.ecs.components.TransformComponent;

public class SpriteRendererSystem extends IteratingSystem {
  private final SpriteBatch batch;

  private final ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);
  private final ComponentMapper<TransformComponent> tm =
      ComponentMapper.getFor(TransformComponent.class);

  public SpriteRendererSystem() {
    super(Family.all(SpriteComponent.class, TransformComponent.class).get());
    this.batch = new SpriteBatch();
  }

  @Override
  public void addedToEngine(Engine engine) {
    super.addedToEngine(engine);
  }

  @Override
  protected void processEntity(Entity entity, float v) {
    SpriteComponent sc = sm.get(entity);
    TransformComponent tc = tm.get(entity);

    batch.begin();
    batch.draw(
        sc.sprite,
        tc.x,
        tc.y,
        sc.sprite.getOriginX(),
        sc.sprite.getOriginY(),
        sc.sprite.getWidth(),
        sc.sprite.getHeight(),
        tc.scale,
        tc.scale,
        tc.rotation);
    batch.end();
  }
}
