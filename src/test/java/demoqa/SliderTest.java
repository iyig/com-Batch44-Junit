package demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class SliderTest {

@Test
    public void test(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://demoqa.com/slider");


    WebElement slider=driver.findElement(By.cssSelector("input[type='range']"));

    Actions action= new Actions(driver);
    action.dragAndDropBy(slider,20,0).perform();


    WebElement valueUnderSlider=driver.findElement(By.cssSelector(".range-slider__tooltip__label"));
    String value=valueUnderSlider.getText();
    System.out.println("Recent value:" + value);//54

    WebElement sliderValue= driver.findElement(By.id("sliderValue"));
    String sliderValueText=sliderValue.getAttribute("value");
    System.out.println("slider Value:"  + sliderValueText);//54

    Assert.assertEquals(value,sliderValueText);
}



}
