package day16_getScreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JavaScriptExecutor extends TestBase {

    @Test
    public void test01() {

        // Testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.wait(2);

        // Best Sport Shoes For Multi Gender.  gorunene kadar asagi inin
        WebElement bestSportShoesElementi = driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));
        System.out.println(bestSportShoesElementi.getText());


        Actions actions = new Actions(driver);
        actions.moveToElement(bestSportShoesElementi).perform();
        ReusableMethods.wait(2);
        // bestSportShoesElementi.click();

        ReusableMethods.wait(2);
        //driver objesi bizim elimiz gozumuz gibidir
        //normalde ekranda gorunmeyen bir elementi kullanamamsi berekir
        //AMA bu developer'larin yazdigi koda gore degisir
        //bazi sayfalarda gorunmeyen elementleri kullanamazken
        //bazi sayfalarda kullanabiliriz


        driver.get("https://www.wisequarter.com");

        //why choose us? linkine kadar asagi inelim
        ReusableMethods.wait(2);


        WebElement whyChooseUsElement = driver.findElement(By.xpath("//*[text()='Why ']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView", whyChooseUsElement);


        ReusableMethods.wait(2);


        System.out.println(whyChooseUsElement.getText());

        ReusableMethods.wait(2);

        whyChooseUsElement.click();

        ReusableMethods.wait(3);

    }
}
