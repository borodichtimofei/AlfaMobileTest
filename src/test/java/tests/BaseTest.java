package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.PropertyManager;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {


    private String deviceName = "Pixel_3a_API_33_arm64-v8a";
    private String platform = "Android";

    final String errorMessage = PropertyManager.getInstance().get("error.message");
    final String title = PropertyManager.getInstance().get("title");
    final String successMessage = PropertyManager.getInstance().get("success.message");
    final String login = PropertyManager.getInstance().get("login");
    final String password = PropertyManager.getInstance().get("password");
    final String mismatchMessage = "Information does mot match";
    final String attributeValueTrue = "true";
    final String attributeValueFalse = "false";

    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    LoginPage loginPage;


    @BeforeClass
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager = new AndroidDriverManager();
        driver = manager.getDriver(appiumService, deviceName, platform);
        loginPage = new LoginPage(driver);
    }

    @AfterClass(alwaysRun = true)
    void stopAppiumServer() {
        if (driver != null) {
            driver.quit();
        }
        appiumService.stop();
    }
}
