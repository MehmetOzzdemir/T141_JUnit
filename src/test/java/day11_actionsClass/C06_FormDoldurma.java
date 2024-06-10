package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_FormDoldurma extends TestBase {


    @Test
    public void test01() {

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']")).click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id='firstName']"));
        Actions actions = new Actions(driver);
        ReusableMethods.wait(1);
        actions.click(firstNameElement)
                .sendKeys("Mehmet" + Keys.TAB)
                .sendKeys("Özdemir" + Keys.TAB)
                .sendKeys("mehmet.ozzdemir@hotmail.com" + Keys.TAB)
                .sendKeys("Mehmet123" + Keys.TAB)
                .sendKeys("Mehmet123").perform();
        ReusableMethods.wait(2);
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();
        //5- Kaydin olusturuldugunu test edin


        ReusableMethods.wait(2);
        WebElement eMailElement = driver.findElement(By.id("email"));


        actions.click(eMailElement)
                .sendKeys("mehmet.ozzdemir@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Mehmet123").perform();

        driver.findElement(By.id("submitlogin")).click();


        WebElement logOutButton = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logOutButton.isDisplayed());

        ReusableMethods.wait(2);

    }
}
