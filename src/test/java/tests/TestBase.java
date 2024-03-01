package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.ButtonsData;
import data.TestData;
import drivers.WebDriverProvider;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    ButtonsData buttonsData = new ButtonsData();
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.setConfig();

    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Screenshot");
        Attachments.pageSource();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}
