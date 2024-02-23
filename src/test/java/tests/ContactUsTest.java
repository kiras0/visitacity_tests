package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Feature("Testing 'Contact Us' Form submission error")
@Tags({@Tag("ui"), @Tag("contactUs")})
@Severity(SeverityLevel.NORMAL)
@DisplayName("Testing 'Contact Us' Form")
public class ContactUsTest extends TestBase{
    @DisplayName("Submitting a Form with 'Subject' field not filled in test.")
    @Story("Submitting form with no details entered in subject field")
    @Test
    void partialFieldsTest() {
        contactUsPage.openContactUsPage()
                .setEmail(testData.email)
                .setMessage(testData.message)
                .pressSubmit()
                .errorMessage();
    }

    @DisplayName("Submitting a Form with incorrect email credentials test.")
    @Story("Entering corrupt email address to get an error")
    @Test
    void wrongEmailFieldsTest() {
        contactUsPage.openContactUsPage()
                .setEmail("@#$?"+testData.email)
                .setSubject(testData.subject)
                .setMessage(testData.message)
                .pressSubmit()
                .errorMessage();
    }
}
