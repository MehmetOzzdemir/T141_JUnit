package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

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
}

