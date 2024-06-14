package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionClass extends TestBase {


    @Test
    public void test01() {

        //1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).perform();

        //3- videoyu izlemek icin Play tusuna basin


        //video iframe icinde oldugundan once iframe gecmeliyiz
        WebElement videoIFrameElement = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(videoIFrameElement);


        driver.findElement(By.xpath("//*[@title='Oynat']")).click();
        ReusableMethods.wait(1);

        //4- videoyu calistirdiginizi test edin
        WebElement pauseButtonElement = driver.findElement(By.xpath("//*[@aria-label='Duraklat klavye kısayolu k']"));
        Assertions.assertTrue(pauseButtonElement.isDisplayed());

        ReusableMethods.wait(2);
    }
}
