package components;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import annotations.Component;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public abstract class AbsBaseComponent<T> {

//  {
//    getComponentEntity().shouldBe(Condition.visible);
//  }

  protected String baseComponentLocator;

  private By locatorAnalyzer(String value) {

    if (value != null) {
      baseComponentLocator = value;

      return value.startsWith("/") ? By.xpath(value) : By.cssSelector(value);
    }
    return null;
  }

  public SelenideElement getComponentEntity() {

    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Component.class)) {
      Component component = getClass().getAnnotation(Component.class);

      By by = locatorAnalyzer(component.value());

      return $(by);
    }
    return null;
  }

}
