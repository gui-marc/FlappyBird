package eu.marcondes.state;

import eu.marcondes.utils.State;

public abstract class GameState implements State {
  public static final MenuState MENU_STATE = new MenuState();
  public static final PlayState PLAY_STATE = new PlayState();
  public static final GameOverState GAME_OVER_STATE = new GameOverState();
}
