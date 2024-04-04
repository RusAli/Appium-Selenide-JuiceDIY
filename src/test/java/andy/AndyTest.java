package andy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.google.inject.Inject;
import components.HorizontalScrollComponent;
import extenstions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

@ExtendWith(AppiumExtension.class)
public class AndyTest {
  @Inject
  private MainPage mainPage;


  private HorizontalScrollComponent scrollComponent;

  @Test
  void shouldOpenExercisePage() {
    mainPage.open()
            .passGreetingWidget();
//            .clickNextButton()
//            .clickNextButton()
//            .clickSkipButton()
//            .clickAlertOkButton();

    scrollComponent = new HorizontalScrollComponent();
    scrollComponent
            .clickExerciseBtn()
            .checkPageTitle()
            .checkStartBtn();
  }
}
