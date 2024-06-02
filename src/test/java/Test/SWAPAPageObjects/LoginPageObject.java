package Test.SWAPAPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;
public class LoginPageObject {
    protected WebDriver driver;
    /** Page Objects of Login Module **/
    private By loginHome = By.xpath("//a[contains(text(),'Log in')]");
    private By  userName1 = By.xpath("//input[@type='text']");
    private By passWord1 = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[contains(text(),'Log In')]");

    private By Resources = By.xpath("(//span[normalize-space()='Resources'])[1]");


    /** Functions of Login Module**/
    public LoginPageObject(WebDriver driver)
    {
        this.driver=driver;
    }

    // Summary
    /// Hit the URL of SWAPA Application
    public void launchSWAPA()
    {
        driver.get("https://qa.swapa.org/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    public void enterCredentials() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(loginHome)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName1)).sendKeys("112298849");
        driver.findElement(passWord1).sendKeys("swapa8849");
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(Resources)).click();
    }

    // Summary
    /// Quit SWAPA Application
    public void quitSWAPA()
    {
        driver.quit();
    }
}
