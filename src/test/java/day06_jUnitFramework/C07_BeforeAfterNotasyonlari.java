package day06_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeAfterNotasyonlari {
    WebDriver driver;

    //Eger siradam bir methodun her test methodundan once calismasini isterseniz

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test
    public void googleTesti() {

        // google anasayfaya gidin
        driver.get("https://www.google.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("google testi PASSED");
        } else System.out.println("google testi FAILED");


    }

    @Test
    public void testotomasyonuTesti() {


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // anasayfaya gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");


    }

    @Test
    public void wisequarterTest() {

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

    }
}