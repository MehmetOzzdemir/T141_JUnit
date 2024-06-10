package day11_actionsClass;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KeyboardbaseActions extends TestBase {

    //1- https://www.testotomasyonu.com sayfasina gidelim
    //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
    //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

    @Test
    public void test01() {
        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");


        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
        WebElement searchBox = driver.findElement(By.id("global-search"));


        Actions actions = new Actions(driver);

        actions.click(searchBox).
                keyDown(Keys.SHIFT)//shift tusuna 2. emre kadar basili tutar
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)//
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("ı")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.wait(1);

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        String expectedText = "DELL Core I3";
        String actualText = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"))
                .getText();

        Assertions.assertTrue(actualText.contains(expectedText));
        ReusableMethods.wait(2);

    }
}
