package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBaseAll;

import java.util.List;

public class C05_DropdowMenu extends TestBaseAll {


    /*
            Dropdown OZEL BİR acilir menudur

            bir acilir menunun dropdown olup olmadigini
            asagidaki 2 sarti sagladigini kontrol etmeliyiz
            1-select tag i ile olusturulmalidir
            2-secim yapabilecegimiz opsiyonlar option tagi ile olusturulmalidir
     */

    @Test
    public void dropdownTest() {

        //    ● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form ");


        //            1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        WebElement dayDropdownElement = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectDay = new Select(dayDropdownElement);
        selectDay.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        WebElement monthDropDownElement = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectMonth = new Select(monthDropDownElement);
        selectMonth.selectByValue("nisan");


        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yearDropdownElement = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYear = new Select(yearDropdownElement);
        selectYear.selectByVisibleText("1990");


        //	4. Secilen değerleri konsolda yazdirin
        System.out.println(selectDay.getFirstSelectedOption().getText());
        System.out.println(selectMonth.getFirstSelectedOption().getText());
        System.out.println(selectYear.getFirstSelectedOption().getText());


        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        //System.out.println(monthDropDownElement.getText());
        List<WebElement> monthMenuAllOptionsElementList = selectMonth.getOptions();
        System.out.println(ReusableMethods.StringListChange(monthMenuAllOptionsElementList));


        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int exceptedOption = 13;
        int actualOption = monthMenuAllOptionsElementList.size();
        Assertions.assertEquals(exceptedOption, actualOption);


        // ReusableMethods.wait(3);


    }

}
