package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class JoinPage {
    private final SelenideElement
            headerTitle = $(".reg-block-header"),
            loginForm = $("#loginForm"),
            emailField = $(By.name("email")),
            signUpBtn = $("#loginForm").$("button");
    private final ElementsCollection loginFormFields = $$("#loginForm input");
    @Step("Open Join page")
    public JoinPage openPage() {
        open(baseUrl+"/signup");
        headerTitle.shouldHave(text("Join"));
        return this;
    }
    @Step("Set First Name")
    public JoinPage setFirstName(String firstName) {
        loginFormFields.get(0).setValue(firstName);
        return this;
    }
    @Step("Set Last Name")
    public JoinPage setLastName(String lastName) {
        loginFormFields.get(1).setValue(lastName);
        return this;
    }
    @Step("Set Email")
    public JoinPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }
    @Step("Press Submit button")
    public JoinPage pressSubmit() {
        signUpBtn.shouldHave(text("Sign up")).click();
        return this;
    }
    @Step("Check that Password is required message is displayed")
    public JoinPage nullPasswordMessage() {
        String missingPassError = "Password is required";
        loginForm.shouldHave(text(missingPassError));
        return this;
    }
}
