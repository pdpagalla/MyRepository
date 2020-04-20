package pageobjects;

import com.justhost.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Products extends Base {

    //WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id='body-content']//div[2]/a")
    private WebElement addProductButton;

    @FindBy(xpath = "//div[@class='rightpanel']//select")
    private WebElement addProductCategory;

    @FindBy(xpath = "//div[@class='rightpanel']//div[3]/span/input")
    private WebElement drinkRadioButton;

    @FindBy(xpath = "//a[@id='preview-edit-4']")
    private WebElement productType4;

    @FindBy(xpath = "//a[contains(text(),'Edit Product Setting')]")
    private WebElement editProductSettingButton;

    @FindBy(xpath = "//*[@id='price']")
    private WebElement produtSettingsPrice;

    @FindBy(xpath = "//button[contains(text(),'OK') and @class='btn btn-success modal-ok']")
    private WebElement productPriceOKButton;

    public void clickAddProductButton(){
        click(addProductButton);
    }

    public void selectCategory(String text){
        Select sel = new Select(addProductCategory);
        sel.selectByVisibleText(text);
    }

    public void selectDrinkProductType(){
        click(drinkRadioButton);
    }

    public void clickProductType4(){
        click(productType4);
    }

    public void clickEditProductSetting(String price){
        driver.switchTo().frame("frame-edit");
        click(editProductSettingButton);
        driver.switchTo().frame("form-frame");
        produtSettingsPrice.sendKeys(price);
        click(productPriceOKButton);
    }

    
}
