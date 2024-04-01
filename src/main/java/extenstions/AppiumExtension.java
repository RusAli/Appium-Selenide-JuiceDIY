package extenstions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import provider.SelenideWebDriver;

public class AppiumExtension implements BeforeEachCallback {
  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    Configuration.browserSize = null;
    Configuration.browser = SelenideWebDriver.class.getName();
  }
}
