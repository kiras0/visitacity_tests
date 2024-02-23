package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CityGuidePage {
    private final SelenideElement
            title = $("h1"),
            firstHeart = $(".fa-heart"),
            itinThumImg = $(".city-thumbnail").$("img"),
            itineraryTitle = $(By.xpath("//div[@title='Click to see Itinerary']"));
    @Step("Checking that correct guide loaded")
    public CityGuidePage guideLoaded(String cityName) {
        title.shouldHave(text(cityName + " in 2 Days"));
        return this;
    }
    @Step("Pressing Heart to save itinerary")
    public CityGuidePage pressHeart() {
        firstHeart.click();
        return this;
    }
    @Step("Getting the Title of itinerary")
    public String saveFirstTitle() {
        String itinTitle = itineraryTitle.getText();
        return itinTitle;
    }
    @Step("Pressing on Image of first itinerary")
    public CityGuidePage openFirstItinerary() {
        itinThumImg.click();
        return this;
    }
}
