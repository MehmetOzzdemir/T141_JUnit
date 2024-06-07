package day09_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.TestBaseAll;

import java.awt.*;
import java.util.List;

public class C03_IFrame extends TestBaseAll {

    //1- https://testotomasyonu.com/discount adresine gidin
    //2- Elektronics Products yazisinin gorunur olduğunu test edin
    //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
    //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
    //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
    //7- Sayfayi kapatin


    @Test
    public void iFrameTest() {
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        //Electronics Product YAzisinin bir iframe icinde oldugunu gördük
        //o yaziya ulasabilme icin 3 adim atmamiz gerekir
        //birinci adim : ELectronics Products in icinde oldugu iFrame i Locate edelim
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));

        //ikinci adim Locate ettigimiz iFrame e gecis yapalim
        driver.switchTo().frame(electronicsIframe);

        //ucuncu adim : artik bu iframe icindeki elementleri kullanabilirsiniz
        //ONEMLİ : bir iFrame e gecis yapinca siz oradan cikmadikca
        //          driver o iFrame icinde kalacaktir

        WebElement electronicsProductsElementText = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsElementText.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedProductName = "DELL Core I3 11th Gen";
        String actualProductName = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']")).getText();

        Assertions.assertEquals(expectedProductName, actualProductName);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        //biz soldaki iframe in icinde oldugumuzdan
        //sagdaki iframe gecmek icin soldakinden cikmaliyiz

        driver.switchTo().defaultContent();
        //sagdaki iframe gecis yapmak icin 3 adim
        // 1-fascion u locate ederiz
        WebElement fashionIframeElement = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframeElement);
        //iframe in icine girmeliyiz
        //artik sagdaki frame in icindeyiz istedigimiz gibi locate edebiliriz

        //iframe icindeki tum urunleri bir liste olarak locate ettik
        List<WebElement> fashionProductNameIframeList = driver.findElements(By.tagName("p"));
        //listedeki tum urun isimlerini tek tek ele alalim
        //'men Slim Fit' icerem var mi kontrol edelim

        boolean isContainsMenSlimFit = false;
        for (WebElement eachProductName : fashionProductNameIframeList) {
            if (eachProductName.getText().contains("Men Slim Fit")) {
                isContainsMenSlimFit = true;
            }
        }

        Assertions.assertTrue(isContainsMenSlimFit);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionElementText = driver.findElement(By.xpath("//*[text()='Fashion']"));
        Assertions.assertTrue(fashionElementText.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
                    // sagdaki iframe'in icinde oldugumuzdan
                    // here are... yazisini locate edebilmek ve kullanabilmek icin
                     // oncelikle sagdaki iframe'den anasayfaya cikmaliyiz

        //driver.switchTo().defaultContent(); //nerde oldugu onemli degil direk anasayfaya gecis yapar
        driver.switchTo().parentFrame(); //ic ice birden fazla iframe katmani varsa
                                        //bu komut bir ust katmana cikartir
                                        //yaptigimiz ornek icin bu iki method un farki yok


        WebElement homepageText = driver.findElement(By.xpath("//*[text()='Here are some products.']"));
        Assertions.assertTrue(homepageText.isDisplayed());

    }
}
