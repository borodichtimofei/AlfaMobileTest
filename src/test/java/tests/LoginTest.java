package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @Parameters(value = {"deviceName", "platform"})
    @BeforeClass
    public void setupDeviceParameters(@Optional("Pixel_3a_API_33_arm64-v8a") String deviceName, @Optional("Android") String platform) {
        setCustomCapabilities(deviceName, platform);
    }

    @DataProvider(name = "Registration with negative data")
    public Object[][] RegistrationDataNegative() {
        return new Object[][]{
                {"test", "test", "Введены неверные данные"},
                {"", "", "Введены неверные данные"},
                {"test", "", "Введены неверные данные"},
                {"", "test", "Введены неверные данные"}};
    }
    @Test (dataProvider = "Registration with negative data")
    public void ifTheDataIsIncorrectRegistrationShouldNotBePerformed(String login, String password, String errorMessage){
        loginPage.isPageOpened();
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();
        Assert.assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "Message does not match");
    }

    @Test
    public void ifTheDataIsCorrectRegistrationShouldBePerformed() {
        loginPage.isPageOpened();
        loginPage.enterLogin("Login");
        loginPage.enterPassword("Password");
        loginPage.clickSubmit();
        Assert.assertEquals(loginPage.getSuccessMessage(),
                "Вход в Alfa-Test",
                "Message does not match");
    }
}
