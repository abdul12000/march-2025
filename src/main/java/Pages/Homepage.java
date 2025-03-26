package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    WebDriver driver;
private By myAccount = By.xpath("//a[@class='icon-left both nav-link dropdown-toggle']");

public Homepage(WebDriver driver){
    this.driver= driver;
}
public void clickMyAccountMenu(){
    driver.findElements(myAccount).get(2).click();
}
}
