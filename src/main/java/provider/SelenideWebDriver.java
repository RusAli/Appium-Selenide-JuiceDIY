package provider;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

import com.codeborne.selenide.WebDriverProvider;
import exceptions.FailedDownloadApkException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenideWebDriver implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {

    File app = downloadApk();

    UiAutomator2Options options = new UiAutomator2Options();
    options.merge(capabilities);
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setPlatformName("Android");
    options.setAvd("Pixel");
    options.setPlatformVersion("5.1");
    options.setApp(app.getAbsolutePath());

    try {
      return new AndroidDriver(new URL(System.getProperty("remote.url")), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }


  private File downloadApk() {
    File apk = new File(System.getProperty("user.dir") + "/src/test/java/resources/app/Andy.apk");
    if (!apk.exists()) {
      String url = "path to remote apk source";
      try (InputStream in = new URL(url).openStream()) {
        copyInputStreamToFile(in, apk);
      } catch (IOException e) {
        throw new FailedDownloadApkException();
      }
    }
    return apk;
  }
}
