package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_FileUploadTesti extends TestBase {


    @Test
    public void test() {
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 2.chooseFile butonuna basalim

        //3.karate-logo.png dosyasini secelim.
        /*
        dosya sec butonuna bastigimizda
         bilgisarimizdaki dosyalar acilir
         driverin bilgisayarimizdaki dosyalara erisimi YOKTUR

         bunun yerine
         selenium kullanarak dosya secimi yapmak istedigimiz
         chooseFile butonunu locate edip
         yukleyecegimiz dosyann donsya ylunu sendKeys() ile yolluyoruz

         */

        String packagePath = "/Users/mehmetozdemir/IdeaProjects/T141_JUnit/src/test/java/day12_fakerClass_fileTestleri/karate-logo.png";

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(packagePath);

        ReusableMethods.wait(3);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        ReusableMethods.wait(2);
        WebElement uploadFiles = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        String actualText = uploadFiles.getText();
        String exceptedText = "File Uploaded!";
        Assertions.assertEquals(exceptedText, actualText);
    }
}
