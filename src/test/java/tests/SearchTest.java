package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("Kiras0")
@Feature("Testing of different search functionalities")
@Tags({@Tag("ui"), @Tag("search")})
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Testing search functionality on index page")
public class SearchTest extends TestBase {

    @Story("Successful search for city with Guide")
    @ValueSource(strings = {"Amsterdam", "Tokyo"})
    @ParameterizedTest(name = "Searching for {0}")
    void popularCitySearchTest(String popularCityCollection) {
        mainPage.openPage()
                .setSearch(popularCityCollection);
        cityPage.checkForTitle(popularCityCollection);
    }

    @Story("Successful search for city with no Guide open activities")
    @ValueSource(strings = {"Lexington",  "Crystal"})
    @ParameterizedTest(name = "Searching for {0}")
    void citySearchTest(String cityCollection) {
        mainPage.openPage()
                .setSearch(cityCollection);
        activitiesPage.checkPageLoaded();
    }


    @DisplayName("Search no results found test")
    @Story("Search result should display error for random search")
    @Test
    void noResultSearchTest() {
        mainPage.openPage()
                .setSearch(testData.streetName)
                .checkFailedSearchResult(testData.textSearchError);
    }
}
