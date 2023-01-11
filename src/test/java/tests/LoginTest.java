package tests;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Parameters(value = {"deviceName", "platform"})
    @BeforeClass
    public void setupDeviceParameters(@Optional("Pixel_3a_API_33_arm64-v8a") String deviceName, @Optional("Android") String platform) {
        setCustomCapabilities(deviceName, platform);
    }

    @DataProvider(name = "Registration with negative data")
    public Object[][] RegistrationDataNegative() {
        return new Object[][]{
                {"Login-1", "Pass-1", "Введены неверные данные"},
                {"", "", "Введены неверные данные"},
                {"Login-1", "", "Введены неверные данные"},
                {"", "Pass-1", "Введены неверные данные"}};
    }

    @Test(description = "Input incorrect data", dataProvider = "Registration with negative data")
    public void ifTheDataIsIncorrectRegistrationShouldNotBePerformed(String login, String password, String errorMessage) {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                "Вход в Alfa-Test",
                "Title name does not match");
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSubmit();
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "Message does not match");
    }

    @Test(description = "Input correct data")
    public void ifTheDataIsCorrectRegistrationShouldBePerformed() {
        loginPage.isPageOpened();
        assertEquals(loginPage.getTitleName(),
                "Вход в Alfa-Test",
                "Title name does not match");
        loginPage.inputLogin("Login");
        loginPage.inputPassword("Password");
        loginPage.clickSubmit();
        assertEquals(loginPage.getSuccessMessage(),
                "Вход в Alfa-Test",
                "Message does not match");
    }
}
