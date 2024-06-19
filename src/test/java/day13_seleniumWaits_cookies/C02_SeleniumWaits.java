package day13_seleniumWaits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_SeleniumWaits {

    @Test
    public void implicitlyWaitTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        String exceptedText = "It's gone!";
        String actualText = driver.findElement(By.id("message"))
                .getText();
        Assertions.assertEquals(exceptedText,actualText);

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin
        exceptedText = "It's back!";
        actualText = driver.findElement(By.id("message"))
                .getText();
        Assertions.assertEquals(exceptedText,actualText);

        driver.quit();

    }

    @Test
    public void explicitlyWaitTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//*[text()='Remove']"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        String exceptedText = "It's gone!";
        String actualText = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals(exceptedText,actualText);

        //4. Add buttonuna basin
        WebElement addButton =driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addButton));

        //5. It’s back mesajinin gorundugunu test edin
        exceptedText = "It's back!";
        actualText = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals(exceptedText,actualText);

        driver.quit();

    }
    @Test
    public void explicitlyWaitTest2(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("//*[text()='Remove']"));
        removeButton.click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // 1.adim : mumkunse beklemek istedigimiz it's gone elementini locate edin
        // 2.adim : WebDriverWait objesi olusturun
        // 3.adim : wait objesi ve expectedConditions ile bekleme islemini yap

        // EGER beklemek istedigimiz elementi locate etmemiz mumkun degilse
        //      onu locate etmek icin beklemek gerekiyorsa 1. ve 3.adimi birlestirebiliriz

        // 2.adim
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // 1.(locate) ve 3.adim(bekleme) birlikte yazacagiz
        WebElement itsGoneElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assertions.assertTrue(itsGoneElement.isDisplayed());

        //4. Add buttonuna basin
        WebElement addButton =driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();

        //5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assertions.assertTrue(itsBackElement.isDisplayed());

        driver.quit();

    }
}
