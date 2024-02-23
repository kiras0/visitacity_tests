package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@DisplayName("Testing of Guest user experience with 'My Plan'")
public class MyPlanTest extends TestBase {
    @DisplayName("Adding an itinerary to 'My Plan' from suggested Guide Itineraries")
    @Test
    void itinLikeAddTest() {
     myPlanPage.openPage()
             .searchPopularCity(testData.presetCity);
     cityPage.checkForTitle(testData.presetCity)
             .pressGo();
     String savedItin =  cityGuidePage.pressHeart()
                 .saveFirstTitle();
     myPlanPage.openMyPlans()
             .checkItinTitle(savedItin);
    }

    @DisplayName("Adding a selected itinerary to 'My Plan' by modifying it")
    @Test
    void itinModifyAddTest() {
        myPlanPage.openPage()
                .searchPopularCity(testData.presetCity);
        cityPage.checkForTitle(testData.presetCity)
                .pressGo();
        cityGuidePage.openFirstItinerary();
        itineraryPage.itineraryLoaded()
                .addAttractions()
                .pressFirstHeart()
                .confirmActivityDelete()
                .guideCreatedMessageCheck()
                .closeCreatedGuideWin()
                .closeActivitiesWin();
        myPlanPage.openMyPlans()
                .checkMyPlansHasGuide();
    }

    @DisplayName("Checking delete function of guide works after adding itinerary to 'My Plan' test")
    @Test
    void itinDeleteTest() {
        myPlanPage.openPage()
                .searchPopularCity(testData.presetCity);
        cityPage.checkForTitle(testData.presetCity)
                .pressGo();
        String savedItin =  cityGuidePage.pressHeart()
                .saveFirstTitle();
        myPlanPage.openMyPlans()
                .checkItinTitle(savedItin)
                .deleteItin()
                .confirmDeleteItin()
                .checkMyPlansNoGuide();
    }
}
