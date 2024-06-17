package day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class C05_DinamicFileExistTest {


    @Test
    public void test() {

        //masautumuzde karate-logo.png mli birdosya oldugunu test edin


        String sourcePath = "/Users/mehmetozdemir/Desktop/karate-logo.png";

        Assertions.assertTrue(Files.exists(Paths.get(sourcePath)));

        //Tum bilgisayarlarda tanimli bir dosya yolu vardir
        //Java bu temel dosya yolunu bize veren bir koda sahiptir

        System.out.println(System.getProperty("user.home")); ///Users/mehmetozdemir


        sourcePath = System.getProperty("user.home") + "/Desktop/karate-logo.png";


        Assertions.assertTrue(Files.exists(Paths.get(sourcePath)));


    }
}
