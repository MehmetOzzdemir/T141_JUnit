package day14_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C02_FarkliTaglarlaOlusturulanWebTables extends TestBase {


    @Test
    public void test01() {

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));
        System.out.println("Headers : " + ReusableMethods.StringListChange(headerElementList));

        // 3. 3.sutunun basligini yazdirin
        System.out.println("3. Column Header : " + headerElementList.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        WebElement allTableElement = driver.findElement(By.className("table"));
        System.out.println("All Table : \n" + allTableElement.getText());
        // List<WebElement> allDataElements = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        // int count = 0;
        // System.out.println();
        // System.out.println("****All Datas*****");
        // System.out.println();
        // for (int i = 0; i <allDataElements.size() ; i++) {
        //     System.out.println(allDataElements.get(i).getText());
        //     count++;
        //     if (count%4==0){
        //         System.out.println();
        //     }
        // }

        // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println();
        List<WebElement> allBodyDataElements =
                driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        System.out.println("Body Cell Numbers : " + allBodyDataElements.size());

        // 6. Tablodaki satir sayisini yazdirin
        System.out.println();
        List<WebElement> allRowNumbers =
                driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("All Row Numbers : " + allRowNumbers.size());

        // 7. Tablodaki sutun sayisini yazdirin
        //  Yukarida basliklari bir liste olarak kaydetmistik
        System.out.println();
        System.out.println("All Column Numbers : " + headerElementList.size());
        List<WebElement> allColumnNumbers =
                driver.findElements(By.xpath("//*[@role='trow'][1]/*[@role='tdata']"));
        System.out.println("All Column Numbers : " + allColumnNumbers.size());

        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println();
        List<WebElement> thirdColumnElements =
                driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        System.out.println("3. Column Data : " + ReusableMethods.StringListChange(thirdColumnElements));

        //9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi dondursun
        System.out.println();
        System.out.println("istenen Data : "+rowAndColumnData(3, 2));

        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        for (int i = 1; i <=allRowNumbers.size(); i++) {
            if (rowAndColumnData(i, 2).equals("Furniture")) {
                System.out.println("Data Furniture Price : " + rowAndColumnData(i, 3));
            }
        }


    }

    public String rowAndColumnData(int row, int column) {
        String rowAndColumnData =
                driver.findElement(By
                                .xpath("//*[@role='trow'][" + row + "]/*[@role='tdata'][" + column + "]"))
                        .getText();

        return rowAndColumnData;
    }
}
