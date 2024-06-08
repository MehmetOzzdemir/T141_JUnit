package day10_switchingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_KontrolluYeniWindowAcma extends TestBase {
  /*
        IKI SEY COK KOLAY

        1- yeni bir window olusturup driver'i o window'a gecirmek

           driver.switchTo().newWindow(istedigimizWindowTuru)

        2- Bir test sirasinda yeni window'lar actiysak
           kullandigimiz her window'un windowHandleDegerini kaydetti isek
           istenen window'a gecmek

           driver.switchTo().window(gecmekIstedigimizWindowunWHD)
     */


    @Test
    public void test01() {
        //testotomasyonuı anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        String toWHD = driver.getWindowHandle();

        //phone icin arama yapıp urun bulunabildigini test edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='global-search']"));
        searchBox.sendKeys("phone");
        searchBox.submit();

        List<WebElement> foundProducts = driver.findElements(By.className("prod-img"));
        Assertions.assertTrue(!foundProducts.isEmpty());
        System.out.println("switchTo().Window sonrasi:" + driver.getCurrentUrl());


        //yeni bir tab da youtube a gidin
        //ister tab ister ayri bir window acmak istedigimizde
        //Selenium 4 ile gelen switchTo().newWndow() methodunu KULLANMALIYIZ
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        String youtubeWHD = driver.getWindowHandle();

        //COK ONEMLİ : switchTo().newWindow() kullanildiginda
        //              yeni window'u driver'a olusturttugumuz icin
        //              driver OTOMATIK OLARAK yeni acilan WINDOW'a gecis yapar
        System.out.println("switchTo().Window sonrasi:" + driver.getCurrentUrl());


        //url in youtube icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";
        Assertions.assertTrue(actualUrl.contains(expectedUrl));
        ReusableMethods.wait(3);
        //yeni bir weindow acip best buya gidin
        driver.switchTo().newWindow(WindowType.WINDOW);

        String bestbuyWHD = driver.getWindowHandle();
        driver.get("https://www.bestbuy.com");


        //tittle in Best icerdigini test edin
        String actualBestTitle = driver.getTitle();
        String expectedBestTitle = "Best";
        Assertions.assertTrue(actualBestTitle.contains(expectedBestTitle));
        ReusableMethods.wait(3);

        /*
            EGer testimiz sirasinda birden fazla windoıw acildi
            ve bu windowlar arasinda gecis yapilmasi gerekiyorsa
            kullandigimiz her windowun WindowHandle degerlerini kaydetmeli
            ve ihtiyac duyulduugunda bu WindowHandle degerleri ile o window a gecis yapmaliyiz

         */
        //bu satir itibariyle driver bestbuy in a
        System.out.println("to WHD: " + toWHD);
        System.out.println("youtube WHD: " + youtubeWHD);
        System.out.println("bestbuy WHD :" + bestbuyWHD);
        System.out.println("acilan 3 windowun WHD:" + driver.getWindowHandles());
        ReusableMethods.wait(3);

        ///youtube un acik oldugu window a geri donun
        driver.switchTo().window(youtubeWHD);
        //ve title icin Youtube icerdigini test edin
        String expectedYoutubeTitle = "YouTube";
        String actualYoutubeTitle = driver.getTitle();
        Assertions.assertTrue(actualYoutubeTitle.contains(expectedYoutubeTitle));
        ReusableMethods.wait(3);
        //testotomasyonu nun acik oldugu window a geri donun
        driver.switchTo().window(toWHD);
        //ve title in "Test Otomasyonu" icerdigini test edin
        String expectedToTitle = "Test Otomasyonu";
        String actualToTitle = driver.getTitle();
        Assertions.assertTrue(actualToTitle.contains(expectedToTitle));

        ReusableMethods.wait(3);
    }


}
