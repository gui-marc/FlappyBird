package eu.marcondes.managers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;

public class AudioPlayer {
  private static AudioPlayer instance;

  public static AudioPlayer getInstance() {
    if (instance == null) {
      instance = new AudioPlayer();
    }
    return instance;
  }

  private AudioPlayer() {}

  public void playSound(AssetDescriptor<Sound> sound) {
    playSound(sound, 1, 1, 0);
  }

  public void playSound(AssetDescriptor<Sound> sound, float volume) {
    playSound(sound, volume, 1, 0);
  }

  public void playSound(AssetDescriptor<Sound> sound, float volume, float pitch) {
    playSound(sound, volume, pitch, 0);
  }

  public void playSound(AssetDescriptor<Sound> sound, float volume, float pitch, float pan) {
    Assets.get(sound).play(volume, pitch, pan);
  }
}
