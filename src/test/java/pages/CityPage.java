package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CityPage {
    private final SelenideElement
            pageTitle = $(".city_page_title"),
            guideSelect = $("#topSelect"),
            goBtn = $(".goButton");
    @Step("Check the Title is displayed")
    public CityPage checkForTitle(String cityName) {
        pageTitle.shouldHave(text("Create Your " + cityName + " Guide"));
        return this;
    }
    @Step("Select Days for 'Your City Guide'")
    public CityPage selectGuideDays(String cityName) {
        guideSelect.click();
        guideSelect.selectOption(cityName + " in Two Days");
        return this;
    }
    @Step("Create 'Your City Guide' by pressing Go button")
    public CityPage pressGo() {
        goBtn.click();
        return this;
    }
}
