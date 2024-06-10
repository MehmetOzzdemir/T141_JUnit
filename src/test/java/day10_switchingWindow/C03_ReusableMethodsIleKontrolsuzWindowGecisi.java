package day10_switchingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_ReusableMethodsIleKontrolsuzWindowGecisi extends TestBase {


    //● https://the-internet.herokuapp.com/windows adresine gidin.
//● Click Here butonuna basın.
//● Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu test edin
//● ilk window'a geri donun ve sayfa başlığının "The Internet" olduğunu test edin


    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();


        //Birden fazla window acildiginda WHD lerii ile islem yaptigimizda
        //test her calistiignda yeni WHD leri olsutugundan hazir method olusturmak zor
        //ama gectigimiz windowun URL veya titke i sabit oldugundan
        //onlari kullanabiliriz


        //● Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu test edin
        //once yeni windowa gecelim

        ReusableMethods.windowaGec("https://the-internet.herokuapp.com/windows/new", driver);
        String expectedTitle = "New Window";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(actualTitle, expectedTitle);


        //● ilk window'a geri donun ve sayfa başlığının "The Internet" olduğunu test edin
        ReusableMethods.windowaGec("https://the-internet.herokuapp.com/windows", driver);
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);


    }


}

