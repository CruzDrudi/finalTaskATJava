package test;

import org.junit.jupiter.api.Test;
import page.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithEmptyCredentials() {
        String errorText = new LoginPage(driver)
                .openPage()
                .inputRandomUsername(8)
                .inputRandomPassword(8)
                .clearFields()
                .clickLoginButton()
                .getErrorMessage();

        assertThat(errorText, containsString("Username is required"));
    }
}
