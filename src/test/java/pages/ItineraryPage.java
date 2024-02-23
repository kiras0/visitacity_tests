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
    public ItineraryPage itineraryNotEmpty() {
        itinerary.shouldNotBe(empty);
        return this;
    }
    @Step("Checking that Itinerary is empty")
    public ItineraryPage itineraryIsEmpty() {
        itinerary.shouldBe(empty);
        return this;
    }
    @Step("Pressing on 'More Options' button")
    public ItineraryPage moreOptions() {
        sideMenuOptions.findBy(text("More Option")).click();
        return this;
    }
    @Step("Pressing on 'Remove Day' button")
    public ItineraryPage removeDays() {
        sideMenuOptions.findBy(text("Remove Day")).click();
        return this;
    }
    @Step("Pressing on 'Add Attractions' button")
    public ItineraryPage addAttractions() {
        sideMenuOptions.findBy(text("Add Attractions")).click();
        return this;
    }
    @Step("Pressing on Heart to delete first activity")
    public ItineraryPage pressFirstHeart() {
        activitiesHeart.findBy(visible).click();
        return this;
    }
    @Step("Selected day Delete from itinerary")
    public ItineraryPage dayDelete() {
        firstBtn.click();
        return this;
    }
    @Step("Confirm Delete the activity")
    public ItineraryPage confirmActivityDelete() {
        firstBtn.click();
        return this;
    }
    @Step("Checking successful 'Guide Created' message")
    public ItineraryPage guideCreatedMessageCheck() {
        String createdGuideText = "Congrats! Your Rome Travel Guide Was Created";
        createdGuideMessage.shouldHave(text(createdGuideText));
        return this;
    }
    @Step("Closing 'Guide Created' message")
    public ItineraryPage closeCreatedGuideWin() {
        closeCreGuiMsgBtn.click();
        return this;
    }
    @Step("Closing Activities window")
    public ItineraryPage closeActivitiesWin() {
        closeActBtn.click();
        return this;
    }
}
