package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods extends TestBase{

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> StringListChange(List<WebElement> webElementList) {
        List<String> istenenStringList = new ArrayList<>();
        for (WebElement eachElement : webElementList) {
            istenenStringList.add(eachElement.getText());
        }
        return istenenStringList;


    }

    public static void windowaGec(String hedefURL, WebDriver driver) {

        Set<String> allWindosWHDSet = driver.getWindowHandles();

        for (String eachWHD : allWindosWHDSet
        ) {
            driver.switchTo().window(eachWHD);
            if (driver.getCurrentUrl().equals(hedefURL)) {
                break;
            }

        }
    }


    public static void allPagescreenshot() throws IOException {
        //ekran resmi ismini dinamik hale getirebilmek icin
        //tarih muhru ekleyelim ekranResmi210620241322

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dateText = ldt.format(dateFormat);

        TakesScreenshot tss = (TakesScreenshot) driver;
        String screenshotPath="target/screenshots";
        File allPageScreenshot = new File(screenshotPath+"/ekranResmi"+dateText+".png");
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,allPageScreenshot);

    }
    public static void allPageScreenshot(String reportName) throws IOException {
        TakesScreenshot tss = (TakesScreenshot) driver;
        String screenshotPath="target/screenshots";
        File allPageScreenshot = new File(screenshotPath+"/"+reportName+".png");
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,allPageScreenshot);

    }

    public static void webELementScreenshot(WebElement photoWebElement)  {

        //ekran resmi ismini dinamik hale getirebilmek icin
        //tarih muhru ekleyelim ekranResmi210620241322

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dateText = ldt.format(dateFormat);
        //1. adim : fotograf cekecegimiz webelementi locate edelim

        //2.adim: resmi kaydedecegimiz File i olusturalim
        String screenshotPath="target/screenshots";
        File webElementSS = new File(screenshotPath+"/webElementSS-"+dateText+".png");;

        //3. adim screenshot alip gecici dosyaya kaydedelim
        File geciciDosya = photoWebElement.getScreenshotAs(OutputType.FILE);

        //4.adim gecici dosyayi asil dosyaya kopyalayim
        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

