package day16_getScreenShot;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {


    @Test
    public void test01() throws IOException {
        //3) Adimlari takip ederek Sayfa1’deki 1.satira kadar gidelim
        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");
        Row row = page1.getRow(0);

        //4) 5.hucreye yeni bir cell olusturalim
        Cell cell = row.createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        cell.setCellValue("Nüfus");

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        row = page1.getRow(1);
        cell = row.createCell(4);
        cell.setCellValue(150000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        row = page1.getRow(9);
        cell = row.createCell(4);
        cell.setCellValue(250000);

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        row = page1.getRow(14);
        cell = row.createCell(4);
        cell.setCellValue(54000);

        //9) Dosyayi kaydedelim
        //workbook uzerinde yaptigimiz degisiklikleri excel'e kaydetmek istedigimizde
        //  excel dosyasinin acik olmadigindan emin olup
        //  olusturacagimiz FileOutputStream objesi ile bilgileri excel'e kaydedebiliriz

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        //10)Dosyayi kapatalim
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();

    }
}
