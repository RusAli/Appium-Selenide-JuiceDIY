package andy;

import com.google.inject.Inject;
import extenstions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

@ExtendWith(AppiumExtension.class)
public class AndyTest {

  @Inject
  private MainPage mainPage;

  @Test
  void checkMainPage() {
    mainPage.open();

    $x("//android.widget.HorizontalScrollView/android.view.View/android.view.View/android.view.View/android.view.View")
            .click();
    $x("//android.widget.HorizontalScrollView/android.view.View/android.view.View/android.view.View/android.view.View")
            .click();
    $x("//android.widget.TextView[@text=\"7 days FREE\"]")
            .shouldHave(text("7 days FREE"));
    $x("//android.widget.TextView[@text=\"Skip >\"]").click();
    $x("//android.widget.Button[@resource-id=\"android:id/button1\"]").click();
    $x("//android.widget.TextView[@text=\"\uF1D1 Unlock Premium\"]").click();
    $x("//android.widget.TextView[@text=\"Upgrade To Pro\"]").shouldHave(text("Upgrade To Pro"));
  }

}
