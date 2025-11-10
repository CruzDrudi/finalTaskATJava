package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private final String BASE_URL = "https://www.saucedemo.com/inventory.html/";
    private final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@class='app_logo']")
    private WebElement logoApp;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw new UnsupportedOperationException(
                "Home page can´t be opened directly, please log in first");
    }

    public String getLogoText() {
        wait.until(ExpectedConditions.visibilityOf(logoApp));
        return logoApp.getText();
    }
}
