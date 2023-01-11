package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public static final By TITLE_NAME = By.id("com.alfabank.qapp:id/tvTitle"),
            LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername"),
            PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword"),
            SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm"),
            ERROR_MESSAGE = By.id("com.alfabank.qapp:id/tvError"),
            SUCCESS_MESSAGE = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
                    "android.widget.TextView");

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public void isPageOpened() {
        driver.findElement(TITLE_NAME).isDisplayed();
    }

    @Step("Getting title name")
    public String getTitleName() {
        return driver.findElement(TITLE_NAME).getText();
    }

    @Step("Input login")
    public void inputLogin(String login) {
        driver.findElement(LOGIN_FIELD).sendKeys(login);
    }

    @Step("Input password")
    public void inputPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Click on button 'Вход'")
    public void clickSubmit() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Getting success message")
    public String getSuccessMessage() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }
}
