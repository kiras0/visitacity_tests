package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            bodyContent = $("#main-content-app"),
            searchContainer = $("#homeSearchField"),
            errorMsg = $(".uib-typeahead-match");
    @Step("Open Main page")
    public MainPage openPage() {
        open(baseUrl);
        String titleText = "what's your destination?";
        bodyContent.shouldHave(text(titleText));
        return this;
    }
    @Step("Search for city")
    public MainPage search(String searchKeys) {
        searchContainer.setValue(searchKeys).pressEnter();
        return this;
    }
    @Step("No results found for Search")
    public MainPage failedSearch() {
        String searchErrorText = " No results found";
        errorMsg.shouldHave(text(searchErrorText));
        return this;
    }
}
