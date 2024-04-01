package pages;

import com.codeborne.selenide.Selenide;

public class MainPage extends AbsBasePage<MainPage> {
  public MainPage open() {
    Selenide.open();
    return this;
  }


}
