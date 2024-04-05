package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class SettingsPage extends AbsBasePage<SettingsPage> {

  private SelenideElement settingsTitle = $("[text='Settings']");

  public SettingsPage checkSettingsPage() {

    $("[text='Settings']").shouldBe(Condition.visible).shouldHave(Condition.text("Settings"));
    $("[text='Translations']").shouldBe(Condition.visible).shouldHave(Condition.text("Translations"));
    $("[text='Feedback / help us improve']").shouldBe(Condition.visible).shouldHave(Condition.text("Feedback / help us improve"));
    $("[text='Contact developer']").shouldBe(Condition.visible).shouldHave(Condition.text("Contact developer"));
    $("[text='Terms of use']").shouldBe(Condition.visible).shouldHave(Condition.text("Terms of use"));
    return this;
  }
  public SettingsPage clickTranslationsBtn(){
    $("[text='Translations']").shouldBe(Condition.visible).click();
    return this;
  }
}
