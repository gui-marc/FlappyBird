package eu.marcondes.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;

import java.util.List;
import java.util.function.Function;

public class SpawnerComponent implements Component {
  public List<Function<Engine, Entity>> entityFactories;
}
