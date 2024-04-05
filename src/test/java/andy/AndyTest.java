package andy;

import com.google.inject.Inject;
import components.HorizontalScrollComponent;
import extenstions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ChatPage;
import pages.MainPage;
import pages.SettingsPage;
import pages.StatsPage;

@ExtendWith(AppiumExtension.class)
public class AndyTest {
  @Inject
  private MainPage mainPage;
  @Inject
  private ChatPage chatPage;
  @Inject
  private SettingsPage settingsPage;
  @Inject
  private StatsPage statsPage;

  @Inject
  private HorizontalScrollComponent scrollComponent;

  @Test
  void shouldStartExercise() {

    mainPage.open()
            .passGreetingWidget();
    scrollComponent
            .clickExerciseBtn()
            .checkPageTitle()
            .clickStartBtn();
    chatPage.isOpen();
  }

  @Test
  void shouldOpenSettingPage(){

    mainPage.open()
            .passGreetingWidget();
    scrollComponent
            .clickStatsBtn()
            .clickSettingsBtn();
    settingsPage.checkSettingsPage();
  }

  @Test
  void shouldOpenTranslationPage(){

    mainPage.open()
            .passGreetingWidget();
    scrollComponent
            .clickStatsBtn()
            .clickSettingsBtn();
    settingsPage
            .clickTranslationsBtn();
  }
}
