package day10_switchingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C02_KontolsuzAcilanYeniWindowGecis extends TestBase {


    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstPageWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();

        Assertions.assertEquals(actualText, expectedText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(actualTitle, expectedTitle);
        System.out.println("click yapmadan once whd : " + driver.getWindowHandle());
        System.out.println("click yapmadan acik olan tum windowlarin whd : " + driver.getWindowHandles());

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();





        //bu linki tikladigimizda kontrolsuz yeni bir window aciliyor
        //driver,kontolsuz acilan windowu bilmez ve otomayik olarak ILK WINDOWW da kalir
        //testimiz icin driveri yeni window a gecirmemiz gerekiyorsa
        //bunu BIZ YAPMALIYIZ
        //driver.switchTo().window(yeniacilanWindowWHD)

        System.out.println("***********************");
        System.out.println("click yaptiktan sonra whd : " + driver.getWindowHandle());
        System.out.println("click yaptiktan sonra acik olan tum windowlarin whd : " + driver.getWindowHandles());



        /*
            Kontolsuz acilan bir window varsa
            acilan kontrolsuz window handle degerini bulmaliyiz

            1-click yapmadan ilk windowun WHD!ini kaydettik (ornegin A1231)

            2-click yaptiktan sonra elimizde 2 window ve w WHD olacak
             2 WHD ini bir Set olarak kaydedebiliriz
             (ornegin A123 , B123123)

             3- Bu setteki WHD lerinde ilk WHD olmayani
                ikimciSAyfaWHD olarak kaydedelim

             4-artik 2. window un WHD ini biliyoruz
              o zaman driver.switchTo().window(ikinciSayfaWHD) ile
              ikinci window'a gecis yapabiliriz

         */

        Set<String> twoPageWHDs = driver.getWindowHandles();
        String secondWindowWHD = "";

        for (String eachWHD : twoPageWHDs) {
            if (!eachWHD.equals(firstPageWHD)) {
                secondWindowWHD = eachWHD;
            }
        }
        driver.switchTo().window(secondWindowWHD);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


         //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String expectedText1 = "New Window";
        String actualText1 = driver.findElement(By.tagName("h3"))
                .getText();

        Assertions.assertEquals(expectedText,actualText);


        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        driver.switchTo().window(firstPageWHD);
        String expectedTitle1 = "The Internet";
        String actualTitle2 = driver.getTitle();
        Assertions.assertEquals(expectedTitle1, actualTitle2);


    }

}
