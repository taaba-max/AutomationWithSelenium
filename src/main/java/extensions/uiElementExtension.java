package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class uiElementExtension {

    public static  void entertext(WebDriver driver,By locator, String  value){

        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys("admin@example.com");
    }

    public static  void performclick(WebDriver driver,By locator){
        driver.findElement(locator).click();
    }

    public static void dropdownselection(WebDriver driver,By locator,String option){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(option);



    }
}
