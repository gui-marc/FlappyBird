package eu.marcondes.managers;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
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

  public void load() {
    Texture.setAssetManager(manager);

    // BACKGROUND
    manager.load(BACKGROUND_DAY_TEXTURE);

    // YELLOW BIRD
    manager.load(YELLOW_BIRD_DOWNFLAP_TEXTURE);
    manager.load(YELLOW_BIRD_MIDFLAP_TEXTURE);
    manager.load(YELLOW_BIRD_UPFLAP_TEXTURE);

    manager.finishLoading();
  }

  public static <T> T get(AssetDescriptor<T> assetDescriptor) {
    return getInstance().manager.get(assetDescriptor);
  }
}
