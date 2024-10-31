package eu.marcondes.ecs.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import eu.marcondes.ecs.components.TimerComponent;

public class TimerSystem extends IteratingSystem {
  public TimerSystem() {
    super(Family.all(TimerComponent.class).get());
  }

  ComponentMapper<TimerComponent> tm = ComponentMapper.getFor(TimerComponent.class);

  @Override
  protected void processEntity(Entity entity, float deltaTime) {
    TimerComponent timer = tm.get(entity);
    timer.currentTime += deltaTime;

    if (timer.currentTime >= timer.maxTime) {
      timer.currentTime = 0;
      timer.notifyTimeout();
      if (!timer.repeat) {
        entity.remove(TimerComponent.class);
      }
    }
  }
}
