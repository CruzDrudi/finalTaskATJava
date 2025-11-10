package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser");
            if (browser == null) {
                browser = "firefox";
            }
            switch (browser) {
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    driver = new FirefoxDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
