package Test.SWAPAFunctions;

import Test.SWAPAPageObjects.PillotPollingPageObject;
import Test.SWAPAPageObjects.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunction {
    public static WebDriver driver;
    LoginPageObject login;
    PillotPollingPageObject pillot;

    @BeforeTest
    public void loginHome()
    {
        driver = new ChromeDriver();
        login = new LoginPageObject(driver);
        pillot = new PillotPollingPageObject(driver);
        login.launchSWAPA();
    }
    @Test(priority = 1, groups = "@Smoke")
    public void Login() throws InterruptedException {
        login.enterCredentials();
        pillot.clickResources();
    }
    @AfterTest
    public void closeSwapa()
    {
        login.quitSWAPA();
    }
}
