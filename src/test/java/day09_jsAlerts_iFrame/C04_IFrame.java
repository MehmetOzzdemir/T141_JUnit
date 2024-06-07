package day09_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_IFrame extends TestBase {


    @Test
    public void iFrameTest(){

       // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
       // 2 ) Bir metod olusturun: iframeTest
       //   - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIFrameElement = driver.findElement(By.tagName("h3"));
        Assertions.assertTrue(anIFrameElement.isDisplayed());
        System.out.println(anIFrameElement.getText());

        ReusableMethods.wait(3);
        driver.findElement(By.xpath("//*[@aria-label='Close']")).click();
        ReusableMethods.wait(3);

       //   - Text Box’a “Merhaba Dunya!” yazin.
        //text box in iframe icinde oldugunu gorduk
        //oncelikle o iframe gecis yapalım

        //**** Text box a yazi yazilamadigi icin iptal

        //WebElement iframeTextBox = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        //driver.switchTo().frame(iframeTextBox);
        //
        //WebElement textBox = driver.findElement(By.tagName("p"));
        //textBox.clear();
        //textBox.sendKeys("Merhaba Dunya!");
//

       //   - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  yazisini konsolda yazdirin.
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assertions.assertTrue(elementalSelenium.isDisplayed());
        ReusableMethods.wait(2);



    }
}
