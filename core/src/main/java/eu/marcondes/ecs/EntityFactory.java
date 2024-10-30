package eu.marcondes.ecs;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import eu.marcondes.ecs.components.InfiniteBackgroundComponent;
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

    RigidBodyComponent rc = new RigidBodyComponent();
    player.add(rc);

    SpriteComponent sc = new SpriteComponent();
    sc.sprite = new Sprite(Assets.get(Assets.YELLOW_BIRD_MIDFLAP_TEXTURE));
    player.add(sc);

    PlayerComponent pc = new PlayerComponent();
    player.add(pc);

    return player;
  }

  public static Entity infiniteBackground(Engine engine) {
    Entity background = engine.createEntity();

    InfiniteBackgroundComponent ibc = new InfiniteBackgroundComponent();
    ibc.sprite = new Sprite(Assets.get(Assets.BACKGROUND_DAY_TEXTURE));
    ibc.speed = 200;
    ibc.currentX = 0;
    background.add(ibc);

    return background;
  }
}
