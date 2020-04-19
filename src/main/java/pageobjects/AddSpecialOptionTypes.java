package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class AddSpecialOptionTypes {
    WebDriver driver;
    public AddSpecialOptionTypes(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
