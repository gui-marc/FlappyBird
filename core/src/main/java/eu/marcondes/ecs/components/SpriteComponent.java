package eu.marcondes.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent implements Component {
  public Sprite sprite;
  public int zIndex = 0;
}
