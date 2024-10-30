package eu.marcondes.managers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
  private static Assets instance;

  public static Assets getInstance() {
    if (instance == null) {
      instance = new Assets();
    }
    return instance;
  }

  private final AssetManager manager = new AssetManager();

  public static final AssetDescriptor<Texture> BACKGROUND_DAY_TEXTURE =
      new AssetDescriptor<>("sprites/background-day.png", Texture.class);

  public static final AssetDescriptor<Texture> YELLOW_BIRD_DOWNFLAP_TEXTURE =
      new AssetDescriptor<>("sprites/yellowbird-downflap.png", Texture.class);

  public static final AssetDescriptor<Texture> YELLOW_BIRD_MIDFLAP_TEXTURE =
      new AssetDescriptor<>("sprites/yellowbird-midflap.png", Texture.class);

  public static final AssetDescriptor<Texture> YELLOW_BIRD_UPFLAP_TEXTURE =
      new AssetDescriptor<>("sprites/yellowbird-upflap.png", Texture.class);

  public static final AssetDescriptor<Texture> BASE_TEXTURE =
      new AssetDescriptor<>("sprites/base.png", Texture.class);

  public static final AssetDescriptor<Sound> WING_SOUND =
      new AssetDescriptor<>("audio/wing.ogg", Sound.class);

  public static final AssetDescriptor<Sound> HIT_SOUND =
      new AssetDescriptor<>("audio/hit.ogg", Sound.class);

  public static final AssetDescriptor<Sound> POINT_SOUND =
      new AssetDescriptor<>("audio/point.ogg", Sound.class);

  public static final AssetDescriptor<Sound> DIE_SOUND =
      new AssetDescriptor<>("audio/die.ogg", Sound.class);

  public static final AssetDescriptor<Sound> SWOOSH_SOUND =
      new AssetDescriptor<>("audio/swoosh.ogg", Sound.class);

  public void load() {
    Texture.setAssetManager(manager);

    // BACKGROUND
    manager.load(BACKGROUND_DAY_TEXTURE);

    // BASE
    manager.load(BASE_TEXTURE);

    // YELLOW BIRD
    manager.load(YELLOW_BIRD_DOWNFLAP_TEXTURE);
    manager.load(YELLOW_BIRD_MIDFLAP_TEXTURE);
    manager.load(YELLOW_BIRD_UPFLAP_TEXTURE);

    // SOUNDS
    manager.load(WING_SOUND);
    manager.load(HIT_SOUND);
    manager.load(POINT_SOUND);
    manager.load(DIE_SOUND);
    manager.load(SWOOSH_SOUND);

    manager.finishLoading();
  }

  public static <T> T get(AssetDescriptor<T> assetDescriptor) {
    return getInstance().manager.get(assetDescriptor);
  }
}
