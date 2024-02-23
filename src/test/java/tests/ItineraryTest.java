package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@DisplayName("Itinerary functionality tests")
public class ItineraryTest extends TestBase{
    @DisplayName("Existing Guide itinerary list exist for preset city test")
    @Test
    void guideCreateTest() {
        mainPage.openPage()
                .search(testData.presetCity);
        cityPage.selectGuideDays(testData.presetCity)
                .pressGo();
        cityGuidePage.guideLoaded(testData.presetCity)
                .openFirstItinerary();
        itineraryPage.itineraryNotEmpty();
    }

    @DisplayName("Deleting days from existing Guide itinerary test")
    @Test
    void deleteDayTest() {
        mainPage.openPage()
                .search(testData.presetCity);
        cityPage.selectGuideDays(testData.presetCity)
                .pressGo();
        cityGuidePage.guideLoaded(testData.presetCity)
                .openFirstItinerary();
        itineraryPage.itineraryLoaded()
                .itineraryNotEmpty()
                .moreOptions()
                .removeDays()
                .dayDelete()
                .closeCreatedGuideWin()
                .removeDays()
                .dayDelete()
                .itineraryIsEmpty();
    }
}
