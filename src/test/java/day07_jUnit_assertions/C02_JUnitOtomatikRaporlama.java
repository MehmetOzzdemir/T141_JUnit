package day07_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class C02_JUnitOtomatikRaporlama {

    static WebDriver driver;
    static List<WebElement> productSearchList;

    @BeforeAll //Hicbir @Test method u calismadan en basta sadece 1 kere calisir
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterAll // Tum @Test methodlari calisip bittikten sonra en sonda 1 kere calisir
    public static void teardown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void homepageTest() throws InterruptedException {
        //1-testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin

        //testotomasyonu anasayfaya gidin
        driver.get("http://www.testotomasyonu.com");
        //testotomasyonu sayfasina gittiginizi test edin

        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Test Otomasyon Test PASSED");
        }else{
            System.out.println("Test Otomasyon Test FAILED");
            throw new AssertionError();
        }
        Thread.sleep(3000);
    }

    @Test
    @Order(2)
    public void PhoneSearchTest() throws InterruptedException {
        //2-phone icin arama yaptirip arama sonucundan urun bulunabildigini test edin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='global-search']"));
        searchBox.sendKeys("phone", Keys.ENTER);

        productSearchList = driver.findElements(By
                .xpath("//*[@class='prod-img']"));

        if (productSearchList.size() > 0) {
            System.out.println("Product Search Test PASSED");
        } else{
            System.out.println("Product Search Test FAILED");
            throw new AssertionError();
        }

        Thread.sleep(3000);

    }

    @Test
    @Order(3)
    public void firstProductNameTest() throws InterruptedException {
        productSearchList.get(0).click();
        WebElement firstProductNameElement =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedProductName = "phone";
        String actualProductName = firstProductNameElement
                .getText()
                .toLowerCase();

        if (actualProductName.equalsIgnoreCase(expectedProductName)) {
            System.out.println("Product Name Test PASSED");
        } else{
            System.out.println("Product Name Test FAILED");
            throw new AssertionError();
        }
        Thread.sleep(3000);
    }

}
