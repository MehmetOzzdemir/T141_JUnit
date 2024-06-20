package day15_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_SatirSayisiTest {


    @Test
    public void test01() throws IOException {
        //ulkeler excelindeki Sayfa2 ye gidelim
        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page2 = workbook.getSheet("Sayfa2");

        //son satir sayisinin indexinin 19 oldugunu test edelim
        int expectedPageLastNumber = 19;
        int actualPageLastNumber = page2.getLastRowNum();
        Assertions.assertEquals(expectedPageLastNumber, actualPageLastNumber);


        //fiziki olarak kullanilan satir sayisinin 8 oldugunu test edelim
        int expectedPagePhysicalNumber = 8;
        int actualPagePyhsicalNumber = page2.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedPagePhysicalNumber, actualPagePyhsicalNumber);

        //bos birakilan satirdaki hucreyi yazdirmak istersek
        //bos birakilan satirlari java row oalrak olusturmaz
        //olmayan bir row dan cell bilgisi istersek NPE olur

        //System.out.println(page2.getRow(4).getCell(2));//NullPointException
        //System.out.println(page2.getRow(14).getCell(3));//NullPointException

        //var olan bir satirda
        //KULLANILAN ALAN ICINDEKI  bos bir cell i yazdirirsak null yazdirir
        //KULLANILAN ALAN DISINDAKI bos bir cell i yazdirirsak null yazdirir

        //var olan satirda kullanilmayan celli yazdiralim
        System.out.println(page2.getRow(2).getCell(2));// null
        //20. satir 1.cell i yazdiralim
        System.out.println(page2.getRow(19).getCell(0)); // null
        //3. satir 10.cell i yazdiralim
        System.out.println(page2.getRow(2).getCell(9));//null
        //13. satir 13.cell i yazdiralim
        System.out.println(page2.getRow(12).getCell(12));//null

    }
}
