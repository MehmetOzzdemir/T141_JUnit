package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionsClass extends TestBase {


    //4- Tamam diyerek alert’i kapatalim


    @Test
    public void test01() {
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin

            //1.Adim actions objesi olusturma
        Actions actions = new Actions(driver);

            //2.adim actions ile kullanacagimiz WebElementi locate etme
        WebElement GDIDronesJScript = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.wait(1);
            //3.adim actions objesi ile baslayip
            //  istenen webElementi uzerinden istenen eylemi yapalim
            //  en sonda perform diyelim

        actions
                .contextClick(GDIDronesJScript)
                .perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertText = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertText =driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertText,actualAlertText);

        //4- Tamam diyerek alert’i kapatalim
        ReusableMethods.wait(1);
        driver.switchTo().alert().accept();

        ReusableMethods.wait(3);


    }
}
