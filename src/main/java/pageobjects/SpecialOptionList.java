package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialOptionList {
    WebDriver driver;
    public SpecialOptionList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"body-content\"]/div[1]/div[2]/div/div[2]/a")
    private WebElement addProduct;

    @FindBy(id = "title")
    private WebElement title;

    @FindBy(name="submit")
    private WebElement add;

    public void addProduct(String[] products){

        for(String str:products) {
            addProduct.click();
            title.sendKeys(str);
            add.click();
            addProduct.click();
        }
    }
}
