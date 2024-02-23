package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.open;

public class ContactUsPage {
    private final SelenideElement
            bodyAbout = $("#aboutPages"),
            emailContainer = $("#emailAddressSend"),
            subjectContainer = $("#subject"),
            messageContainer = $("#shareMessage"),
            submitBtn = $(".btn-u");
    private final ElementsCollection contactFormMsg = $("#aboutPages").$$(".visit-title-md");

    @Step("Open 'Contact Us' page")
    public ContactUsPage openContactUsPage() {
        open("/contact");
        bodyAbout.shouldHave(text("Contact Us"));
        return this;
    }
    @Step("Enter the Email")
    public ContactUsPage setEmail(String email) {
        emailContainer.setValue(email);
        return this;
    }
    @Step("Enter the Subject of message")
    public ContactUsPage setSubject(String subject) {
        subjectContainer.setValue(subject);
        return this;
    }
    @Step("Enter the Message")
    public ContactUsPage setMessage(String message) {
        messageContainer.setValue(message);
        return this;
    }
    @Step("Press 'Send Message' button")
    public ContactUsPage pressSubmit() {
        submitBtn.shouldHave(text("Send Message")).click();
        return this;
    }
    @Step("Asserting error message is displayed")
    public ContactUsPage errorMessage() {
        String errorMessage = contactFormMsg.get(1).getText();
        String errorText = "Please fill out all fields";
        assertThat(errorText).isEqualTo(errorMessage);
        return this;
    }
}
