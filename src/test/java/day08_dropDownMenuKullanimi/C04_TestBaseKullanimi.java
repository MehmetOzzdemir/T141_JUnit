package day08_dropDownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseAll;

public class C04_TestBaseKullanimi extends TestBaseAll {


    @Test
    public void checkBoxTest() {

        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        //b. Checkbox1 ve checkbox2 elementlerini locate edin.

        WebElement checkBox1 = driver.findElement(By.xpath("//*[@*='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@*='checkbox'][2]"));


        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertTrue(checkBox2.isSelected());
    }
}
