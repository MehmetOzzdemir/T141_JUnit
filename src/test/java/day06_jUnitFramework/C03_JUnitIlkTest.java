package day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitIlkTest {

    /*
        -   @Test notasyonu siradan bir method u bagimsiz olarak calistirilabilen
            bir test method una donusturur

        -   JUnit bir class da birden fazla test method u oldugunda
            hangisinin once calistirilacagina kendisi karar verir
            biz bu konuda bir ongoruye sahip olamayiz
            ve siralamayi belirleyemeyiz

            (eger method isimleri test01,test02,test03... gibi yazilirsa bu siralamaya uyar)


     */

    @Test
    public void toTest() throws InterruptedException {

        //ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //anasayfaya gittigimizi test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Test Otomasyon Test PASSED");
        } else
            System.out.println("Test Otomasyon Test PASSED");

        Thread.sleep(3000);
        //sayfayi kapatin
        driver.quit();
    }

    @Test
    public void wiseTest() throws InterruptedException {

        //ayarlari yapin

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        //anasayfaya gittigimizi test edin
        String expectedUrl = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Wisequarter Test PASSED");
        } else
            System.out.println("Wisequarter Test PASSED");

        Thread.sleep(3000);
        //sayfayi kapatin
        driver.quit();
    }

    @Test
    public void youtubeTest() throws InterruptedException {

        //ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        //anasayfaya gittigimizi test edin
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Youtube Test PASSED");
        } else
            System.out.println("Youtube Test PASSED");

        Thread.sleep(3000);
        //sayfayi kapatin
        driver.quit();
    }

}
