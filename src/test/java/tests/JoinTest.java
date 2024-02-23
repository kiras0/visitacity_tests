package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@DisplayName("Testing Join functionality")
public class JoinTest extends TestBase {

    @DisplayName("Submitting a form with 'Subject' field not filled in test.")
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
