package pageobjects;

import com.justhost.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//a[contains(text(),'Add Category')]")
    private WebElement addCategory;

    @FindBy(id = "title")
    private WebElement categoryTitle;

    @FindBy(id = "image")
    private WebElement imagePath;

    @FindBy(id = "desc")
    private WebElement categoryDesc;

    @FindBy(xpath = "//*[@id='sidebar']/ul/li[10]/a")
    private WebElement addSpecialOptionTypes;

    @FindAll(@FindBy(xpath = "//*[@id='sidebar']/ul/li[10]/ul/li"))
    private List<WebElement> specialOptionItem;

    public void clickAddSpecialOptionType() { click(addSpecialOptionTypes); }

    public void clickMainMenu() { click(mainmenu); }

    public void clickCategory() { click(category); }

    public void clickAddCategory() { click(addCategory); }

    public void verifyTitle() { driver.getTitle().equals(dashBoardTitle); }

    public void addNewProducts(){

        enterText(categoryTitle,"Sample title");
        enterText(imagePath,"D:\\JustHost\\images\\butterChickenButterRoti.jpeg");
        enterText(categoryDesc,"sample description ");
    }


}
