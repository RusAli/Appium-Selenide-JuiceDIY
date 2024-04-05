package components;

import static com.codeborne.selenide.Selenide.$;

import annotations.Component;
import com.codeborne.selenide.Condition;
import pages.ExercisePage;
import pages.StatsPage;

@Component("//android.widget.HorizontalScrollView")
public class HorizontalScrollComponent extends AbsBaseComponent<HorizontalScrollComponent> {


  public ExercisePage clickExerciseBtn() {
    $("[text='Exercise']").shouldBe(Condition.visible).click();
    return new ExercisePage();
  }
  public StatsPage clickStatsBtn() {
    $("[text='Stats']").shouldBe(Condition.visible).click();
    return new StatsPage();
  }
}
