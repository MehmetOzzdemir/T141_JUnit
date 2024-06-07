package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C06_DropdownMenu extends TestBase {
//    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
//            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//4.Tüm dropdown değerleri(value) yazdırın
//5. Dropdown’un boyutunun 4 olduğunu test edin


    @Test
    public void dropdownTest(){
        //    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownMenu =driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdownMenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
      ;

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownList = select.getOptions();
        System.out.println(ReusableMethods.StringListChange(dropdownList));


        //5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedOption = 4;
        int actualOption = select.getOptions().size();

        Assertions.assertEquals(expectedOption,actualOption);



        ReusableMethods.wait(2);
    }
}
