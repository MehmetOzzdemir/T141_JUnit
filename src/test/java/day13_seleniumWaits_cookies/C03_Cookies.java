package day13_seleniumWaits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void cookiesTest(){
        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        ReusableMethods.wait(10);

        //2- tum cookie’leri listeleyin
        Set<Cookie> allCookiesSet = driver.manage().getCookies();

        int siraNo = 1;
        for (Cookie eachCookie : allCookiesSet){
            System.out.println(siraNo+". "+eachCookie);
            siraNo++;
        }


        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assertions.assertTrue(allCookiesSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookie = "USD";
        String actualCookie = driver.manage().getCookieNamed("i18n-prefs")
                .getValue();
        Assertions.assertEquals(expectedCookie,actualCookie);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println("**********************");

        allCookiesSet = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie eachCookie : allCookiesSet){
            System.out.println(siraNo+". "+eachCookie);
            siraNo++;
        }


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        boolean iscikolatali = false;
        for (Cookie eachCookie :allCookiesSet ){
            if (eachCookie.getName().equals("en sevdigim cookie")){
                iscikolatali = true;
            }
        }
        Assertions.assertTrue(iscikolatali);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        //silinen cookie nin sette olmadigini test edin
        System.out.println("**********************");

        allCookiesSet = driver.manage().getCookies();
        boolean isDeletedCookie = false;
        siraNo = 1;
        for (Cookie eachCookie : allCookiesSet){
            System.out.println(siraNo+". "+eachCookie);
            if (eachCookie.getName().equals("skin")){
                isDeletedCookie = true;
            }
            siraNo++;
        }
        Assertions.assertFalse(isDeletedCookie);



        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        allCookiesSet = driver.manage().getCookies();
        Assertions.assertEquals(0,allCookiesSet.size());


    }
}
