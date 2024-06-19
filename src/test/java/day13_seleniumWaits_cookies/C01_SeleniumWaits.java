package day13_seleniumWaits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class C01_SeleniumWaits {

   @Test
   public void implicitlyWaitTest(){
      WebDriver driver =new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
      driver.get("https://the-internet.herokuapp.com/dynamic_controls");

      //2. Textbox’in etkin olmadigini(enabled) dogrulayın
      WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
      Assertions.assertFalse(textBox.isEnabled());

      //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
      driver.findElement(By.xpath("//*[text()='Enable']"))
              .click();


      //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
      ReusableMethods.wait(3);
      Assertions.assertTrue(textBox.isEnabled());

      //5. “It’s enabled!"” mesajinin goruntulendigini dogrulayın.
      String expectedText ="It's enabled!";
      String actualText = driver.findElement(By.xpath("//*[@id='message']")).getText();
      Assertions.assertEquals(expectedText,actualText);
      ReusableMethods.wait(3);

      driver.quit();

   }
   @Test
   public void explicitlyWaitTest(){

      WebDriver driver =new ChromeDriver();
      driver.manage().window().maximize();

      //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
      driver.get("https://the-internet.herokuapp.com/dynamic_controls");

      //2. Textbox’in etkin olmadigini(enabled) dogrulayın
      WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
      Assertions.assertFalse(textBox.isEnabled());

      //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
      driver.findElement(By.xpath("//*[text()='Enable']"))
              .click();

      //beklemeyi explicitly wait ile yapalim


      //1.adim : mümkünse bekleyeceginiz wabelementi locate edin
               //textbox görünür oldugu icin locate ettik

      //2adim : bir wai tobjesi olusturun
      WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

      //3.adim : wait objesini kullanarak
               //istenen durum gerceklesinceye kadar driver i bekleyin
              //biz textbox etkin oluncaya kadar beklemesini istiyoruz
      wait.until(ExpectedConditions.elementToBeClickable(textBox));


      //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
      Assertions.assertTrue(textBox.isEnabled());

      //5. “It’s enabled!"” mesajinin goruntulendigini dogrulayın.
      String expectedText ="It's enabled!";
      String actualText = driver.findElement(By.xpath("//*[@id='message']"))
              .getText();
      Assertions.assertEquals(expectedText,actualText);


      driver.quit();
   }


}
