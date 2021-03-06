package ru.stqa.pft.tsumtest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.tsumtest.model.AddressCreation;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://omega.dev.tsum.com/login/");
        login("moiseenkoartem@yandex.ru", "123456");
    }

    public void login(String username, String password) {
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(username);
        wd.findElement(By.cssSelector("form.popup__form.js-popup-form")).click();
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys(password);
        wd.findElement(By.xpath("//div[@class='popup__button']/button")).click();
    }

    public void submitAdressCreation() {
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[7]/button")).click();
    }

    public void initAndfillNewAddress(AddressCreation addressCreation) {
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[1]/div/div/div[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[1]/div/div/ul/li[1]/span")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[2]/div/div[1]/input[1]")).sendKeys("Москва");
        wd.findElement(By.cssSelector("span.link.autocomplete__link")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[3]/div/input")).sendKeys(addressCreation.getStreet());
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[4]/div/input")).sendKeys(addressCreation.getZip());
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[1]/input")).sendKeys(addressCreation.getHouse());
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[2]/input")).sendKeys(addressCreation.getStructure());
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).click();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).clear();
        wd.findElement(By.xpath("//div[@class='pa-my-address__form']/div/div[2]/div/div/form/div[5]/div/div/div[3]/input")).sendKeys(addressCreation.getApartment());
    }

    public void gotoAddressPage() {
        wd.findElement(By.xpath("//div[@class='inner__content']//a[.='Мои адреса']")).click();
    }

    public void deleteAddress() {
        wd.findElement(By.xpath("//div[@class='inner__main']//span[.='Удалить']")).click();
    }

    public void stop() {
        wd.quit();
    }
}
