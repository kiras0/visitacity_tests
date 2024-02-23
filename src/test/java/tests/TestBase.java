package tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import data.TestData;
import helpers.Attachments;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.*;

public class TestBase {
    MainPage mainPage = new MainPage();
    JoinPage joinPage = new JoinPage();
    ContactUsPage contactUsPage = new ContactUsPage();
    MyPlanPage myPlanPage = new MyPlanPage();
    CityPage cityPage = new CityPage();
    ItineraryPage itineraryPage = new ItineraryPage();
    ActivitiesPage activitiesPage = new ActivitiesPage();
    CityGuidePage cityGuidePage = new CityGuidePage();
  TestData testData = new TestData();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x800";
        Configuration.baseUrl = "https://www.visitacity.com";
    }
    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}
