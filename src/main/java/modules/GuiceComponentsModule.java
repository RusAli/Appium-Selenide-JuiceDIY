package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.HorizontalScrollComponent;

public class GuiceComponentsModule extends AbstractModule {

  @Provides
  @Singleton
  public HorizontalScrollComponent getHorizontalScrollComponent() {
    return new HorizontalScrollComponent();
  }
}
