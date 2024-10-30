package eu.marcondes.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class InfiniteBackgroundComponent implements Component {
  public Sprite sprite;
  public float speed;
  public float currentX;
}
