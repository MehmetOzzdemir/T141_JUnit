package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class C01_DisardanWebDriverKullanma {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        //url in testotomasyonu icerdigini test edin
        String expectedUrl= "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url Test PASSED");
        }else
            System.out.println("Url Test FAILED");

        //sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
