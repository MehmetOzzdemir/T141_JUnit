package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistsTesti {

    @Test
    public void test01() {

        //day12 klasörünün altinda karate-logo.png dosyasinin oldugunu test edin

        // Selenium Webdriver ile calisir
        //Webdriver objesi olan driver ile istedigimiz sayfaya gider
        // istedigimiz WebElementi kullanir ,istedigimiz bilgileri aliriz

        //AMMA driver objemiz bilgisayarimizda mudahale edemez
        //bilgisayarimizdaki dosyalara erismek istersek
        // Java  dan yardim almaliyiz

        String dosyaYolu = "src/test/java/day12_fakerClass_fileTestleri/karate-logo.png";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
