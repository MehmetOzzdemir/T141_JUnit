package day16_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C03_GetScreenshotMethodKullanimi extends TestBase {


    @Test
    public void test01() throws IOException {

        //testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com/");

        //phone icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        //ve fotografini cekin

        WebElement searchBoxElement = driver.findElement(By.className("product-count-text"));
        String expectedText = "0 Products Found";
        String actualText = searchBoxElement.getText();

        Assertions.assertNotEquals(expectedText, actualText);

        ReusableMethods.wait(1);
        ReusableMethods.allPagescreenshot();

        //ilk urune tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        //acilan sayfada urun isminde case sensitive olmadan phone bulundugunu test edin
        //ve fotografini cekin

        String expectedProductName = "phone";
        String actualProductName = driver.findElement(By
                .xpath(" //*[@class=' heading-sm mb-4']")).getText().toLowerCase();

        Assertions.assertTrue(actualProductName.contains(expectedProductName));
        ReusableMethods.wait(1);
        ReusableMethods.allPagescreenshot();

    }
}
