package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_TestBaseClassKullanimi extends TestBase {



    @Test
    public void searchTest() {
        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> productElementList = driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(productElementList.size() > 0);

        ReusableMethods.wait(3);

    }
}
