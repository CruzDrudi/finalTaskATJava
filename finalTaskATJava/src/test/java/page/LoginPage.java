package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.StringUtil;


public class LoginPage extends BasePage {

    private final String BASE_URL = "https://www.saucedemo.com/";
    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
        return this;
    }

    public LoginPage inputRandomUsername(int length) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(StringUtil.getRandomString(length));
        logger.info("Username field filled with a random value");
        return this;
    }

    public LoginPage inputRandomPassword(int length) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(StringUtil.getRandomString(length));
        logger.info("Password field filled with a random value");
        return this;
    }

    public LoginPage inputUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(username);
        logger.info("Username field filled");
        return this;
    }

    public LoginPage inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        usernameField.sendKeys(password);
        logger.info("Password field filled");
        return this;
    }

    public LoginPage clearUsernameField() {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.clear();
        logger.info("Username field cleared");
        return this;
    }

    public LoginPage clearPasswordField() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        logger.info("Password field cleared");
        return this;
    }

    public LoginPage clearFields() {
        clearUsernameField();
        clearPasswordField();
        return this;
    }

    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        logger.info("Login button clicked");
        return this;
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}