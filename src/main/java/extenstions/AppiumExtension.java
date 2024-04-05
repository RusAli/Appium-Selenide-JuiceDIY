package extenstions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuiceComponentsModule;
import modules.GuiceModule;
import org.junit.jupiter.api.extension.*;
import provider.SelenideWebDriver;

public class AppiumExtension implements BeforeEachCallback, BeforeAllCallback, AfterEachCallback {

  private Injector injector;

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    Configuration.browserSize = null;
    Configuration.browser = SelenideWebDriver.class.getName();
    Configuration.timeout = 30000L;
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    extensionContext.getTestInstance()
            .ifPresent(instance -> {
              injector = Guice.createInjector(new GuiceModule(),new GuiceComponentsModule());
              injector.injectMembers(instance);
            });
  }

  @Override
  public void afterEach(ExtensionContext extensionContext) {
    Selenide.closeWebDriver();
  }
}
