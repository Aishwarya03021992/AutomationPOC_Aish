package Test.SWAPAFunctions;

import Test.SWAPAPageObjects.LoginPageObject;
import Test.SWAPAPageObjects.PillotPollingPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PillotPollingFunction {

    public static WebDriver driver;

    PillotPollingPageObject pillotForm;
    LoginPageObject login1;

    @BeforeTest
    public void resourcesNavigate() throws InterruptedException {
        driver = new ChromeDriver();
        login1 = new LoginPageObject(driver);
        pillotForm = new PillotPollingPageObject(driver);
    }

    @Test (groups = "@Regression")
    public void resourceClick() throws InterruptedException {
        login1.launchSWAPA();
        login1.enterCredentials();
        pillotForm.clickResources();
    }

    @Test(dependsOnMethods = {"resourceClick"}, groups ="@Regression")
    public void validatePillotFormFilling() {
        pillotForm.validatePillotFormFilling();
    }

    @Test
    public void validateDisabilityCalculator() throws InterruptedException {
        login1.launchSWAPA();
        login1.enterCredentials();
        pillotForm.selectDisabilityCalculator();
        pillotForm.enterDisabilityCalculatorValues();
    }

    @AfterTest
    public void closeResource() {
        login1.quitSWAPA();
    }
}
