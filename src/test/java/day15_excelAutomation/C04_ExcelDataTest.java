package day15_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ExcelDataTest {


    @Test
    public void test01() throws IOException {

        //ulkeler excelinde Sayfa1 e gidin
        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");


        int lastRowIndex = page1.getLastRowNum();

        //kayitli ulkaler arasinda ingilizce Netherlands olan bir ulke
        //bulundugunu test edin

        boolean isNetherland = false;
        for (int i = 0; i <= lastRowIndex; i++) {
            // o satirdaki ingilizce ulke ismini kontrol edip
            //Netherlands ise flag i true yapalim
            String rowCountryName = page1.getRow(i).getCell(0).toString();
            if (rowCountryName.equals("Netherlands")) {
                isNetherland = true;
            }
        }
        Assertions.assertTrue(isNetherland);

        //kayitli ulkaler şcşnde ingilizce baskent ismi Ankara olan ulkenin
        //ingilizce isminin Turkey oldugunu test edin

        for (int i = 0; i <= lastRowIndex; i++) {
            //her satirdaki ingilizce baskent ismine bakalim
            //Ankara bulursak O satirdaki ingilizce ulke isminin Turkey oldugunu test edelim

            String rowCenterName = page1.getRow(i).getCell(1).toString();
            if (rowCenterName.equalsIgnoreCase("Ankara")) {
                String rowCountryName = page1.getRow(i).getCell(0).toString();
                Assertions.assertEquals("Turkey", rowCountryName);
            }
        }


    }
}
