package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_DinamikFileUploadTest extends TestBase {



    @Test
    public void test() {
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 2.chooseFile butonuna basalim

        //3.day12 altindaki karate-logo.png dosyasini dinamik olarak secelim.


        String sourcePath = System.getProperty("user.dir")+
                "/src/test/java/day12_fakerClass_fileTestleri/karate-logo.png";







        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(sourcePath);

        ReusableMethods.wait(3);
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        ReusableMethods.wait(2);
        WebElement uploadFiles = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        String actualText = uploadFiles.getText();
        String exceptedText = "File Uploaded!";

        Assertions.assertEquals(exceptedText, actualText);

        ReusableMethods.wait(2);

        System.out.println("user.dir ===>> "+System.getProperty("user.dir"));
    }
}
