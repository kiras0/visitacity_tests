package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Feature("Testing 'My Plan' functionality")
@Tags({@Tag("ui"), @Tag("myPLan")})
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Testing of Guest user experience with 'My Plan'")
public class MyPlanTest extends TestBase {
    @DisplayName("Adding an itinerary to 'My Plan' from suggested Guide Itineraries")
    @Story("Liking existing guide to save to 'My Plan' test")
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
    @Story("Editing existing guide by deleting activity to save to 'My Plan' test")
    @Test
    void itinModifyAddTest() {
        myPlanPage.openPage()
                .searchPopularCity(testData.presetCity);
        cityPage.checkForTitle(testData.presetCity)
                .pressGo();
        cityGuidePage.openFirstItinerary();
        itineraryPage.itineraryLoaded()
                .clickSideMenuButton(buttonsData.btnAddAttractions)
                .clickFirstHeart()
                .clickConfirmDelete()
                .checkGuideCreatedMessage(testData.textSuccessfulCreatedGuide)
                .closeGuideCreatedMessage()
                .closeActivitiesWindow();
        myPlanPage.openMyPlans()
                .checkMyPlansHasGuide();
    }

    @DisplayName("Deleting a guide from 'My Plan' test")
    @Story("Checking delete function of guide works after adding itinerary to 'My Plan' test")
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
