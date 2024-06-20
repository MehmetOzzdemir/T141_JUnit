package day14_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_FarkliTaglarlaOlusturulanWebTable extends TestBase {

    @Test
    public void test01() {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> allheadersElements =
                driver.findElements(By.xpath("//*[@role='columnheader']"));
        System.out.println("All headers : " + ReusableMethods.StringListChange(allheadersElements));

        // 3. 3.sutunun basligini yazdirin
        System.out.println();
        System.out.println("3. Header : " + allheadersElements.get(3).getText());

        // 4. Tablodaki tum datalari yazdirin
        WebElement allTableElements =
                driver.findElement(By.xpath("//*[@class='rt-table']"));
        System.out.println("All Data : \n " + allTableElements.getText());

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println();
        List<WebElement> allDataElementsList =
                driver.findElements(
                        By.xpath("//*[@role='rowgroup']/*[@role='row']/*[@role='gridcell']"));
        int count = 0;
        for (int i = 0; i < allDataElementsList.size(); i++) {
            if (!allDataElementsList.get(i).getText().equals(" ")) {
                count++;
            }
        }
        System.out.println("All Data Numbers : " + count);

        // 6. Tablodaki satir sayisini yazdirin
        System.out.println();
        List<WebElement> allRowNumbers =
                driver.findElements(By.xpath("//*[@role='rowgroup']"));

        System.out.println("All Row Numbers : " + allRowNumbers.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println();
        System.out.println("All Column Numbers : " + allheadersElements.size());

        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println();
        List<WebElement> thirdColumnElement =
                driver.findElements(
                         By.xpath("//*[@role='rowgroup']/*[@role='row']/*[@role='gridcell'][3]"));

        System.out.println("3. Column : " + ReusableMethods.StringListChange(thirdColumnElement));

        //9. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirsin
        System.out.println();
        System.out.println("İstenen Data : " + rowAndColumn(3, 2));

        // 10. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println();
        for (int i = 1; i <allRowNumbers.size() ; i++) {
            if (rowAndColumn(i,1).equals("Kierra")){
                System.out.println(rowAndColumn(i,1)+"'s Salary : "+rowAndColumn(i,5));
            }
        }
    }

    public String rowAndColumn(int row, int column) {
        String rowAndColumn = driver.findElement(
                By.xpath("//*[@role='rowgroup'][" + row
                        + "]/*[@role='row']/*[@role='gridcell'][" + column + "]")).getText();


        return rowAndColumn;
    }
}
