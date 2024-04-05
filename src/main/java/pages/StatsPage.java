package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
public class StatsPage extends AbsBasePage<StatsPage> {

  public StatsPage clickSettingsBtn() {
    $("[text='Settings']").shouldBe(Condition.visible).click();
    return new StatsPage();
  }
}
