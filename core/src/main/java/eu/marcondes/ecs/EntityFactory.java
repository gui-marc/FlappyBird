package eu.marcondes.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import eu.marcondes.ecs.components.DeleteOffScreenComponent;
import eu.marcondes.ecs.components.InfiniteScrollComponent;
import eu.marcondes.ecs.components.PlayerComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.SpawnerComponent;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.ecs.components.StaticBodyComponent;
import eu.marcondes.ecs.components.TimerComponent;
import eu.marcondes.ecs.components.TransformComponent;
import eu.marcondes.managers.Assets;

import java.util.List;

public class EntityFactory {
  public static Entity createPlayer(Engine engine) {
    Entity player = engine.createEntity();

    TransformComponent tc = new TransformComponent();
    tc.x = 30;
    tc.y = 250;
    player.add(tc);

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.YELLOW_BIRD_MIDFLAP_TEXTURE));
    player.add(sc);

    PlayerComponent pc = new PlayerComponent();
    player.add(pc);

    RigidBodyComponent rc = new RigidBodyComponent();
    rc.collisionShape = new Circle(sc.sprite.getWidth() / 2f, sc.sprite.getHeight() / 2f, 10);
    player.add(rc);

    return player;
  }

  public static Entity infiniteBackground(Engine engine) {
    Entity background = engine.createEntity();

    InfiniteScrollComponent ibc = new InfiniteScrollComponent();
    ibc.speed = 100;
    ibc.currentX = 0;
    background.add(ibc);

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.BACKGROUND_DAY_TEXTURE));
    background.add(sc);

    return background;
  }

  public static Entity infiniteForeground(Engine engine) {
    Entity foreground = engine.createEntity();

    InfiniteScrollComponent ifc = new InfiniteScrollComponent();
    ifc.speed = 200;
    ifc.currentX = 0;
    foreground.add(ifc);

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.BASE_TEXTURE));
    foreground.add(sc);

    return foreground;
  }

  public static Entity pipeUp(Engine engine) {
    Entity pipe = engine.createEntity();

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.PIPE_GREEN_TEXTURE));
    pipe.add(sc);

    TransformComponent tc = new TransformComponent();
    tc.x = 400;
    tc.y = -150;
    pipe.add(tc);

    StaticBodyComponent sbc = new StaticBodyComponent();
    sbc.collisionShape = new Rectangle(0, 0, sc.sprite.getWidth(), sc.sprite.getHeight());
    sbc.velocity = new Vector2(-200, 0);
    pipe.add(sbc);

    DeleteOffScreenComponent dosc = new DeleteOffScreenComponent();
    pipe.add(dosc);

    return pipe;
  }

  public static Entity pipeDown(Engine engine) {
    Entity pipe = engine.createEntity();

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.PIPE_GREEN_TEXTURE));
    sc.sprite.flip(false, true);
    pipe.add(sc);

    TransformComponent tc = new TransformComponent();
    tc.x = 400;
    tc.y = -50 + sc.sprite.getHeight();
    pipe.add(tc);

    StaticBodyComponent sbc = new StaticBodyComponent();
    sbc.collisionShape = new Rectangle(0, 0, sc.sprite.getWidth(), sc.sprite.getHeight());
    sbc.velocity = new Vector2(-200, 0);
    pipe.add(sbc);

    DeleteOffScreenComponent dosc = new DeleteOffScreenComponent();
    pipe.add(dosc);

    return pipe;
  }

  public static Entity pipeSpawner(Engine engine) {
    Entity spawner = engine.createEntity();

    TimerComponent tc = new TimerComponent();
    tc.maxTime = 1f;
    tc.repeat = true;
    spawner.add(tc);

    SpawnerComponent sc = new SpawnerComponent();
    sc.entityFactories = List.of(EntityFactory::pipeUp, EntityFactory::pipeDown);
    spawner.add(sc);

    tc.onTimeout(
        () -> {
          float offsetY = (float) Math.random() * 150;
          sc.entityFactories.forEach(
              factory -> {
                Entity entity = factory.apply(engine);
                entity.getComponent(TransformComponent.class).y += offsetY;
                engine.addEntity(entity);
              });
        });

    return spawner;
  }
}
