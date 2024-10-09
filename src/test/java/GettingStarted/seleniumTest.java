package GettingStarted;

import extensions.uiElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class seleniumTest {

    public static void main(String[] args) {

        //create webdriver from chrome driver to launch chrome
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com");


        driver.manage().window().fullscreen();

       // login(driver);

        //driver.navigate().to("https://the-internet.herokuapp.com");

        //dropdown(driver);

        //contextmenue(driver);

        DynamicControls(driver);


    }

    //login
    public static void login(WebDriver driver) {

        uiElementExtension.performclick(driver,By.linkText("Form Authentication"));

        uiElementExtension.entertext(driver,By.id("username"),"admin@example.com");

        uiElementExtension.entertext(driver,By.id("password"),"pass");

        uiElementExtension.performclick(driver,By.cssSelector("button[type='submit']"));

    }
    //drop down
    public static void dropdown(WebDriver driver) {

        uiElementExtension.performclick(driver,By.linkText("Dropdown"));

        uiElementExtension.dropdownselection(driver,By.id("dropdown"),"2");

    }
    //context  menue
    public static void contextmenue(WebDriver driver) {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement contextmenueBox = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        // Perform right-click (context click) on the box element
        actions.contextClick(contextmenueBox).perform();

        Alert alert = driver.switchTo().alert();

        alert.accept();

    }

   public static void DynamicControls(WebDriver driver){

       driver.get("https://the-internet.herokuapp.com/dynamic_controls");
       // Create an explicit wait
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       uiElementExtension.performclick(driver,By.xpath("//button[contains(text(),'Remove')]"));


       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

       uiElementExtension.performclick(driver,By.xpath("//button[contains(text(),'Add')]"));


       WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox")));


       checkbox.click();

       //ENABLE AND DISABLE

       WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
       enableButton.click();


       WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input")));


       textField.sendKeys("Selenium is working!");


       WebElement disableButton = driver.findElement(By.xpath("//button[contains(text(),'Disable')]"));
       disableButton.click();


       wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-example']/input"))));
   }
   //hello this is comment

    }













