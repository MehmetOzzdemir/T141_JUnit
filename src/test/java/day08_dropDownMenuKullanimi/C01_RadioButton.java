package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {


    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    static WebDriver driver;


    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }


    @Test
    public void letterChooseTest() {
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //b. Cinsiyet Radio button elementlerini locate edin
        WebElement radioButtonWoman = driver.findElement(By.id("inlineRadio1"));
        WebElement radioButtonMan = driver.findElement(By.id("inlineRadio2"));
        WebElement radioButtonOther = driver.findElement(By.id("inlineRadio3"));

        //c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        radioButtonMan.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertFalse(radioButtonWoman.isSelected());
        Assertions.assertFalse(radioButtonOther.isSelected());
        Assertions.assertTrue(radioButtonMan.isSelected());

    }

    @Test
    public void radioButtonChooseTest() {
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //b. Cinsiyet Radio button elementlerini locate edin
        WebElement radioButtonWoman = driver.findElement(By.id("inlineRadio1"));
        WebElement radioButtonMan = driver.findElement(By.id("inlineRadio2"));
        WebElement radioButtonOther = driver.findElement(By.id("inlineRadio3"));

        //c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
        radioButtonWoman.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertTrue(radioButtonWoman.isSelected());
        Assertions.assertFalse(radioButtonOther.isSelected());
        Assertions.assertFalse(radioButtonMan.isSelected());


    }


}
