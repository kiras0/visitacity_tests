package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@DisplayName("Testing 'Contact Us' Form submission")
public class ContactUsTest extends TestBase{
    @DisplayName("Submitting a Form with 'Subject' field not filled in test.")
    @Test
    void partialFieldsTest() {
        contactUsPage.openContactUsPage()
                .setEmail(testData.email)
                .setMessage(testData.message)
                .pressSubmit()
                .errorMessage();
    }

    @DisplayName("Submitting a Form with incorrect email credentials test.")
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
