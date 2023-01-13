package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Login with negative data")
    public Object[][] LoginDataNegative() {
        return new Object[][]{
                {"Login-1", "Pass-1", mismatchMessage},
                {"", "", mismatchMessage},
                {"Login-1", "", mismatchMessage},
                {"", "Pass-1", mismatchMessage}};
    }

    @DataProvider(name = "Attribute value")
    public Object[][] AttributeValue() {
        return new Object[][]{
                {LoginPage.getSubmitButton(), "text", "Вход", mismatchMessage},
                {LoginPage.getSubmitButton(), "enabled", attributeValueTrue, mismatchMessage},
                {LoginPage.getSubmitButton(), "clickable", attributeValueTrue, mismatchMessage},
                {LoginPage.getSubmitButton(), "displayed", attributeValueTrue, mismatchMessage},
                {LoginPage.getSubmitButton(), "focusable", attributeValueTrue, mismatchMessage},
                {LoginPage.getLoginField(), "text", "Логин", mismatchMessage},
                {LoginPage.getLoginField(), "enabled", attributeValueTrue, mismatchMessage},
                {LoginPage.getLoginField(), "clickable", attributeValueTrue, mismatchMessage},
                {LoginPage.getLoginField(), "displayed", attributeValueTrue, mismatchMessage},
                {LoginPage.getLoginField(), "focusable", attributeValueTrue, mismatchMessage},
                {LoginPage.getPasswordField(), "text", "Пароль", mismatchMessage},
                {LoginPage.getPasswordField(), "enabled", attributeValueTrue, mismatchMessage},
                {LoginPage.getPasswordField(), "clickable", attributeValueTrue, mismatchMessage},
                {LoginPage.getPasswordField(), "displayed", attributeValueTrue, mismatchMessage},
                {LoginPage.getPasswordField(), "focusable", attributeValueTrue, mismatchMessage}};
    }

    @Test(description = "Input negative data", dataProvider = "Login with negative data", priority = 3)
    @Step("Login with negative data")
    public void checkThatCannotLoginWithInvalidData(String login, String password, String mismatchMessage) {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                title,
                mismatchMessage);
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSubmit();
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                mismatchMessage);
    }

    @Test(description = "Input valid data", priority = 5)
    @Step("Login with valid data")
    public void checkThatCanLoginWithValidData() {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                title,
                mismatchMessage);
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSubmit();
        assertEquals(loginPage.getSuccessMessage(),
                successMessage,
                mismatchMessage);
    }

    @Test(description = "Input over maximum value", priority = 4)
    @Step("Data entry over maximum value")
    public void checkThatCanNotEnterInvalidLoginValue() {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                title,
                mismatchMessage);
        loginPage.inputLogin("123456789012345678901234567890123456789012345678901");
        loginPage.inputPassword(password);
        loginPage.clickSubmit();
        assertEquals(loginPage.getErrorMessage(),
                "Invalid value",
                mismatchMessage);
    }

    @Test(description = "Visibility password", priority = 2)
    @Step("Password visibility check")
    public void checkPasswordVisibility() {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                title,
                mismatchMessage);
        assertEquals(loginPage.getAttribute("password", LoginPage.getPasswordField()),
                attributeValueTrue,
                mismatchMessage);
        loginPage.clickVisibilityButton();
        assertEquals(loginPage.getAttribute("password", LoginPage.getPasswordField()),
                attributeValueFalse,
                mismatchMessage);
    }

    @Test(dataProvider = "Attribute value", priority = 1)
    @Step("Attribute check")
    public void checkPlaceholderField(By locator, String attribute, String attributeValue, String mismatchMessage) {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                title,
                mismatchMessage);
        assertEquals(loginPage.getAttribute(attribute, locator),
                attributeValue,
                mismatchMessage);
    }
}
