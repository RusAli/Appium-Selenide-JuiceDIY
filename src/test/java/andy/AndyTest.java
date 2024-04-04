package andy;

import com.google.inject.Inject;
import components.HorizontalScrollComponent;
import extenstions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ChatPage;
import pages.MainPage;

@ExtendWith(AppiumExtension.class)
public class AndyTest {
  @Inject
  private MainPage mainPage;
  @Inject
  private ChatPage chatPage;
  @Inject
  private HorizontalScrollComponent scrollComponent;

  @Test
  void shouldStartExercise() {

    mainPage.open()
            .passGreetingWidget();
    scrollComponent
            .clickExerciseBtn()
            .checkPageTitle()
            .clickStartBtn();
    chatPage.isOpen();
  }
}
