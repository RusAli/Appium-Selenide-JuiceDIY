package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.HorizontalScrollComponent;
import pages.MainPage;

public class GuiceModule extends AbstractModule {

  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage();
  }

//  @Provides
//  @Singleton
//  public HorizontalScrollComponent getHorizontalScrollComponent() {
//    return new HorizontalScrollComponent();
//  }


}
