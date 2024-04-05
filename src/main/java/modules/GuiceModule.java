package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import pages.ChatPage;
import pages.MainPage;
import pages.SettingsPage;
import pages.StatsPage;

public class GuiceModule extends AbstractModule {

  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage();
  }

  @Provides
  @Singleton
  public ChatPage getChatPage() {
    return new ChatPage();
  }

  @Provides
  @Singleton
  public SettingsPage getSettingsPage() {
    return new SettingsPage();
  }

  @Provides
  @Singleton
  public StatsPage getStatsPage() {
    return new StatsPage();
  }


}
