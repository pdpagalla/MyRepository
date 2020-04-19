package com.justhost.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    protected WebDriver driver = null;
    private static String url;
    static InputStream is = Base.class.getClassLoader().getResourceAsStream("environment.properties");

    static String uname ;
    static String pwd;
    public static String dashBoardTitle;
    static Object browser;

    static  {

        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url= props.getProperty("Url");
        uname = props.getProperty("Username");
        pwd = props.getProperty("Password");
        dashBoardTitle = props.getProperty("DashboardTitle");
        browser = props.get("Browser");
        System.out.println("Properties "+browser);
    }

    public final void navigatToURl(){
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
       driver.manage().window().maximize();
       driver.get(url);

   }

        public final void click(WebElement ele){
            ele.click();
        }

        public void enterText(WebElement ele,String text){
            ele.sendKeys(text);
        }

        public void pageLogin(WebElement arg1, WebElement arg2, WebElement arg3){
       System.out.println("argument in login "+arg1);
        arg1.sendKeys(uname);
        arg2.sendKeys(pwd);
        click(arg3);

   }

}
