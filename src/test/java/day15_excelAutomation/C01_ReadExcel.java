package day15_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Ulkeler excel dosyasi web de olmadigindan
        // driver isimize yaramaz
        //bilgisarimizdaki bir dosyaya ulasmak icin
        //Java'daki FileInputStream Class ini kullanabiliriz
        //Javanindosyaya ulasip bilgilere ulasabilmesi icin doyaYolu ba ihtiyaci vardir

        String filePath = "src/test/java/day15_excelAutomation/ulkeler.xlsx";

        // 1.adim : fileInputStream objesi olusturalim
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //2.adim : fileInputStream in okudugu bilgileri
        //      classimizda olusturacagimiz bir workbook a yukleyelim

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        System.out.println(workbook);


        //ONEMLI NOT : workbook objesini nu class da biz olusturduk
        //dolayisiyla workbook <====> ulkeler excelidir demek YANLIS OLUR
        //godrusu su cumle
        //Java verilen dosya yolu sayesinde excel e ulasti
        //FileInputStream ile excel'deki tum bilgileri aldi
        //ve WorkbookFactory class indaki create()'u alinan bilgileri
        //kodumuz icinde EXCEL DOSYASININ KOPYASI olan "workbook" objesine yukledi

        //biz bu satirdan itibaren, excel dosyasi ile degil
        //onun kopyasi olan workbook ile calisacagiz
        //istedigimiz tum bilgileri woorkbook dan alacagiz

        // workbook dan istedigimiz sayfayi alip kaydedelim
        Sheet page1= workbook.getSheet("Sayfa1");

        //sheet dan istedigimiz satiri alip kaydedelim
        Row thirdRow =page1.getRow(2);

        //satir dan istedigmiz hucreyi alip kaydedelim
        Cell cell = thirdRow.getCell(1);

        System.out.println(cell);

        //Excel otomasyonunda kullandigimiz
        //sheet , row, cell index kullanişr yani degerler 0'dan baslar
        //satir icin i=3 sectigimizde index'i 3 olan 4. satiri getirir
        //cell icin i=2 sectigimizde index'i 2 olan 3. celli getirir



    }
}
