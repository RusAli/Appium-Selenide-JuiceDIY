package components;

import annotations.Component;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.ExercisePage;

import static com.codeborne.selenide.Selenide.$;

@Component("//android.widget.HorizontalScrollView")
public class HorizontalScrollComponent extends AbsBaseComponent<HorizontalScrollComponent> {

  private SelenideElement chatBtn = $("[text='Chat']");
  private SelenideElement exerciseBtn = $("[text='Exercise']");


  public ExercisePage clickExerciseBtn(){
    exerciseBtn.shouldBe(Condition.visible).click();
    return new ExercisePage();
  }



}
