package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LambdaStepDefinitions {

WebDriver driver;

@Before
    public void innitialize(){

        WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
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
        assertThat(pageTitle,is(equalTo("Register Account")));

    }


}
