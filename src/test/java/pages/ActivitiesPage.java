package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ActivitiesPage {
    private final SelenideElement slideMenu = $("#sliderWrapper");
    @Step("Check that Activities page loaded correctly")
    public ActivitiesPage checkPageLoaded() {
        slideMenu.shouldHave(text("All Activities"));
    return this;
    }
}
