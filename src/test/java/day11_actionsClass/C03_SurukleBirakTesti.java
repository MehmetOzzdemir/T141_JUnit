package day11_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_SurukleBirakTesti extends TestBase {


    @Test
    public void test01() {


        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement acceptableElement = driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement dropHereElement = driver.findElement(By.xpath("//*[text()='Drop Here']"));
        ReusableMethods.wait(1);
        actions.dragAndDrop(acceptableElement, dropHereElement).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedText = "Dropped!";
        String actualText = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assertions.assertEquals(expectedText, actualText);


        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.wait(1);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElement = driver.findElement(By.xpath("//*[text()='Not Acceptable']"));
        dropHereElement = driver.findElement(By.xpath("//*[text()='Drop Here']"));
        actions.dragAndDrop(notAcceptableElement, dropHereElement).perform();


        //6- “Drop Here” yazisinin degismedigini test edin
        expectedText = "Drop Here";
        actualText = dropHereElement.getText();
        Assertions.assertEquals(expectedText, actualText);


        ReusableMethods.wait(2);


    }
}
