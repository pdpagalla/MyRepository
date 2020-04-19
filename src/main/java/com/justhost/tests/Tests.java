package com.justhost.tests;

import com.justhost.base.Base;
import org.testng.annotations.*;
import pageobjects.AdminLogin;
import pageobjects.DashBoard;

public class Tests extends Base {

  @BeforeClass
    public void beforeTest() { navigatToURl(); }

    @Test(enabled=true)
    public void addCategory() {

        AdminLogin adminLogin = new AdminLogin(driver);
        adminLogin.login();

        DashBoard dashBoard = new DashBoard(driver);
        //dashBoard.verifyTitle();
        dashBoard.clickMainMenu();
        dashBoard.clickCategory();
        dashBoard.clickAddCategory();
        dashBoard.addNewProducts();







        /*Properties props = new Properties();
        InputStream inStream = getClass().getClassLoader().getResourceAsStream("environment.properties");
            props.load(inStream);
        Object cats = props.get("Title");
        String[] noOfItems= cats.toString().split(",");

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("Categories");
        String path = url.getPath();

        for(String str:noOfItems) {
            for(File str1: new File(path).listFiles()) {
                if(str1.toString().contains(str)) {
                    System.out.println(str1.toString());
                    driver.findElement(By.name("title")).sendKeys(str);
                    driver.findElement(By.name("image")).sendKeys(str1.toString());
//			    		driver.findElement(By.name("submit")).click();
                }
            }
        }*/

    }

    @AfterClass
    public void afterTest(){
        driver.close();
    }

}
