package test.steps;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {

    private WebDriver driver = DriverSingleton.getDriver();

    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.openPage();
    }

    @When("the user fills username and password fields with random values")
    public void fillsUsernameAndPasswordWithRandomValues() {
        loginPage.inputRandomUsername(8)
                .inputRandomPassword(8);
    }

    @And("clears the username and password fields")
    public void clearsUsernameAndPasswordFields() {
        loginPage.clearFields();
    }

    @And("clicks the Login button")
    public void clicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the error message should contain {string}")
    public void errorMessageShouldContain(String errorMessage){
        String actualError = loginPage.getErrorMessage();
        assertThat(actualError, containsString(errorMessage));
    }

    @And("clears the password field")
    public void clearsThePasswordField() {
        loginPage.clearPasswordField();
    }

    @When("the user fills username and password fields with valid credentials")
    public void theUserFillsUsernameAndPasswordFieldsWithValidCredentials() {
        User user = UserCreator.withCredentialsFromProperty();
        loginPage.inputUsername(user.getUsername())
                .inputPassword(user.getPassword());
    }

    @Then("the user should see the logo text {string} on the home page")
    public void theUserShouldSeeLogoText(String logoText) {
        homePage = new HomePage(driver);
        String actualLogoText = homePage.getLogoText();
        assertThat(actualLogoText, equalTo(logoText));
    }

    @After
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
