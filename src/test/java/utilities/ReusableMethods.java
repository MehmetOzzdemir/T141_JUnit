package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static void wait( int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> StringListChange(List<WebElement> webElementList){
        List<String> istenenStringList = new ArrayList<>();
        for (WebElement eachElement : webElementList){
            istenenStringList.add(eachElement.getText());
        }
        return istenenStringList;


    }
}
