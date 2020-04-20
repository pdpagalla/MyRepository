package com.justhost.tests;

import com.justhost.base.Base;
import org.testng.annotations.*;
import pageobjects.AdminLogin;
import pageobjects.DashBoard;
import pageobjects.Products;

public class Tests extends Base {

  @BeforeClass
    public void beforeClass() { navigatToURl(); }

   // @BeforeTest
    public void beforeTest(){
        AdminLogin adminLogin = new AdminLogin(driver);
        adminLogin.login();

    }

    @Test(enabled=false)
    public void addCategory() throws InterruptedException {

       /* AdminLogin adminLogin = new AdminLogin(driver);
        adminLogin.login();*/

        DashBoard dashBoard = new DashBoard(driver);
        //dashBoard.verifyTitle();
        dashBoard.clickMainMenu();
        dashBoard.clickCategory();
        dashBoard.clickAddCategory();
        dashBoard.addNewProducts();

    }

    @Test(enabled=true)
    public void addProduct(){
        AdminLogin adminLogin = new AdminLogin(driver);
        adminLogin.login();
        DashBoard dashBoard = new DashBoard(driver);
        //dashBoard.verifyTitle();
        dashBoard.clickMainMenu();
        dashBoard.clickProduct();
        Products prod = new Products(driver);
        prod.clickAddProductButton();
        prod.selectCategory("Beer");
        prod.selectDrinkProductType();
        prod.clickProductType4();
        prod.clickEditProductSetting("150");
        //prod.enterProductPrice("150");

    }

    @AfterClass
    public void afterTest(){
        //driver.close();
    }

}
