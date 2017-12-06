package ru.stqa.pft.tsumtest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class MakeNewAddressTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://omega.dev.tsum.com/login/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMakeNewAddress() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("moiseenkoartem@yandex.ru");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Мои адреса')])[4]")).click();
    driver.findElement(By.xpath("//div[2]/div/div/div[2]/div/div")).click();
    driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/form/div/div/div/div/span")).click();
    driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/form/div/div/div/ul/li/span")).click();
    driver.findElement(By.xpath("(//input[@name='profile[CITY]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[CITY]'])[11]")).sendKeys("Москва");
    driver.findElement(By.cssSelector("span.link.autocomplete__link")).click();
    driver.findElement(By.xpath("(//input[@name='profile[STREET]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[STREET]'])[11]")).sendKeys("Улица");
    driver.findElement(By.xpath("(//input[@name='profile[ZIP]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[ZIP]'])[11]")).sendKeys("111111");
    driver.findElement(By.xpath("(//input[@name='profile[HOME]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[HOME]'])[11]")).sendKeys("111111");
    driver.findElement(By.xpath("(//input[@name='profile[STROENIE]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[STROENIE]'])[11]")).sendKeys("11111");
    driver.findElement(By.xpath("(//input[@name='profile[FLAT]'])[11]")).clear();
    driver.findElement(By.xpath("(//input[@name='profile[FLAT]'])[11]")).sendKeys("11111");
    driver.findElement(By.xpath("(//button[@type='submit'])[11]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
