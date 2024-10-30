package eu.marcondes.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Shape2D;

public abstract class BodyComponent implements Component {
  public Shape2D collisionShape;
}
