package pages;

import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
public class ChatPage extends AbsBasePage<ChatPage> {
  private SelenideElement chatView = $x("//android.widget.ScrollView");
  public ChatPage isOpen(){
    chatView.shouldBe(Condition.visible);
    return this;
  }
}
