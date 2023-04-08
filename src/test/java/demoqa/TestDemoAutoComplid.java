package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class TestDemoAutoComplid {

@Test
    public void test(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://demoqa.com/auto-complete");


    WebElement input =driver.findElement(By.id("autoCompleteSingleInput"));
    input.sendKeys("R");
    List<WebElement> suggestions=driver.findElements(By.cssSelector("div.auto-complete__option"));

    for (WebElement suggestion:suggestions){

      String text=suggestion.getText();

        System.out.println(text);

        //if(text.toLowerCase().contains("r")){
          //  System.out.println(text + " has r letter.");
      if(text.equalsIgnoreCase("red"));
      suggestion.click();
      break;


        }



    }
}


