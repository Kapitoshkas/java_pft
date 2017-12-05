package ru.stqa.pft.tsumtest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class  RegistrationTests{
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void  RegistrationTests() {
        wd.get("https://redesign.tsum.com/");
        wd.findElement(By.cssSelector("button.header__subnav-back.js-header-back")).click();
        wd.findElement(By.linkText("Личный кабинет")).click();
        wd.findElement(By.linkText("Регистрация")).click();
        wd.findElement(By.name("REGISTER[NAME]")).click();
        wd.findElement(By.name("REGISTER[NAME]")).clear();
        wd.findElement(By.name("REGISTER[NAME]")).sendKeys("triu");
        wd.findElement(By.name("REGISTER[PERSONAL_BIRTHDAY]")).click();
        wd.findElement(By.name("REGISTER[PERSONAL_BIRTHDAY]")).clear();
        wd.findElement(By.name("REGISTER[PERSONAL_BIRTHDAY]")).sendKeys("11/11/1111");
        wd.findElement(By.name("REGISTER[EMAIL]")).click();
        wd.findElement(By.name("REGISTER[EMAIL]")).clear();
        wd.findElement(By.name("REGISTER[EMAIL]")).sendKeys("rrrr@eeee.rr");
        wd.findElement(By.name("REGISTER[PERSONAL_PHONE]")).click();
        wd.findElement(By.name("REGISTER[PERSONAL_PHONE]")).clear();
        wd.findElement(By.name("REGISTER[PERSONAL_PHONE]")).sendKeys("+1 (111) 111-1111");
        wd.findElement(By.name("REGISTER[PASSWORD]")).click();
        wd.findElement(By.name("REGISTER[PASSWORD]")).clear();
        wd.findElement(By.name("REGISTER[PASSWORD]")).sendKeys("123456");
        wd.findElement(By.xpath("//div[@class='header__popups']/div[1]/div/form/div[8]/button")).click();
        wd.findElement(By.cssSelector("button.header__subnav-back.js-header-back")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
