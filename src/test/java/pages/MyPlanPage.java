package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyPlanPage {
    private final SelenideElement
            plansContainer = $("#myPlansContainer"),
            searchTool = $("#cityHeaderContainer").$(".form-control"),
            guideTitle = $(".large_title_link"),
            myPlan = $("#cityHeaderContainer .loginbar"),
            deleteMsg = $(".modal-dialog "),
            deleteBtn = $("button");
    private final ElementsCollection guideOptions = $(".itin_actions_wrapper").$$(".ng-binding");
    private final String  noPlansText = "You did not yet create any plans.";
    @Step("Open My Plan page")
    public MyPlanPage openPage() {
        open("/my-plans");
        plansContainer.shouldHave(text(noPlansText));
        return this;
    }
    @Step("Checking that 'My Plan' has a Guide saved")
    public MyPlanPage checkMyPlansHasGuide() {
        plansContainer.shouldNotHave(text(noPlansText));
        return this;
    }
    @Step("Checking that 'My Plan' is empty and doesn't have a Guide saved")
    public MyPlanPage checkMyPlansNoGuide() {
        plansContainer.shouldHave(text(noPlansText));
        return this;
    }
    @Step("Search for city with Guide")
    public MyPlanPage searchPopularCity(String setCity) {
        searchTool.setValue(setCity).pressEnter();
        return this;
    }
    @Step("Checking Saved itinerary title matches")
    public MyPlanPage checkItinTitle(String savedItinTitle) {
        guideTitle.shouldHave(text(savedItinTitle));
        return this;
    }
    @Step("Pressing on 'My Plan' button")
    public MyPlanPage openMyPlans() {
        myPlan.click();
        return this;
    }
    @Step("Deleting saved itinerary")
    public MyPlanPage deleteItin() {
        guideOptions.findBy(text("delete")).click();
        return this;
    }
    @Step("Confirm Deletion of saved itinerary")
    public MyPlanPage confirmDeleteItin() {
        deleteMsg.shouldBe(visible);
        deleteBtn.shouldHave(text("delete")).click();
        return this;
    }
}
