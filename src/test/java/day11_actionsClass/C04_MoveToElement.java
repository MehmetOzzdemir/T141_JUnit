package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {


    @Test
    public void test01() {
        //1- https://testotomasyonu.com/adresine gidelim
        driver.get("https://testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsWearElement = driver.findElement
                (By.xpath("(//*[@class='has-sub'])[7]"));

        actions.moveToElement(kidsWearElement)
                .perform();

        ReusableMethods.wait(1);
        //3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[text()='Boys']"))
                .click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@class='prod-img']"))
                .click();

        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedText = "Boys Shirt White Color";
        String actualText = driver.findElement
                (By.xpath("//*[text()='Boys Shirt White Color']")).getText();

        Assertions.assertEquals(expectedText, actualText);

        ReusableMethods.wait(2);


    }
}
