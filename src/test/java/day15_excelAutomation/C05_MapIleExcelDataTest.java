package day15_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C05_MapIleExcelDataTest {


    @Test
    public void test01() throws IOException {

        //ulkeler excelinde Sayfa1 e gidin
        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");


        int lastRowIndex = page1.getLastRowNum();


        //Java ile ingilizce Ulke isimlerini ve ingilizce baskent isimlerini
        //bir Map olarak kaydedebiliriz
        //her satiri ele alip ulke ismini key, baskent ismini valu olarak map e ekleyelim

        Map<String, String> countryAndCenterMap = new TreeMap<>();

        for (int i = 0; i <= lastRowIndex; i++) {
            String rowCountryName = page1
                    .getRow(i)
                    .getCell(0)
                    .toString();
            String rowCenterName = page1
                    .getRow(i)
                    .getCell(1)
                    .toString();
        }


        //kayitli ulkaler arasinda ingilizce Netherlands olan bir ulke
        //bulundugunu test edin

        Assertions.assertTrue(countryAndCenterMap.containsKey("Netherlands"));

        //kayitli ulkeler icinde ingilizce ulke ismi Turkey olan ulkenin
        //ingilizce baskent isminin Ankara oldugunu test edin
        Assertions.assertEquals("Ankara",countryAndCenterMap.get("Turkey"));

        //ingilizce baskent ismi Berlin olan bir ulkenin oldugunu test edin
        Assertions.assertTrue(countryAndCenterMap.containsValue("Berlin"));


    }
}
