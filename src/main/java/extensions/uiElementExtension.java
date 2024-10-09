package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

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

    public static void performDragDrop(WebDriver driver,By fromlocator,By tolocator){

        //WebElement on which drag and drop operation needs to be performed
        WebElement fromElement = driver.findElement(fromlocator);

//WebElement to which the above object is dropped
        WebElement toElement = driver.findElement(tolocator);

//Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);

//Building a drag and drop action
        Action dragAndDrop = (Action) builder.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release(toElement)
                .build();

//Performing the drag and drop action
        dragAndDrop.perform();

    }


}
