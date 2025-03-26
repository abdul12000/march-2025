package stepDefinitions;

import Pages.Homepage;
import Pages.Loginpage;
import Pages.Registerpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LambdaStepDefinitions {

    WebDriver driver;

    @Before
    public void innitialize() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws IOException {
        takeScrensot();
        driver.quit();
    }


    @Given("I am on the Lambdatest home page {string}")
    public void iAmOnTheLambdatestHomePage(String lambdaHomePage) {
//    driver.get(lambdaHomePage);
        driver.navigate().to(lambdaHomePage);
    }

    @When("I click on Register link from the MyAccount Menu")
    public void i_click_on_register_link_from_the_my_account_menu() {
        // Click on the My account menu
//        xpath
//        driver.findElements(By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']")).get(2).click();

//        //css
//        driver.findElements(By.cssSelector("a[class='icon-left both nav-link dropdown-toggle']")).get(2).click();
//
//        //Or
        driver.findElements(By.cssSelector(".icon-left.both.nav-link.dropdown-toggle")).get(2).click();

//
//        //clicking on the Continue button
//        driver.findElement(By.linkText("Continue")).click();
//        //Using partial linkText..
//        driver.findElement(By.partialLinkText("Conti")).click();
//        //using xpath contains text():
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }


    @Then("the Register Account page is displayed")
    public void the_register_account_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is(equalTo("Register Account")));

    }

    private int randonNumber() {
        Random random = new Random();
        return random.nextInt(100000);

    }

    @When("enter First Name as {string}, Last Name as {string}, email as {string}, telephone as {string} and password as {string}")
    public void enter_first_name_as_last_name_as_email_as_telephone_as_and_password_as(String firstname, String lastname, String email, String telephone, String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
        driver.findElement(By.id("input-email")).sendKeys(randonNumber() + email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
    }

    @When("I click on the privacy policy")
    public void i_click_on_the_privacy_policy() {
        driver.findElement(By.xpath("//label[@for='input-agree']")).click();
//using css selector
//        driver.findElement(By.xpath("label[for='input-agree']")).click();
    }

    @When("I click on Continue button on the register account page")
    public void i_click_on_continue_button_on_the_register_account_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
    }

    @Then("{string} is displayed")
    public void is_displayed(String title) {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = driver.getTitle();
        assertThat(pageTitle, is(equalTo(title)));
    }


    public void takeScrensot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("target/screenshot" + System.currentTimeMillis() + ".png"));


    }

    @And("enter {string}, {string}, {string}, {string} and {string}")
    public void enterAnd(String fName, String LName, String eMail, String phoneNumber, String pWord) {
        driver.findElement(By.id("input-firstname")).sendKeys(fName);
        driver.findElement(By.id("input-lastname")).sendKeys(LName);
        driver.findElement(By.id("input-email")).sendKeys(randonNumber() + eMail);
        driver.findElement(By.id("input-telephone")).sendKeys(phoneNumber);
        driver.findElement(By.id("input-password")).sendKeys(pWord);
        driver.findElement(By.id("input-confirm")).sendKeys(pWord);
    }

    @And("enter details as follows")
//    public void enterDetailsAsFollows(List<List<String>> dataTable) {
//        driver.findElement(By.id("input-firstname")).sendKeys(dataTable.get(1).get(1));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataTable.get(2).get(1));
//        driver.findElement(By.id("input-email")).sendKeys(randonNumber()+dataTable.get(3).get(1));
//        driver.findElement(By.id("input-telephone")).sendKeys(dataTable.get(4).get(1));
//        driver.findElement(By.id("input-password")).sendKeys(dataTable.get(5).get(1));
//        driver.findElement(By.id("input-confirm")).sendKeys(dataTable.get(5).get(1));

    public void enterDetailsAsFollows(Map<String, String> dataTable) {
        driver.findElement(By.id("input-firstname")).sendKeys(dataTable.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataTable.get("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(randonNumber() + dataTable.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataTable.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(dataTable.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(dataTable.get("password"));


    }

    @And("enter the following details")
    public void enterTheFollowingDetails(List<String> dataTable) {
        driver.findElement(By.id("input-firstname")).sendKeys(dataTable.get(1));
        driver.findElement(By.id("input-lastname")).sendKeys(dataTable.get(2));
        driver.findElement(By.id("input-email")).sendKeys(randonNumber() + dataTable.get(3));
        driver.findElement(By.id("input-telephone")).sendKeys(dataTable.get(4));
        driver.findElement(By.id("input-password")).sendKeys(dataTable.get(5));
        driver.findElement(By.id("input-confirm")).sendKeys(dataTable.get(5));
    }

    @When("I click on Register link after hovering on My account menu")
    public void iClickOnRegisterLinkAfterHoveringOnMyAccountMenu() {
        WebElement myAccountMenu = driver.findElements(By.xpath("//div/span[contains(text(),'My account')]")).get(1);
// Perform mouse move action onto the element
        new Actions(driver)
                .moveToElement(myAccountMenu)
                .perform();
        WebElement registerLink = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        registerLink.click();
    }



    ///// Using Page Object:


    @When("I click on my account link")
    public void i_click_on_my_account_link() {
        // Write code here that turns the phrase above into concrete actions
        Homepage homepage = new Homepage(driver);
        homepage.clickMyAccountMenu();
    }
    @When("I click on Continue on the login page")
    public void i_click_on_continue_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        Loginpage loginpage = new Loginpage(driver);
        loginpage.clickOnContinueButton();
    }
    @When("enter {string}, {string}, {string}, {string} and {string} using page object")
    public void enter_and_using_page_object(String fName, String lName, String eMail, String tPhone, String pWord) {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.enterFirstname(fName);
        registerpage.enterlastname(lName);
        registerpage.enteremail(randonNumber()+eMail);
        registerpage.enterTelephoneNumber(tPhone);
        registerpage.enterPassword(pWord);
        registerpage.enterConfirmPassword(pWord);
    }
    @When("I click on the privacy policy using page object")
    public void i_click_on_the_privacy_policy_using_page_object() {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.clickOnPrivacyButton();
    }
    @When("I click on Continue button on the register account page using page object")
    public void i_click_on_continue_button_on_the_register_account_page_using_page_object() {
        // Write code here that turns the phrase above into concrete actions
        Registerpage registerpage = new Registerpage(driver);
        registerpage.clickOnContinueButton();
    }

}
