package eu.marcondes.ecs.components;

import com.badlogic.gdx.math.Vector2;

public class RigidBodyComponent extends BodyComponent {
  public float mass = 1;
  public Vector2 velocity = new Vector2();
}
