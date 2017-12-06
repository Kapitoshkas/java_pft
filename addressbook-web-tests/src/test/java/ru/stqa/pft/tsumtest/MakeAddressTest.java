package ru.stqa.pft.tsumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MakeAddressTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void testMakeNewAddress() {
        wd.get("https://omega.dev.tsum.com/login/");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("moiseenkoartem@yandex.ru");
        wd.findElement(By.cssSelector("form.popup__form.js-popup-form")).click();
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("123456");
        wd.findElement(By.xpath("//div[@class='popup__button']/button")).click();
        wd.findElement(By.xpath("//div[@class='inner__content']//a[.='Мои адреса']")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[1]/div/div/div[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[1]/div/div/ul/li[1]/span")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).sendKeys("Москва");
        wd.findElement(By.cssSelector("span.link.autocomplete__link")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).sendKeys("Улица");
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).sendKeys("555555");
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).sendKeys("5555");
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).sendKeys("5555");
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).sendKeys("5555");
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[7]/button")).click();
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
