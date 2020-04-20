package pageobjects;

import com.justhost.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class DashBoard extends Base {
    //WebDriver driver;

    public DashBoard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id='sidebar']/ul/li[12]/a")
    private WebElement mainmenu;

    @FindBy(xpath = "//*[@id='sidebar']/ul/li[12]/ul/li[1]/a")
    private WebElement category;

    @FindBy(xpath = "//*[@id='sidebar']/ul/li[12]/ul/li[2]/a")
    private WebElement product;

    @FindBy(xpath = "//a[contains(text(),'Add Category')]")
    private WebElement addCategory;



    @FindBy(id = "title")
    private WebElement categoryTitle;

    @FindBy(id = "image")
    private WebElement imagePath;

    @FindBy(id = "desc")
    private WebElement categoryDesc;

    @FindBy(name = "submit")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id='sidebar']/ul/li[10]/a")
    private WebElement addSpecialOptionTypes;

    @FindAll(@FindBy(xpath = "//*[@id='sidebar']/ul/li[10]/ul/li"))
    private List<WebElement> specialOptionItem;

    public void clickAddSpecialOptionType() { click(addSpecialOptionTypes); }

    public void clickMainMenu() { click(mainmenu); }

    public void clickCategory() { click(category); }

    public void clickProduct() { click(product);}

    public void clickAddCategory() { click(addCategory); }

    public void verifyTitle() { driver.getTitle().equals(dashBoardTitle); }

    public void addNewProducts() throws InterruptedException {
        String[] categories = {/*"Beer Brands", "Vodka Brands", "Breezer Brands", "Brandy Brands", "Whiskey Brands",*/"Wines Brands","Water","Smokes"};
        String[] images = {/*"Beer", "Vodka", "Breezer","Brandy", "Whiskey",*/"Wines","Water","Smokes"};
        for (String brand : categories) {
            //click(addCategory);
            System.out.println(brand);
            enterText(categoryTitle, brand);
            for(String imageName:images) {
                if (brand.contains(imageName)) {
                    System.out.println(imageName);
                    enterText(imagePath, "D:\\JustHost\\BookMyBottles\\Category\\" + imageName + ".jpg");
                    //enterText(categoryDesc, "sample description ");
                    click(addButton);
                    Thread.sleep(20000);
                }
            }
            click(addCategory);

        }
    }

}
