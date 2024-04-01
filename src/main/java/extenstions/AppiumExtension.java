package extenstions;

import com.codeborne.selenide.Configuration;
import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuiceModule;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import provider.SelenideWebDriver;

public class AppiumExtension implements BeforeEachCallback, BeforeAllCallback {

  private Injector injector;

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    Configuration.browserSize = null;
    Configuration.browser = SelenideWebDriver.class.getName();
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) {
    extensionContext.getTestInstance()
            .ifPresent(instance -> {
              injector = Guice.createInjector(new GuiceModule());
              injector.injectMembers(instance);
            });
  }

}
