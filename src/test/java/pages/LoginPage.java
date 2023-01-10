package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public static final By WELCOME_ICON = By.id("com.alfabank.qapp:id/tvTitle"),
    LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername"),
    PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword"),
    SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm"),
    ERROR_MESSGE = By.id("com.alfabank.qapp:id/tvError"),
    SUCCESS_MESSAGE = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.widget.TextView");

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public void isPageOpened() {
        driver.findElement(WELCOME_ICON).isDisplayed();
    }

    public void enterLogin(String login){
        driver.findElement(LOGIN_FIELD).sendKeys(login);
    }

    public void enterPassword(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSGE).getText();
    }

    public String getSuccessMessage(){
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }
}
