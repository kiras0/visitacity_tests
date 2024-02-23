package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Feature("Testing of new user registration errors")
@Tags({@Tag("ui"), @Tag("join")})
@DisplayName("Testing Join functionality")
public class JoinTest extends TestBase {

    @DisplayName("Checking for error when registering without password")
    @Story("Trying to register without password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void partialFieldsTest() {
        joinPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .pressSubmit()
                .nullPasswordMessage();
    }
}
