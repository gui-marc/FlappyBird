package eu.marcondes.ecs.components;

import com.badlogic.ashley.core.Component;

import java.util.ArrayList;
import java.util.List;

public class TimerComponent implements Component {
  private final List<Runnable> subscribers = new ArrayList<>();

  public float currentTime = 0f;
  public float maxTime = 0f;
  public boolean repeat = false;

  public float getTimeLeft() {
    return maxTime - currentTime;
  }

  public void onTimeout(Runnable runnable) {
    subscribers.add(runnable);
  }

  public void notifyTimeout() {
    subscribers.forEach(Runnable::run);
  }
}
