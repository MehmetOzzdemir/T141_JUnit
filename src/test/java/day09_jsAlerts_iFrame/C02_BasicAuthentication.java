package day09_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {



    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin

        // driver.get("https://testotomasyonu.com/basicauth");
        // URL'e normal bir sekilde gitmek istersek
        // sonrasinda kullanici adi ve sifreyi otomasyonla yazmamiz  MUMKUN DEGILDIR

        //otomasyonla giriş yapabilmek icin
        //giriş yapmak istedigimiz firmadan
        //kullanici adi ve sifre ile birlikte
        //bu degerleri nasil yollayacagimiz BILGISINI almamiz
        //ve bize soylenen sekilde giris yapmamiz ZORUNLUDUR




        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement loginText = driver.findElement(By.xpath("//*[text()='Congratulations! You are logged in as: membername']"));

        Assertions.assertTrue(loginText.isDisplayed());

        ReusableMethods.wait(3);

    }



}
