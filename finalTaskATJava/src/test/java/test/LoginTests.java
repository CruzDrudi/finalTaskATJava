package test;

import model.User;
import org.junit.jupiter.api.Test;
import page.HomePage;
import page.LoginPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void loginWithEmptyPassword() {
        String errorText = new LoginPage(driver)
                .openPage()
                .inputRandomUsername(8)
                .inputRandomPassword(8)
                .clearPasswordField()
                .clickLoginButton()
                .getErrorMessage();

        assertThat(errorText, containsString("Password is required"));
    }

    @Test
    public void loginUserSuccessfully() {

        User user = UserCreator.withCredentialsFromProperty();
        LoginPage loginPage = new LoginPage(driver)
                .openPage()
                .inputUsername(user.getUsername())
                .inputPassword(user.getPassword())
                .clickLoginButton();

        HomePage homePage = new HomePage(driver);
        String logoText = homePage.getLogoText();
        assertThat(logoText, equalTo("Swag Labs"));
    }
}
