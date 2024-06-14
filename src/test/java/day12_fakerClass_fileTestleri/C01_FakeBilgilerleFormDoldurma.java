package day12_fakerClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_FakeBilgilerleFormDoldurma extends TestBase {







    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();

        //4- Ad, soyad, mail ve sifre kutularina fake degerler yazalim ve Sign Up butonuna basalim

        Faker faker = new Faker();
        //System.out.println(faker.food().fruit());
        //System.out.println(faker.address().zipCodeByState("TX"));
        //System.out.println(faker.name().fullName());
        //System.out.println(faker.company().name());
        //System.out.println(faker.internet().emailAddress());

        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id='firstName']"));
        Actions actions = new Actions(driver);

        String password = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();
        ReusableMethods.wait(1);

        actions.click(firstNameElement)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();

        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //5- Kaydin olusturuldugunu test edin


        ReusableMethods.wait(2);
        WebElement eMailElement = driver.findElement(By.id("email"));


        actions.click(eMailElement)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();

        driver.findElement(By.id("submitlogin")).click();


        WebElement logOutButton = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logOutButton.isDisplayed());

        ReusableMethods.wait(2);





    }
}
