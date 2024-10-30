package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import eu.marcondes.ecs.components.InfiniteBackgroundComponent;
import eu.marcondes.managers.Assets;

public class InfiniteBackgroundSystem extends IteratingSystem {
  private final SpriteBatch batch = new SpriteBatch();

  private final ComponentMapper<InfiniteBackgroundComponent> ibm =
      ComponentMapper.getFor(InfiniteBackgroundComponent.class);

  public InfiniteBackgroundSystem() {
    super(Family.all(InfiniteBackgroundComponent.class).get());
  }

  @Override
  protected void processEntity(Entity entity, float v) {
    InfiniteBackgroundComponent ibc = ibm.get(entity);

    ibc.currentX -= ibc.speed * v;

    if (ibc.currentX <= -Assets.get(Assets.BACKGROUND_DAY_TEXTURE).getWidth()) {
      ibc.currentX = 0;
    }

    batch.begin();
    batch.draw(ibc.sprite, ibc.currentX - ibc.sprite.getWidth(), 0F);
    batch.draw(ibc.sprite, ibc.currentX, 0F);
    batch.draw(ibc.sprite, ibc.currentX + ibc.sprite.getWidth(), 0F);
    batch.end();

    ibc.speed += 5f * v;
  }
}
