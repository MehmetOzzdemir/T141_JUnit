package day07_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    //a. Verilen web sayfasına gidin.
    //https://testotomasyonu.com/form
    //b. Sirt Agrisi ve Carpinti checkbox’larini secin
    //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
    //d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin


    WebDriver driver;
    @BeforeEach
    public  void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    public void teardown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //b. Sirt Agrisi ve Carpinti checkbox’larini secin

        //Secme islemi hem yazidan hem kutudan yapilabildiginden Testin daha efektif olabilmesi icin
        //Sirt agrisini kutudan,carpintiyi yazidan secelim


        WebElement sirtAgrisiChecKBox =driver.findElement(By.xpath("//input[@id='gridCheck5']"));
        sirtAgrisiChecKBox.click();
        WebElement carpintiYazisi =driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiYazisi.click();

        //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        //  carpintiyi yazidan sectik ama yazidan test yapamayiz
        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));

        Assertions.assertTrue(sirtAgrisiChecKBox.isSelected());
        Assertions.assertTrue(carpintiCheckBox.isSelected());


        Thread.sleep(3000);


        //d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        sirtAgrisiChecKBox.sendKeys(Keys.PAGE_DOWN);

        WebElement sekerCheckBox =driver.findElement(By.xpath("//*[@id='hastalikCheck2']"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));


        Assertions.assertFalse(sekerCheckBox.isSelected());
        Assertions.assertFalse(epilepsiCheckBox.isSelected());



    }


}
