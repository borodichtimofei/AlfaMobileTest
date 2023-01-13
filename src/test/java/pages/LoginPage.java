package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    public static By TITLE_NAME = By.id("com.alfabank.qapp:id/tvTitle"),
            LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername"),
            PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword"),
            SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm"),
            ERROR_MESSAGE = By.id("com.alfabank.qapp:id/tvError"),
            SUCCESS_MESSAGE = By.xpath("//*[@text = 'Вход в Alfa-Test выполнен']"),
            VISIBILITY_BUTTON = By.id("com.alfabank.qapp:id/text_input_end_icon");

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public void isPageOpened() {
        driver.findElement(TITLE_NAME).isDisplayed();
    }

    public String getTitleName() {
        return driver.findElement(TITLE_NAME).getText();
    }

    public void inputLogin(String login) {
        driver.findElement(LOGIN_FIELD).sendKeys(login);
    }

    public void inputPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getSuccessMessage() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }

    public void clickVisibilityButton() {
        driver.findElement(VISIBILITY_BUTTON).click();
    }

    public String getAttribute(String attribute, By locator) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public static By getLoginField() {
        return LOGIN_FIELD;
    }

    public static By getPasswordField() {
        return PASSWORD_FIELD;
    }

    public static By getSubmitButton() {
        return SUBMIT_BUTTON;
    }
}
