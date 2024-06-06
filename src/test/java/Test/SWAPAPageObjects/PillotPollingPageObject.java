package Test.SWAPAPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PillotPollingPageObject {
    protected WebDriver driver;

    /** Page Objects of Pillot Polling Module **/
    private By Resources = By.xpath("(//span[normalize-space()='Resources'])[1]");
    private By SRCForms = By.xpath("//div[@class='dropdown-menu show']//a[contains(.,'SRC Forms')]");
    private By pillotPoll = By.xpath("(//div[@class='dropdown-menu show']/a[contains(.,'SRC Forms')]/..//div[5])/a[@class='dropdown-item']");
    private By quest01 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='Long Pairing Length (4 days)'])[1]");
    private By quest02 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='Long Pairing Length (4 days)'])[2]");
    private By quest03 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='Long Pairing Length (4 days)'])[3]");
    private By quest07 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='Long Pairing Length (4 days)'])[4]");
    private By quest04 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='AM'])");
    private By quest05 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='1 day'])");
    private By quest06 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='1 leg'])");
    private By quest08 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='Yes'])");
    private By quest09 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='A 3 day preceded or followed by a 1 day trip'])");
    private By quest10 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='3 on 3 off'])");
    private By quest11 = By.xpath("(//label[@class='FormChoice__Container'][normalize-space()='No, I almost always drive'])");
    private By submitForm = By.xpath("(//button[@name='submit'][normalize-space()='Submit'])");

    /** Page Objects of 2024 Disability Calculator **/
    private By calculators = By.xpath("//div[@class='dropdown-menu show']//a[contains(.,'Calculators')]");
    private By disabilityCalculators = By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='2024 Disability Calculator']");
    private By seniority = By.name("seniority");
    private By payRate = By.name("payrate");
    private By STDRate = By.name("stdplan");
    private By LTDRate = By.name("ltdplan");
    private By taxRate = By.name("taxrate");
    private By sickBank = By.name("sickbank");
    private By birthDate = By.xpath("//input[@placeholder='01/01/0001']");
    private By hireDate = By.xpath("//input[@placeholder='04/21/2024']");
    private By lolTaxability = By.name("loltaxability");
    private By sickUse = By.name("sickuse");
    private By calculateButton = By.xpath("//button[normalize-space()='Calculate']");
    private By disabilityCalculatorHeading = By.xpath("//h1[contains(text(),'2024 Disability Calculator')]");

    /** Functions of Pillot Polling Module**/
    public PillotPollingPageObject(WebDriver driver)
    {
        this.driver=driver;
    }

    //
    public void clickResources() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menuHoverLink =  driver.findElement(Resources);
        actions.moveToElement(menuHoverLink).perform();
        Thread.sleep((2000));
        WebElement subLink =  driver.findElement(SRCForms);
        subLink.click();
        Thread.sleep((2000));
        WebElement subLinkPillot =  driver.findElement(pillotPoll);
        subLinkPillot.click();
    }

    public void validatePillotFormFilling()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(quest01)).click();
        driver.findElement(quest02).click();
        driver.findElement(quest03).click();
        driver.findElement(quest04).click();
        driver.findElement(quest05).click();
        driver.findElement(quest06).click();
        driver.findElement(quest07).click();
        driver.findElement(quest08).click();
        driver.findElement(quest09).click();
        driver.findElement(quest10).click();
        driver.findElement(quest11).click();
        driver.findElement(submitForm).click();
    }

    /** Functions of 2024 Disability Calculator Module**/
    public void selectDisabilityCalculator() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menuHoverLink =  driver.findElement(Resources);
        actions.moveToElement(menuHoverLink).perform();
        Thread.sleep((2000));
        WebElement calculator = driver.findElement(calculators);
        calculator.click();
        Thread.sleep((2000));
        WebElement disabilityCalculator = driver.findElement(disabilityCalculators);
        disabilityCalculator.click();
    }

    public void enterDisabilityCalculatorValues() throws InterruptedException {
        Select drpSeniority = new Select(driver.findElement(seniority));
        drpSeniority.selectByVisibleText("FO");

        Select drpPayRate = new Select(driver.findElement(payRate));
        drpPayRate.selectByIndex(1);

        Select drpSTDPlan = new Select(driver.findElement(STDRate));
        drpSTDPlan.selectByIndex(1);

        Select drpLTDPlan = new Select(driver.findElement(LTDRate));
        drpLTDPlan.selectByIndex(1);

        Select drpTaxRate = new Select(driver.findElement(taxRate));
        drpTaxRate.selectByIndex(1);

        driver.findElement(sickBank).sendKeys("10.00");

        driver.findElement(birthDate).clear();
        driver.findElement(birthDate).sendKeys("08/09/1961");
        driver.findElement(disabilityCalculatorHeading).click();

        Thread.sleep(2000);
        driver.findElement(hireDate).clear();
        driver.findElement(hireDate).sendKeys("07/29/1993");
        driver.findElement(disabilityCalculatorHeading).click();

        Select drpLolTaxability = new Select(driver.findElement(lolTaxability));
        drpLolTaxability.selectByIndex(1);

        Select drpSickUse = new Select(driver.findElement(sickUse));
        drpSickUse.selectByIndex(1);

        Thread.sleep(2000);
        driver.findElement(calculateButton).click();

    }

}
