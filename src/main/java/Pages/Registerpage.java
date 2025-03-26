package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {
    WebDriver driver;
    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacy = By.xpath("//label[@for='input-agree']");
    private By continuButton = By.cssSelector("input[value='Continue']");

    public Registerpage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstname(String fName) {
        driver.findElement(firstname).sendKeys(fName);
    }

    public void enterlastname(String lName) {
        driver.findElement(lastname).sendKeys(lName);
    }

    public void enteremail(String eMail) {
        driver.findElement(email).sendKeys(eMail);
    }

    public void enterTelephoneNumber(String phoneNumber) {
        driver.findElement(telephone).sendKeys(phoneNumber);
    }

    public void enterPassword(String pWord) {
        driver.findElement(password).sendKeys(pWord);
    }

    public void enterConfirmPassword(String pWord) {
        driver.findElement(confirmPassword).sendKeys(pWord);
    }

    public void clickOnPrivacyButton() {
        driver.findElement(privacy).click();
    }

    public void clickOnContinueButton() {
        driver.findElement(continuButton).click();
    }
}
