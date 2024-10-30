package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import eu.marcondes.ecs.components.PlayerComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.managers.Assets;

public class PlayerAnimatorSystem extends IteratingSystem {
  public PlayerAnimatorSystem() {
    super(Family.all(PlayerComponent.class, RigidBodyComponent.class, SpriteComponent.class).get());
  }

  private final ComponentMapper<RigidBodyComponent> rm =
      ComponentMapper.getFor(RigidBodyComponent.class);
  private final ComponentMapper<SpriteComponent> sm = ComponentMapper.getFor(SpriteComponent.class);

  @Override
  protected void processEntity(Entity entity, float deltaTime) {
    RigidBodyComponent rigidBody = rm.get(entity);
    SpriteComponent sprite = sm.get(entity);

    if (rigidBody.velocity.y > 0) {
      sprite.sprite = new Sprite(Assets.get(Assets.YELLOW_BIRD_DOWNFLAP_TEXTURE));
    } else if (rigidBody.velocity.y < 0) {
      sprite.sprite = new Sprite(Assets.get(Assets.YELLOW_BIRD_UPFLAP_TEXTURE));
    } else {
      sprite.sprite = new Sprite(Assets.get(Assets.YELLOW_BIRD_MIDFLAP_TEXTURE));
    }
  }
}
