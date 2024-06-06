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


public class C03_JUnitAssertions {

    /*
        JUnit assertions calistirdiginda failed olursa
        kod un hata verdigi yeri daha kolay bulabilmemiz icin
        JUnit altini TURUNCU NOKTALAR ile isaretler

        turuncu noktalar KIRMIZI ALTI VİZGİ(CTE) degildir
        testin nerede hata verdigini bize gosteren gecici isaretlerdir
        testi PASSED oldugunda bu turuncu noktalar kaybolur

        EGER FAILED oldugunda Console da bir aciklama yazmasini istersek
        Assertion da message ekleyebiliriz


     */
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

        //actualUrl in expectedUrl icerdigini test edin
        Assertions.assertTrue(actualUrl.contains(expectedUrl), "URL istenen icerigi barindirmiyor");

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


        //listenin size i 0 dan buyuk oldugunu test edin
        Assertions.assertTrue(productSearchList.size() > 0, "Listenin size i 0 dan buyuk degil ");
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
        //urun isminin case sensitive olmadan phone icerdigini test edin
        Assertions.assertTrue(actualProductName.contains(expectedProductName), "Urun ismi case sensitive olmadan phone barindirmiyor");

        Thread.sleep(3000);
    }


}
