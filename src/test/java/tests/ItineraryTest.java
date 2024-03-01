package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Feature("Itinerary features functionality testing")
@Tags({@Tag("ui"), @Tag("itinerary")})
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Itinerary functionality tests")
public class ItineraryTest extends TestBase{
    @DisplayName("Existing Guide itinerary list exist for preset city test")
    @Story("Checking itinerary has activities in existing guide")
    @Test
    void guideCreateTest() {
        mainPage.openPage()
                .setSearch(testData.presetCity);
        cityPage.selectGuideDays(testData.presetCity)
                .pressGo();
        cityGuidePage.checkGuideLoaded(testData.presetCity)
                .openFirstItinerary();
        itineraryPage.checkItineraryNotEmpty();
    }

    @DisplayName("Deleting days from existing Guide itinerary test")
    @Story("Deleting days from existing guide itinerary")
    @Test
    void deleteDayTest() {
        mainPage.openPage()
                .setSearch(testData.presetCity);
        cityPage.selectGuideDays(testData.presetCity)
                .pressGo();
        cityGuidePage.checkGuideLoaded(testData.presetCity)
                .openFirstItinerary();
        itineraryPage.itineraryLoaded()
                .checkItineraryNotEmpty()
                .clickSideMenuButton(buttonsData.btnMoreOptions)
                .clickSideMenuButton(buttonsData.btnRemoveDays)
                .clickDayDelete()
                .closeGuideCreatedMessage()
                .clickSideMenuButton(buttonsData.btnRemoveDays)
                .clickDayDelete()
                .checkItineraryIsEmpty();
    }
}
