package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItineraryPage {
    private final SelenideElement
            sideMenu = $("#itinerarySideMenu"),
            itinerary = $("#itinerary-details-wrapper div"),
            firstBtn = $(".modal-dialog ").$("button"),
            createdGuideMessage = $(".modal-dialog .visit-title-xl"),
            closeActBtn = $(".itinerary-ng-form-close"),
            closeCreGuiMsgBtn = $(".modal-dialog").$(".visit-grey");
    private final ElementsCollection
            sideMenuOptions = $$("#itinerarySideMenu .city-thumbnail"),
            activitiesHeart = $(".animate-hide").$$(".fa-heart");

    @Step("Itinerary page is open")
    public ItineraryPage itineraryLoaded() {
        sideMenu.shouldBe(visible);
        return this;
    }

    @Step("Checking that Itinerary has activities")
    public ItineraryPage checkItineraryNotEmpty() {
        itinerary.shouldNotBe(empty);
        return this;
    }

    @Step("Checking that Itinerary is empty")
    public ItineraryPage checkItineraryIsEmpty() {
        itinerary.shouldBe(empty);
        return this;
    }

    @Step("Pressing on side menu button")
    public ItineraryPage clickSideMenuButton(String sideButton) {
        sideMenuOptions.findBy(text(sideButton)).click();
        return this;
    }

    @Step("Pressing on Heart to delete first activity")
    public ItineraryPage clickFirstHeart() {
        activitiesHeart.findBy(visible).click();
        return this;
    }

    @Step("Selected day Delete from itinerary")
    public ItineraryPage clickDayDelete() {
        firstBtn.click();
        return this;
    }

    @Step("Confirm Delete the activity")
    public ItineraryPage clickConfirmDelete() {
        firstBtn.click();
        return this;
    }

    @Step("Checking successful 'Guide Created' message")
    public ItineraryPage checkGuideCreatedMessage(String createdGuideText) {
        createdGuideMessage.shouldHave(text(createdGuideText));
        return this;
    }

    @Step("Closing 'Guide Created' message")
    public ItineraryPage closeGuideCreatedMessage() {
        closeCreGuiMsgBtn.click();
        return this;
    }

    @Step("Closing Activities window")
    public ItineraryPage closeActivitiesWindow() {
        closeActBtn.click();
        return this;
    }
}
