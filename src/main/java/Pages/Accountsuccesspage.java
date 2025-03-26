package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accountsuccesspage {
    WebDriver driver;
private By successtext = By.xpath("//li[contains(text(),'Success')]");

public Accountsuccesspage(WebDriver driver){
    this.driver= driver;

}


}
