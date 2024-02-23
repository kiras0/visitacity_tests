package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@DisplayName("Testing search functionality on index page")
public class SearchTest extends TestBase {

    @DisplayName("Successful search for city with Guide")
    @Test
    void popularCitySearchTest() {
        mainPage.openPage()
                .search(testData.popularCity);
        cityPage.checkForTitle(testData.popularCity);
    }

    @DisplayName("Successful search for city with no Guide display activities")
    @Test
    void citySearchTest() {
        mainPage.openPage()
                .search(testData.city);
        activitiesPage.checkPageLoaded();
    }

    @DisplayName("Search no results found test")
    @Test
    void noResultSearchTest() {
        mainPage.openPage()
                .search(testData.streetName)
                .failedSearch();
    }


}
