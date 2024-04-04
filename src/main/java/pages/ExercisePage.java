package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ExercisePage extends AbsBasePage<ExercisePage>{

  private SelenideElement titleText = $("[text='Learn 5 new words today']");
  private SelenideElement startBtn = $("[text='Start']");


  public ExercisePage checkPageTitle() {
    titleText.shouldBe(Condition.visible).shouldHave(Condition.text("Learn 5 new words today"));
    return this;
  }

  public ChatPage clickStartBtn() {
    startBtn.shouldBe(Condition.visible).shouldHave(Condition.text("Start")).click();
    return new ChatPage();
  }
}
