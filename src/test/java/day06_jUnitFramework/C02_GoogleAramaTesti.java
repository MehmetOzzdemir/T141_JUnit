package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_GoogleAramaTesti {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        //driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        //cookies cıkmazsa tiklamak zorunda degilsin


        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String exceptedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(exceptedTitle)) {
            System.out.println("Title Test PASSED");
        } else
            System.out.println("Title Test Failed");


        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);


        //6- İlk ürüne tıklayiniz
        driver.findElement(By.xpath("//a/div[text()='Alışveriş']")).click();
        Thread.sleep(3000);
        List<WebElement> productPictureList = driver.findElements(By.xpath("//a[@rel='noopener']"));
        productPictureList.get(1).click();
        Thread.sleep(3000);


        //Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
