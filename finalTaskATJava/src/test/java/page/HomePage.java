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
        driver.navigate().to(BASE_URL);
        logger.info("Home page opened");
        return this;
    }

    public String getLogoText() {
        wait.until(ExpectedConditions.visibilityOf(logoApp));
        return logoApp.getText();
    }
}
