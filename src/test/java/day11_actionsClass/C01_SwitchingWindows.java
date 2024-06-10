package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_SwitchingWindows extends TestBase {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        String firstPageWHD =driver.getWindowHandle();

        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        WebElement electronicsProductsFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsProductsFrame);
        WebElement electronicsProductsElement = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsElement.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElement = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"));
        String actualText = dellElement.getText();
        String expectedText = "DELL Core I3 11th Gen";
        Assertions.assertEquals(actualText,expectedText);

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        dellElement.click();

        Set<String> allWindowWHD = driver.getWindowHandles();
        String secondWindowWHD = "";

        for (String eachWHD : allWindowWHD) {
            if (!eachWHD.equals(firstPageWHD)) {
                secondWindowWHD = eachWHD;
            }
        }
       driver.switchTo().window(secondWindowWHD);
        String actualPrice = driver.findElement(By.xpath("//*[@id='priceproduct']")).getText();
        String expectedPrice ="$399.00";
        Assertions.assertEquals(actualPrice,expectedPrice);

        //5- Ilk windowa donun ve Fashion yazisinin gorunur olduğunu test edin

        ReusableMethods.windowaGec("https://testotomasyonu.com/discount",driver);

        driver.switchTo().defaultContent();
        WebElement fashionFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionFrame);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Fashion']")).isDisplayed());



        ReusableMethods.wait(3);




    }
}
