package day16_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class C06_UnitTest {

    public boolean tekSayiKontrol(int controlNumber) {

        //verillen sayi tek say ise true cift sayi is false donduren bir method olusturun

        boolean result = controlNumber % 2 == 0 ? false : true;
        return result;


    }

    @Test
    public void unitTekSayiKontrol() {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i <100 ; i++) {
            int testNumber = random.nextInt();

            if (testNumber % 2 == 0) {
                Assertions.assertFalse(tekSayiKontrol(testNumber));
            } else {
                Assertions.assertTrue(tekSayiKontrol(testNumber));
                count++;
            }
        }
        System.out.println(count);

    }
}
