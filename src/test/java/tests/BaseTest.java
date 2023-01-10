package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {

    private String deviceName = "Pixel_3a_API_33_arm64-v8a";
    private String platform = "Android";
    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    LoginPage loginPage;

    void setCustomCapabilities(String _deviceName, String _platform){
        deviceName = _deviceName;
        platform = _platform;
    }

    @BeforeMethod
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager = new AndroidDriverManager();
        driver = manager.getDriver(appiumService, deviceName, platform);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    void stopAppiumServer() {
        if(driver != null) {
            driver.quit();
        }
        appiumService.stop();
    }
}
