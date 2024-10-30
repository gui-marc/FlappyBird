package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import eu.marcondes.ecs.components.InfiniteScrollComponent;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.managers.Assets;

public class InfiniteScrollSystem extends IteratingSystem {
  private final SpriteBatch batch = new SpriteBatch();

  private final ComponentMapper<InfiniteScrollComponent> ism =
      ComponentMapper.getFor(InfiniteScrollComponent.class);

  private final ComponentMapper<SpriteComponent> spm =
      ComponentMapper.getFor(SpriteComponent.class);

  public InfiniteScrollSystem() {
    super(Family.all(InfiniteScrollComponent.class).get());
  }

  @Override
  protected void processEntity(Entity entity, float v) {
    SpriteComponent sc = spm.get(entity);
    InfiniteScrollComponent isc = ism.get(entity);

    isc.currentX -= isc.speed * v;

    if (isc.currentX <= -Assets.get(Assets.BACKGROUND_DAY_TEXTURE).getWidth()) {
      isc.currentX = 0;
    }

    batch.begin();
    batch.draw(sc.sprite, isc.currentX - sc.sprite.getWidth(), 0F);
    batch.draw(sc.sprite, isc.currentX, 0F);
    batch.draw(sc.sprite, isc.currentX + sc.sprite.getWidth(), 0F);
    batch.end();
  }
}
