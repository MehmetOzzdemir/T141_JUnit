package day09_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_javaScriptAlert extends TestBase {

    /*
        Biz bir butona bastigimizda
        web sayfasinda bir uyari yazisi (alert) cikabilir

        Eger cikan alert uzerindeki butonlari locate edebiliyorsak
         olusan alert bit HTML ALERT dur
         ve diger tum elementler gibi locate edip kullanabiliriz

         ANCAK alert JS ile olusturulmussa
         alert uzerindeki yazilar ve butonlar locate edilemez

        dolayisiyla biz alerti diger webelementler gibi kapatamayiz veya kullanamayiz

        Selenium webdriver i js alert e gecirebilmemiz icin ozel bir method olusturmustur
        driver.swichTo().alert()....


     */

/*

 - Cikan prompt ekranina "Abdullah" yazdiralim
 - OK tusuna basarak alert'i kapatalim
 - Cikan sonuc yazisinin Abdullah icerdigini test edelim
 */


    @Test
    public void test01() {

        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //- 1.alert'e tiklayin
        WebElement jSAlert = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));

        jSAlert.click();
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String actualAlert = driver.switchTo().alert().getText();

        String expectedAlert = "I am a JS Alert";

        Assertions.assertEquals(expectedAlert, actualAlert);

        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() {
        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //- 2.alert'e tiklayin
        WebElement jSAlert = driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));

        jSAlert.click();


        // - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expectedResult = "You clicked: Cancel";
        String actualResult = driver.findElement(By.id("result")).getText();

        Assertions.assertEquals(expectedResult, actualResult);


    }

    @Test
    public void test03() {

        //- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //- 3.alert'e tiklayin
        WebElement jSAlert = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));

        jSAlert.click();


        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //      - OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //    - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedResult = "Abdullah";
        String actaualResult = driver.findElement(By.id("result")).getText();

        Assertions.assertTrue(actaualResult.contains(expectedResult));


    }

}
