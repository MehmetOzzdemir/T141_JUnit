package day16_getScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshot extends TestBase {


    @Test
    public void searchTest() throws IOException {

        //testotomasyonu anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        //Java icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("java" + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin

        WebElement searchBoxElement = driver.findElement(By.className("product-count-text"));
        String expectedText = "0 Products Found";
        String actualText = searchBoxElement.getText();
        //Screenshot almak icin 4 adim atariz

        ReusableMethods.wait(1);
        //1.adim TakeScreenshot objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2.adim cektigimiz screenshot u kaydedecegimiz dosyayi olusturalim
        //      dosya uzantisi jpg,jpeg,png
        //      dosya yeri target altinda screenshot olsun


        String screenshotPath = "target/screenshots";
        File allPageScreenshot = new File(screenshotPath+"/ekranResmi.png");

        //3 adim sayfa fotografini cekip gecici bir dosyaya yukleyelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4.adim gecici dosyayi asil olusturdugumuz dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,allPageScreenshot);



        Assertions.assertNotEquals(expectedText, actualText);


    }
}
