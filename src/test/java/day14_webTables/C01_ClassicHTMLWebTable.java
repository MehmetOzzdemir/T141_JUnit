package day14_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_ClassicHTMLWebTable extends TestBase {


    @Test
    public void test01() {

        //Bir Web Tablosu Klasik HTML taglari ile olusturulmussa
        //(teble-thead-tbody-tr) sadece taglari kullanarak
        //istedigimiz tum web elementleri locate edebiliriz


        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement allBodyElement = driver.findElement(By.xpath("//tbody"));
        System.out.println("All Body : \n" + allBodyElement.getText());


        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTable = "Comfortable Gaming Chair";
        String actualTable = allBodyElement.getText();
        Assertions.assertTrue(actualTable.contains(expectedTable));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        int expectedRowNumber = 5;
        List<WebElement> rowElementList = driver.findElements(By.xpath("//tbody/tr"));
        int actualRowNumber = rowElementList.size();
        Assertions.assertEquals(expectedRowNumber, actualRowNumber);
        System.out.println("****************");
        //5. Tum satirlari yazdirin
        System.out.println("All Rows : ");
        for (int i = 0; i < rowElementList.size(); i++) {
            System.out.println((i + 1) + " . Row \n" + rowElementList.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //sutun sayisi webtable da YOKTUR, bir satirdaki data sayisi vardir
        //kac sutun oldugunu gormek icin herhangi bir satirdaki data sayisina bakabiliriz

        List<WebElement> firstColumnElements =
                driver.findElements(By.xpath("//tbody/tr[1]//td"));
        int expectedColumnNumber = 4;
        int actualColumnNumber = firstColumnElements.size();
        Assertions.assertEquals(expectedColumnNumber, actualColumnNumber);


        //7. 3.sutunu yazdirin
        //Web tablosunda Surun yoktur
        //ama HER satirdaki 3.DATA yi alip sütun elde edebilriz
        System.out.println("**************");
        List<WebElement> thirdColumnElements =
                driver.findElements(By.xpath("//tbody/tr//td[3]"));

        System.out.println("3 . Columns : " + ReusableMethods.StringListChange(thirdColumnElements));
        System.out.println();

        //8. Tablodaki basliklari yazdirin
        List<WebElement> tHeadList = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Head : " + ReusableMethods.StringListChange(tHeadList));


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(rowAndColumn(1, 1));
        System.out.println();

        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedData = "Furniture";
        String actualData = rowAndColumn(4, 2);
        Assertions.assertEquals(expectedData, actualData);

        //11. Category i Men Fashion olan urun bulundugunu test edin
        boolean isMenFashion = false;
        for (int i = 0; i < actualRowNumber; i++) {
            if (rowAndColumn(i, 2).equals("Men Fashipn")) {
                isMenFashion = true;
            }

        }
    }


    public String rowAndColumn(int row, int column) {


        String rowAndColumn = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]")).getText();
        return rowAndColumn;
    }

}
