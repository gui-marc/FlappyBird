package eu.marcondes.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import eu.marcondes.ecs.components.InfiniteScrollComponent;
import eu.marcondes.ecs.components.PlayerComponent;
import eu.marcondes.ecs.components.RigidBodyComponent;
import eu.marcondes.ecs.components.SpriteComponent;
import eu.marcondes.ecs.components.TransformComponent;
import eu.marcondes.managers.Assets;

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
}
