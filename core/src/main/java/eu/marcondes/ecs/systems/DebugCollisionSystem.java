package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import eu.marcondes.ecs.components.BodyComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.TransformComponent;

public class DebugCollisionSystem extends IteratingSystem {
  private final ShapeRenderer shapeRenderer = new ShapeRenderer();

  public DebugCollisionSystem() {
    super(Family.all(RigidBodyComponent.class, TransformComponent.class).get());
  }

  private final ComponentMapper<RigidBodyComponent> rbm =
      ComponentMapper.getFor(RigidBodyComponent.class);

  private final ComponentMapper<TransformComponent> tm =
      ComponentMapper.getFor(TransformComponent.class);

  @Override
  protected void processEntity(Entity entity, float v) {
    RigidBodyComponent rc = rbm.get(entity);
    TransformComponent tc = tm.get(entity);

    // Draw collision shape
    shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
    shapeRenderer.setColor(Color.GREEN);
    if (rc.collisionShape instanceof com.badlogic.gdx.math.Rectangle rect) {
      shapeRenderer.rotate(0, 0, 0, tc.rotation);
      shapeRenderer.rect(tc.x + rect.x, tc.y + rect.y, rect.width, rect.height);
    } else if (rc.collisionShape instanceof com.badlogic.gdx.math.Circle circle) {
      shapeRenderer.circle(tc.x + circle.x, tc.y + circle.y, circle.radius);
    } else if (rc.collisionShape instanceof com.badlogic.gdx.math.Polygon polygon) {
      shapeRenderer.polygon(polygon.getTransformedVertices());
    }
    shapeRenderer.end();
  }
}
