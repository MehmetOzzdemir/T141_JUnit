package day15_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class C02_ReadExcel {


    @Test
    public void test1() throws IOException {
        //Gerekli adimlari atarak Sayfa1'e kadar ilerleyelim
        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");


        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Row row = page1.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("1.Row 2.Cell : " + cell);

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String _1Row2Cell = cell.toString();
        System.out.println("1.Row 2.Cell : " + _1Row2Cell);

        // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        row = page1.getRow(1);
        cell = row.getCell(3);
        String expectedText = "Kabil";
        String actualText = cell.toString();
        Assertions.assertEquals(expectedText, actualText);


        // - Satir sayisinin 191 bulalim
        //getLastRowNum() kulanilan son satirin indexinin bize verir
        int expectedRowNumber =191;
        int actualRowNumber = page1.getLastRowNum()+1;
        Assertions.assertEquals(expectedRowNumber,actualRowNumber);

        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan satir sayisi : "+page1.getPhysicalNumberOfRows());

        //getPhysicalNumberOfRows() bize fiziki olarak kullanilan satir sayisini verir
        //ONEMLI NOT : getLastRowNumber() arada bos olan satirlar olsada
        //              son kullanilan satira gider ve indexini bize getirir
        //              getPhysicalNumberOfRows() ise bos olan satirlari saymaz





    }
}
