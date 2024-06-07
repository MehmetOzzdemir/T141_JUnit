package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_BeforeAfterMethodlarininOnemi {


    // driver olusturma ve driver'i kapama islemlerinin
    // @Test method'unun icinde mi olmasi daha iyidir
    // yoksa @Before... ve @After... ile yapilmasi mi daha iyidir


    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
/*
    @Test
    public void searchTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement searchBox =driver.findElement(By.id("global-search"));
        searchBox.sendKeys("java",Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> productElementList = driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(productElementList.size()>0);

        driver.quit();

    }

 */

    @Test
    public void searchTest() {
        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("java", Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> productElementList = driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(productElementList.size() > 0);
        
        ReusableMethods.wait(3);

    }

}
