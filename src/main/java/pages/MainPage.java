package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbsBasePage<MainPage> {

  private SelenideElement nextBtn = $("[text='Next']");
  private SelenideElement skipBtn = $("[text='Skip >']");
  private SelenideElement alertOkBtn = $("[text='OK']");

  public MainPage clickNextButton() {
    nextBtn.shouldBe(Condition.visible).click();
    return this;
  }

  public MainPage clickSkipButton() {
    skipBtn.shouldBe(Condition.visible).click();
    return this;
  }

  public MainPage clickAlertOkButton() {
    alertOkBtn.shouldBe(Condition.visible).click();
    return this;
  }

  public MainPage passGreetingWidget() {
    clickNextButton();
    clickNextButton();
    clickSkipButton();
    clickAlertOkButton();
    return this;
  }


}
