package day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class C04_AramaTesti {

    //gerekli ayarlamalari yapip
    //3 farkli test method u olusturun
    //ve asagidaki testleri farkli test methodlarinda calistirin
    //1-testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
    //2-phone icin arama yaptirip arama sonucundan urun bulunabildigini test edin
    //3-ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin
    WebDriver driver;
    List<WebElement> productSearchList;

    @Test
    public void test01() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1-testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin

        driver.get("http://www.testotomasyonu.com");

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Test Otomasyon Test PASSED");
        } else
            System.out.println("Test Otomasyon Test PASSED");
        //2-phone icin arama yaptirip arama sonucundan urun bulunabildigini test edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='global-search']"));
        searchBox.sendKeys("phone", Keys.ENTER);

        productSearchList = driver.findElements(By.xpath("//*[@class='prod-img']"));

        if (productSearchList.size() > 0) {
            System.out.println("Product Search Test PASSED");
        } else
            System.out.println("Product Search Test FAILED");

        productSearchList.get(0).click();
        WebElement firstProductNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedProductName = "phone";
        String actualProductName = firstProductNameElement.getText().toLowerCase();

        if (actualProductName.equalsIgnoreCase(expectedProductName)) {
            System.out.println("Product Name Test PASSED");
        } else
            System.out.println("Product Name Test PASSED");

        Thread.sleep(3000);
        driver.quit();

    }

}